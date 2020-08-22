package com.example.exercise_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.exercise_retrofit.artist.ArtistViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val artistViewModel by viewModels<ArtistViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        artistViewModel.artist.observe(this, Observer {
            artistNameText.text = it.name
        })
    }

    fun getArtist(view: View) {
        artistViewModel.getArtist(artistInputText.text.toString())
    }
}