package com.example.finalproject.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.finalproject.R
import com.example.finalproject.databinding.LoginPageBinding
import com.example.finalproject.viewModels.LoginViewModel

class MainActivity : AppCompatActivity() {

    private var viewmodel : LoginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        val binding: LoginPageBinding  = DataBindingUtil.setContentView(
            this, R.layout.login_page)

        binding.viewmodel = this.viewmodel
    }
}