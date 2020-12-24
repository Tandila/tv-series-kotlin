package com.example.tv_series.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tv_series.MainActivity2.Companion.detailedMovie
import com.example.tv_series.R
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

/**
 * A placeholder fragment containing a simple view.
 */
class Info : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_info, container, false)
        val detailedImage: ImageView = root.findViewById(R.id.DetailedImage)
        val title:TextView = root.findViewById(R.id.OriginTitle)
        val date:TextView = root.findViewById(R.id.releaseDate)
        val language:TextView = root.findViewById(R.id.Language)
        val seasons:TextView = root.findViewById(R.id.Seasons)

        Picasso.get().load(detailedMovie.imageUrl).into(detailedImage)

        title.text = detailedMovie.title
        date.text = detailedMovie.date
        language.text = detailedMovie.language
        seasons.text = detailedMovie.seasons.toString()

        return root
    }

}