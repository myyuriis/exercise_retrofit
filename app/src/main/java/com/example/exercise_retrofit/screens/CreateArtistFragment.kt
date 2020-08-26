package com.example.exercise_retrofit.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exercise_retrofit.MyApplication
import com.example.exercise_retrofit.R
import com.example.exercise_retrofit.artist.Artist
import com.example.exercise_retrofit.artist.ArtistViewModel
import kotlinx.android.synthetic.main.fragment_create_artist.*
import javax.inject.Inject

class CreateArtistFragment : Fragment(), View.OnClickListener {

    @Inject lateinit var artistViewModel: ArtistViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity?.applicationContext as MyApplication).applicationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            submitButton -> {
                val artist = Artist (
                    name = artistnameInputText.text.toString(),
                    username = artistBornPlaceInputText.text.toString(),
                    email = artistDebutInputText.text.toString()
                )
                artistViewModel.saveArtist(artist)
            }
        }
    }
}