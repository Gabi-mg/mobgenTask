package com.mobgen.task.app.ui

import android.content.Intent
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mobgen.task.app.session.Preferences
import com.mobgen.task.app.session.Session
import com.mobgen.task.app.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModel()

    override fun onStart() {
        super.onStart()

        if(Session.getString(this, Preferences.CATEGORIES, "").isBlank()){
            initObserver()
        }
        else{
            goToMain()
        }
    }

    private fun initObserver() {
        viewModel.runCategories()
        viewModel.categories.observe(this, Observer { list ->
            Session.setString(this, Preferences.CATEGORIES, Utils.toJson(list))
            goToMain()
        })
        viewModel.errorMessage.observe(this, Observer { error ->
            Toast.makeText(this, error, LENGTH_LONG ).show()
        })
    }

    private fun goToMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}