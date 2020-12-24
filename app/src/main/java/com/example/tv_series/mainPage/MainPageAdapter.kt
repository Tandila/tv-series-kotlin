package com.example.tv_series.mainPage


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tv_series.MainActivity.Companion.moviesGlobal
import com.example.tv_series.MainActivity2
import com.example.tv_series.R
import com.squareup.picasso.Picasso

class MainPageAdapter(private var images: List<String>): RecyclerView.Adapter<MainPageAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemPicture: ImageView = itemView.findViewById(R.id.tv_image)

        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                val intent: Intent = Intent(itemView.context, MainActivity2::class.java).apply {
                    putExtra("result", "$position")
                }
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(images[position]).fit().centerCrop().into(holder.itemPicture)
    }

}