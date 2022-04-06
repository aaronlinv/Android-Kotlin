package com.al.kotlin01helloworld

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@BindingAdapter("showImage")
fun loadImage(view: ImageView, imageUrl: String) {
    if (imageUrl.isEmpty()) {
        return
    }
    Glide.with(view.context)
        .load(imageUrl)
        .into(view)
}