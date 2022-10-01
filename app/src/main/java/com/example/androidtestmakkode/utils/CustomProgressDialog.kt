package com.example.androidtestmakkode.utils

import android.app.Activity
import android.app.AlertDialog
import com.example.androidtestmakkode.databinding.LoadingItemBinding

class CustomProgressDialog(private val activity: Activity) {

    private var binding : LoadingItemBinding
    private var mProgressDialog: AlertDialog


    init {
        activity.let {

            binding = LoadingItemBinding.inflate(activity.layoutInflater)

            val builder = AlertDialog.Builder(it)
            builder.setView(binding.root)
            builder.setCancelable(false)
            mProgressDialog = builder.create()
    }
  }

    fun showProgressDialog(){
        mProgressDialog.show()
    }

    fun hideProgressDialog(){
        mProgressDialog.dismiss()
    }
}