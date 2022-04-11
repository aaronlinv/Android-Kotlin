package com.al.kotlin01helloworld

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyDataAdapter(private val dataList: List<IMyData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // 查询要显示的对象类型
    override fun getItemViewType(position: Int): Int {
        val item = dataList[position]
        if (item is TextData) {
            return TEXT_VIEW_TYPE
        } else if (item is ImageData) {
            return IMAGE_VIEW_TYPE
        }
        return UNKNOWN_VIEW_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val textVH = TextViewHolder(inflater.inflate(R.layout.text_item, parent, false))
        val imageVH = ImageViewHolder(inflater.inflate(R.layout.image_item, parent, false))

        val vh = when (viewType) {
            TEXT_VIEW_TYPE -> textVH
            IMAGE_VIEW_TYPE -> imageVH
            else -> textVH
        }
        return vh
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        if (holder is TextViewHolder) {
            holder.bind(item)
        } else if (holder is ImageViewHolder) {
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}