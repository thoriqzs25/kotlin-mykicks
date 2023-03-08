package com.mykicks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mykicks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()

        setContentView(binding.root)

        binding.tvTest.text = "hoi"
    }
}