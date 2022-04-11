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
class MyViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {

    fun bind(myDataItem: MyDataItem) {
        val tvTitle = root.findViewById<TextView>(R.id.tvTitle)
        val tvDate = root.findViewById<TextView>(R.id.tvDate)
        val tvImage = root.findViewById<ImageView>(R.id.ivImage)

        tvTitle.text = myDataItem.title
        tvDate.text = myDataItem.date.toString()
        tvImage.setImageResource(myDataItem.imgId)
    }
}