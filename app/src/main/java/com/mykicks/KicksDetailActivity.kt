package com.mykicks

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.mykicks.databinding.ActivityKicksDetailBinding

class KicksDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kicks_detail)

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("DATA", Sneaker::class.java)
        } else {
            intent.getParcelableExtra("DATA")
        }

        val toolbarLayout: Toolbar = findViewById(R.id.my_toolbar)
        toolbarLayout.setOnClickListener {
            finish()
        }

        val shareBtn: ImageButton = findViewById(R.id.ib_share)
        shareBtn.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Heyoooo, check out this shoe! It has ${data?.color}, I bought it since ${data?.date}");
            startActivity(Intent.createChooser(shareIntent,getString(R.string.app_name)))
        }

        val tvKickName: TextView = findViewById(R.id.tv_kick_name)
        val tvHarga: TextView = findViewById(R.id.tv_harga)
        val tvWarna: TextView = findViewById(R.id.tv_warna)
        val tvTanggalBeli: TextView = findViewById(R.id.tv_tanggal_beli)
        val tvDeskripsi: TextView = findViewById(R.id.tv_deskripsi)
        val ivKickImg: ImageView = findViewById(R.id.iv_kick_img)

        if (data != null) {
            tvKickName.text = data.name
            tvHarga.text = data.price
            tvWarna.text = data.color
            tvTanggalBeli.text = data.date
            tvDeskripsi.text = data.description
        }

        if (data?.photo != null) {
            ivKickImg.setImageResource(data.photo)
        }
    }
}