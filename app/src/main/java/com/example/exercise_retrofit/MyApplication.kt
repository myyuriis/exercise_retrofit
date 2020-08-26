package com.example.exercise_retrofit

import android.app.Application

class MyApplication: Application() {
//    val appContainer: AppContainer = AppContainer()
    val applicationComponent: ApplicationComponent = DaggerApplicationComponent.create()
}