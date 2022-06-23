package com.al.kotlin01helloworld.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.al.kotlin01helloworld.R
import com.al.kotlin01helloworld.model.WebImage

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/06/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ImageListAdapter(private val imageList: ArrayList<WebImage>) :
    RecyclerView.Adapter<ImageListAdapter.ImageViewHolder>() {

    class ImageViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageUrl: TextView = itemView.findViewById(R.id.tvImageUrl)
        private val webImageView: ImageView = itemView.findViewById(R.id.webImageView)

        fun bind(imageData: WebImage) {
            imageUrl.text = imageData.url
            webImageView.setImageBitmap(imageData.image)
        }

        companion object {
            fun from(parent: ViewGroup): ImageViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val root = layoutInflater.inflate(R.layout.image_list_item, parent, false)
                return ImageViewHolder(root)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {
        return ImageViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val webImage = imageList[position]
        holder.bind(webImage)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    fun clear() {
        imageList.clear()
        notifyDataSetChanged()
    }
}