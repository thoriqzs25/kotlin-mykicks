package com.mykicks

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.mykicks.databinding.ActivityKicksDetailBinding

class KicksDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKicksDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kicks_detail)

        binding = ActivityKicksDetailBinding.inflate(layoutInflater)

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("DATA", Sneaker::class.java)
        } else {
            intent.getParcelableExtra("DATA")
        }

        val test: TextView = findViewById(R.id.tv_kick_name)


        test.text = "test woi"
        if (data != null) {
            binding.tvKickName.text = data.name
            binding.tvHarga.text = data.price
            binding.tvWarna.text = data.color
            binding.tvTanggalBeli.text = data.date
            binding.tvDeskripsi.text = data.description
        }

        if (data?.photo != null) {
            binding.ivKickImg.setImageResource(data.photo)
        }
    }
}