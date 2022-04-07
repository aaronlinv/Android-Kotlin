package com.al.kotlin01helloworld

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyDataAdapter(private val data: List<MyData>) : RecyclerView.Adapter<MyDataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDataViewHolder {
        return MyDataViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyDataViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class MyDataViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvInfo: TextView = itemView.findViewById(R.id.tvInfo)
    private val tvValue: TextView = itemView.findViewById(R.id.tvValue)

    fun bind(item: MyData) {
        tvInfo.text = item.info
        tvValue.text = item.value.toString()
        if (item.value < 60) {
            tvValue.setTextColor(Color.RED)
        } else {
            tvValue.setTextColor(Color.BLUE)
        }
    }

    companion object {
        fun from(parent: ViewGroup): MyDataViewHolder {
            val layoutInflate = LayoutInflater.from(parent.context)
            val root = layoutInflate.inflate(R.layout.list_item, parent, false)
            return MyDataViewHolder(root)
        }
    }
}