package com.al.kotlin01helloworld

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    private val imageView = view.findViewById<ImageView>(R.id.imageView)

    // 使用特定 UI 控件显示 ImageItem 内容
    fun bind(item: ImageItem) {
        tvTitle.text = item.title
        imageView.setImageResource(item.imageId)
    }
}