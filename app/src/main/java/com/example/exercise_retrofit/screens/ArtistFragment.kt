package com.example.exercise_retrofit.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.exercise_retrofit.AppContainer
import com.example.exercise_retrofit.MyApplication
import com.example.exercise_retrofit.R
import com.example.exercise_retrofit.artist.ArtistViewModel
import kotlinx.android.synthetic.main.fragment_artist.*
import javax.inject.Inject

class ArtistFragment : Fragment(), View.OnClickListener {

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
        return inflater.inflate(R.layout.fragment_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        artistViewModel.artist.observe(viewLifecycleOwner, Observer {
            artistNameText.text = it.name
        })
        fetchButton.setOnClickListener(this)
    }

    fun getArtist() {
        artistViewModel.getArtist(artistIdInputText.text.toString())
    }

    override fun onClick(p0: View?) {
        when (p0) {
            fetchButton -> getArtist()
        }
    }
}