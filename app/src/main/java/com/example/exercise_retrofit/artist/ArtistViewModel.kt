package com.example.exercise_retrofit.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.exercise_retrofit.config.RetrofitBuilder
import javax.inject.Inject

class ArtistViewModel @Inject constructor(val artistRepository: ArtistRepository) {

    val artist: LiveData<Artist> = artistRepository.artist

    fun getArtist(id: String) {
        artistRepository.getArtist(id)
    }

    fun saveArtist(artist: Artist) {
        artistRepository.saveArtist(artist)
    }
}