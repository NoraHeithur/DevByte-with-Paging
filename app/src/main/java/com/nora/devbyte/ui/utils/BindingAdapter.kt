package com.nora.devbyte.ui.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.nora.devbyte.R

@BindingAdapter("setImageSrc")
fun setImageSrc(imageView: AppCompatImageView, url: String) {
    imageView.load(url) {
        error(R.drawable.ic_round_broken_image)
    }
}