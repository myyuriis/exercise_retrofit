package com.example.exercise_retrofit.artist

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistRepository(val artistAPI: ArtistAPI) {

    val artist: MutableLiveData<Artist> = MutableLiveData<Artist>()

    fun getArtist(id: String) {
        artistAPI.getArtistByID(id).enqueue(object: Callback<Artist> {
            override fun onFailure(call: Call<Artist>, t: Throwable) {
                println(t.localizedMessage)
            }
            override fun onResponse(call: Call<Artist>, response: Response<Artist>) {
                artist.value = response.body()
            }
        })
    }

    fun saveArtist(artist: Artist){
        artistAPI.createArtist(artist).enqueue(object : Callback<Artist>{
            override fun onFailure(call: Call<Artist>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Artist>, response: Response<Artist>) {
                if(response.code() == 200){
                    println("SUCCESS")
                }
            }
        })
    }
}