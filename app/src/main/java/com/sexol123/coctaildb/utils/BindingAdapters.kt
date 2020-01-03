package com.sexol123.coctaildb.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sexol123.coctaildb.R
import com.squareup.picasso.Picasso

@BindingAdapter("android:srcImage")
fun setImageViewPicasso(imageView: ImageView, resource: String) {
    Picasso.get().load(resource).placeholder(R.drawable.circle).into(imageView)
}