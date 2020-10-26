package com.example.cleanlogin.core.di

import com.example.cleanlogin.ui.main.viewmodel.LoginViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { LoginViewModel(get()) }
}