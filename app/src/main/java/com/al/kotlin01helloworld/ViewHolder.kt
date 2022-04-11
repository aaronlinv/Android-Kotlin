package com.al.kotlin01helloworld

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
const val TEXT_VIEW_TYPE = 1
const val IMAGE_VIEW_TYPE = 2
const val UNKNOWN_VIEW_TYPE = -1

class TextViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
    fun bind(item: IMyData) {
        val tvContent = root as TextView
        if (item is TextData) {
            tvContent.text = item.context
        } else {
            tvContent.text = item.toString()
        }
    }
}

class ImageViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
    fun bind(item: IMyData) {
        val imageView = root.findViewById<ImageView>(R.id.imageView)
        if (item is ImageData) {
            imageView.setImageResource(item.imgResId)
        } else {
            imageView.setImageResource(R.drawable.ic_launcher_foreground)
        }
    }
}