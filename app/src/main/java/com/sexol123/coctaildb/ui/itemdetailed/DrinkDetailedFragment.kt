package com.sexol123.coctaildb.ui.itemdetailed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.sexol123.coctaildb.R
import com.sexol123.coctaildb.databinding.DrinkDetailedFragmentBinding

class DrinkDetailedFragment : Fragment() {

    private lateinit var viewModel: DrinkDetailedViewModel
    private lateinit var mBinding: DrinkDetailedFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.drink_detailed_fragment, container, false)
        mBinding.lifecycleOwner = this.viewLifecycleOwner
        viewModel =
            ViewModelProviders.of(this.requireActivity()).get(DrinkDetailedViewModel::class.java)
        mBinding.vm = viewModel

        return mBinding.root
    }
}
