package com.example.exercise_retrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.exercise_retrofit.AppContainer
import com.example.exercise_retrofit.MyApplication
import com.example.exercise_retrofit.R
import com.example.exercise_retrofit.artist.ArtistViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    @Inject lateinit var artistViewModel: ArtistViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as MyApplication).applicationComponent.inject(this)

        navController = (nav_host_fragment as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottom_navigation, navController)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.showArtist ->{
                    println("SHOW ARTIST")
                    navController.navigate(R.id.action_to_artistFragment)
                    true
                }
                R.id.createArtist ->{
                    println("CREATE ARTIST")
                    navController.navigate(R.id.action_to_createArtistFragment)
                    true
                }
                else -> {
                    println("MASUK ELSE")
                    true
                }
            }
        }
    }
}