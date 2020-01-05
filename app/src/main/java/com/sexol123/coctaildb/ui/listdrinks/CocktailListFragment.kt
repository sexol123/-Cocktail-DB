package com.sexol123.coctaildb.ui.listdrinks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sexol123.coctaildb.R
import com.sexol123.coctaildb.databinding.CoctailListFragmentBinding
import com.sexol123.coctaildb.ui.itemdetailed.DrinkDetailedFragment
import com.sexol123.coctaildb.ui.itemdetailed.DrinkDetailedViewModel
import kotlinx.android.synthetic.main.coctail_list_fragment.*
import kotlinx.android.synthetic.main.coctail_list_fragment.view.*

class CocktailListFragment : Fragment() {
    private lateinit var viewModel: CocktailListViewModel
    private lateinit var mBinding: CoctailListFragmentBinding
    private lateinit var mLayoutManager: LinearLayoutManager
    private val mAdapter = CocktailListAdapter()
    private lateinit var drinkListViewModel: DrinkDetailedViewModel
    private val taged = this::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.coctail_list_fragment, container, false)
        mBinding.lifecycleOwner = this.viewLifecycleOwner
        viewModel =
            ViewModelProviders.of(this.requireActivity()).get(CocktailListViewModel::class.java)
        mBinding.vm = viewModel

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initListeners()
        initObservers()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        drinkListViewModel =
            ViewModelProviders.of(this.requireActivity()).get(DrinkDetailedViewModel::class.java)
        mAdapter.setOnClickAction {
            drinkListViewModel.getDetailedById(it)
            viewModel.goToDetailedScreen()
        }

        if (savedInstanceState == null || viewModel.mUpdateData.value == null) { //first time start
            viewModel.getAllCategoriesAndShowFirstList()
        }
    }

    private fun initObservers() {
        viewModel.screenState.observe(this.viewLifecycleOwner, Observer { state ->
            when (state) {
                is CoctailListScreenState.ShowDrinkDetail -> {
                    requireFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, DrinkDetailedFragment(), taged)
                        .addToBackStack(taged)
                        .commit()
                    viewModel.cleanState()
                }

                is CoctailListScreenState.ShowLoading -> {
                    showLoading()
                }

                is CoctailListScreenState.HideLoading -> {
                    hideLoading()
                }
                else -> {
                }
            }
        })

        viewModel.mUpdateData.observe(this.viewLifecycleOwner, Observer {
            mAdapter.updateData(it)
        })
    }

    private fun initListeners() {
        view?.recycler_view?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, amountVertical: Int) {
                val visibleItemCount = mLayoutManager.childCount
                val totalItemCount = mLayoutManager.itemCount
                val firstVisible = mLayoutManager.findFirstVisibleItemPosition()
                if (amountVertical > 0) {
                    if ((visibleItemCount + firstVisible) >= totalItemCount) {
                        viewModel.getDrinksNext()
                    }
                }
            }
        })
    }

    private fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        loading.visibility = View.GONE
    }

    private fun initUI() {
        mLayoutManager = LinearLayoutManager(context)
        view?.recycler_view?.let {
            it.adapter = mAdapter
            it.layoutManager = mLayoutManager
        }
    }
}