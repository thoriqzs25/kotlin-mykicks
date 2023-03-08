package com.mykicks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val toolbarLayout: Toolbar = findViewById(R.id.my_toolbar)
        toolbarLayout.setOnClickListener {
            finish()
        }

    }
}