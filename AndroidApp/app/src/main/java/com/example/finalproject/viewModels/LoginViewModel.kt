package com.example.finalproject.viewModels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.models.LoginModel
import java.net.Socket

class LoginViewModel : BaseObservable() {
    private val loginModel = LoginModel()

    @Bindable
    var username = MutableLiveData<String>()

    @Bindable
    var password = MutableLiveData<String>()

    private val usernameMediator = MediatorLiveData<String>().apply {
        addSource(username) { value ->
            setValue(value)
            updateUsername(value)
        }
    }.also { it.observeForever { /* empty */ } }

    private val passwordMediator = MediatorLiveData<String>().apply {
        addSource(password) { value ->
            setValue(value)
            updatePassword(value)
        }
    }.also { it.observeForever { /* empty */ } }

    private fun updatePassword(value: String) {
        loginModel.password = value
    }

    private fun updateUsername(value: String) {
        loginModel.username = value
    }

    fun tryToLogin() {
        println("Inside VM: ${username.value}")
        println("Inside VM: ${password.value}")
        this.loginModel.tryToConnect()
    }


}