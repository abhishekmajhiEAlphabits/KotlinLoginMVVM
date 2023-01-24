package com.example.kotlinloginmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinloginmvvm.databinding.ActivityMainBinding
import com.example.kotlinloginmvvm.ui.LoginViewModel

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    var viewmodel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding?.viewModel = viewmodel


        setUpViewModel()

    }

    fun setUpViewModel() {
        viewmodel?.userLogin?.observe(this, Observer {
            Toast.makeText(this, "welcome, ${it}", Toast.LENGTH_LONG).show()

        })

    }
}