package com.example.cleanlogin.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.cleanlogin.data.entities.User


class MainViewModel (application: Application): BaseViewModel(application) {


     val _login=MutableLiveData<User>()

   fun bindLogin(user:User){
       _login.value=user
    }


}