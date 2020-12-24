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
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
//        val textView: TextView = root.findViewById(R.id.section_label)
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

        pageViewModel.text.observe(this, Observer<String> {

        })
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}