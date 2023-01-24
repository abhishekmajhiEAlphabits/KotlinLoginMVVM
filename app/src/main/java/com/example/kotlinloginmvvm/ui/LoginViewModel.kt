package com.example.kotlinloginmvvm.ui

import android.util.Log
import android.widget.Toast
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinloginmvvm.network.BackendApi
import com.example.kotlinloginmvvm.network.LoginResponse
import com.example.kotlinloginmvvm.network.WebServiceClient
import com.example.kotlinloginmvvm.util.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class LoginViewModel : ViewModel(), Callback<LoginResponse> {

    var btnSelected: ObservableBoolean? = ObservableBoolean(false)

    var _email: ObservableField<String>? = ObservableField("")
    //val email: LiveData<String> = _email

    var _password: ObservableField<String>? = ObservableField("")
    //val password: LiveData<String> = _password

    var _userLogin: MutableLiveData<String>? = MutableLiveData<String>()
    var userLogin: LiveData<String>? = _userLogin

    fun onEmailChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        btnSelected?.set(Util.isEmailValid(s.toString()) && _password?.get()!!.length >= 8)


    }

    fun onPasswordChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        btnSelected?.set(Util.isEmailValid(_email?.get()!!) && s.toString().length >= 8)


    }

    fun login() {
        Log.d("TAG", _email?.get()!! + _password?.get()!!)
        WebServiceClient.client().create(BackendApi::class.java)
            .LOGIN(email = _email?.get()!!, password = _password?.get()!!)
            .enqueue(this)

    }

    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
        _userLogin?.value = response.body()?.token
        Log.d("TAG", "success" + response.body())
    }

    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
        //Toast.makeText(this, "failed", Toast.LENGTH_LONG).show()
        Log.d("TAG", "Failed")
    }


}