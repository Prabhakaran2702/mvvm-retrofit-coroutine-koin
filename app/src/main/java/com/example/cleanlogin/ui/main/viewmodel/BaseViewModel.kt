package com.example.cleanlogin.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(application: Application): AndroidViewModel(application) {

//    private val job = Job()
//
//    override val coroutineContext: CoroutineContext
//        get() = job + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
       // job.cancel()
    }
}