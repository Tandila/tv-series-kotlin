package com.example.tv_series.ui.main


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tv_series.R
import com.squareup.picasso.Picasso

class CastAdapter(private var castName: List<String>, private var castPlay: List<String>, private var images: List<String>):
    RecyclerView.Adapter<CastAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemCastName: TextView = itemView.findViewById(R.id.cast_name)
        val itemCastPlay: TextView = itemView.findViewById(R.id.cast_play)
        val itemImages: ImageView = itemView.findViewById(R.id.cast_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cast_item,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemCastName.text = castName[position]
        holder.itemCastPlay.text = castPlay[position]
        Picasso.get().load(images[position]).into(holder.itemImages)
    }

    override fun getItemCount(): Int {
        return castName.size
    }
}