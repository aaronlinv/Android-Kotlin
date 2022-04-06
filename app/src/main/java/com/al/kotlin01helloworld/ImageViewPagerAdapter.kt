package com.al.kotlin01helloworld

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ImageViewPagerAdapter(private val images: List<ImageItem>) :
    RecyclerView.Adapter<ImageViewHolder>() {
    // 实例化 ViewHolder 对象，运行时只会创建有限次
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        // 加载布局文件
        val root = LayoutInflater.from(parent.context).inflate(
            R.layout.image_container,
            parent,
            false
        )
        // 实例化对象
        return ImageViewHolder(root)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        // 特定位置显示的图片
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}