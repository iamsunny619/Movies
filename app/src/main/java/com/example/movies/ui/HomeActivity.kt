package com.example.movies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.movies.R
import com.example.movies.ui.utils.AppUtils
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewSetUp()
    }

    private fun viewSetUp() {
        AppUtils.setTransparentStatusColor(this, true, R.color.red_cc0000)
    }
}