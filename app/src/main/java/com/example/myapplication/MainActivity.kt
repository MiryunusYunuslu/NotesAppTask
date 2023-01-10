package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigationUI.setupActionBarWithNavController(
            this,
            findNavController(R.id.fragmentContainerView)
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return  findNavController(R.id.fragmentContainerView).navigateUp() || super.onSupportNavigateUp()
    }

}