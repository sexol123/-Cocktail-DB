package com.sexol123.coctaildb.ui.listdrinks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sexol123.coctaildb.R
import com.sexol123.coctaildb.data.model.UiDrinkBase
import com.sexol123.coctaildb.data.model.UiDrinkCategory
import com.sexol123.coctaildb.data.model.UiDrinkItem
import com.sexol123.coctaildb.databinding.ItemBodyCocktailsBinding
import com.sexol123.coctaildb.databinding.ItemTitleCocktailBinding

private const val DRINK_CATEGORY = 0
private const val DRINK_ITEM = 1

class CocktailListAdapter(private var mDrinkList: List<UiDrinkBase> = ArrayList())
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onClickAction: ((id: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            DRINK_ITEM -> {
                CocktailBodyHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_body_cocktails, parent, false)
                )
            }
            DRINK_CATEGORY -> {
                CocktailCategoryHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_title_cocktail, parent, false)
                )
            }
            else -> throw Exception("Unknown viewType for holder")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (mDrinkList[position]) {
            is UiDrinkCategory -> DRINK_CATEGORY
            is UiDrinkItem -> DRINK_ITEM
            else -> throw Exception("Type unknown")
        }
    }

    override fun getItemCount(): Int = mDrinkList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is CocktailCategoryHolder -> {
                holder.binding.model = (mDrinkList[position] as UiDrinkCategory)
            }
            is CocktailBodyHolder ->  {
                val cocktailItem = (mDrinkList[position] as UiDrinkItem)
                holder.binding.model = cocktailItem
                holder.itemView.setOnClickListener {
                    this.onClickAction?.invoke(cocktailItem.idDrink)
                }
            }
        }
    }

    fun setOnClickAction(newOnClickAction: (id: String) -> Unit) {
        onClickAction = newOnClickAction
    }

    fun updateData(list: List<UiDrinkBase>) {
        mDrinkList = list
        notifyDataSetChanged()
    }
}

class CocktailBodyHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemBodyCocktailsBinding.bind(view)!!
}

class CocktailCategoryHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemTitleCocktailBinding.bind(view)!!
}