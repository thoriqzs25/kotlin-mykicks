package com.mykicks

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val toolbarLayout: Toolbar = findViewById(R.id.my_toolbar)
        toolbarLayout.setOnClickListener {
            finish()
        }

        val linkedInIc: ImageButton = findViewById(R.id.ic_linkedin)
        val instagramIc: ImageButton = findViewById(R.id.ic_instagram)

        linkedInIc.setOnClickListener(this)
        instagramIc.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val url = when (v?.id) {
            R.id.ic_linkedin -> "https://www.linkedin.com/in/thariqzs/"
            R.id.ic_instagram -> "https://www.instagram.com/thariqzs/"
            else -> {
                Log.d("thoriq", "onClick: not found")}
        }

        val webIntent: Intent = Uri.parse(url.toString()).let { webpage ->
            Intent(Intent.ACTION_VIEW, webpage)
        }

        startActivity(webIntent)
    }
}