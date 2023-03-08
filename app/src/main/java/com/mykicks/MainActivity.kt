package com.mykicks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mykicks.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val skListPurchased = ArrayList<Sneaker>()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var rvPurchasedSk: RecyclerView

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()

        setContentView(binding.root)

        binding.tvTest.text = "hoi"
        skListPurchased.addAll(getListSkPurchased())


    }

    private fun getListSkPurchased(): ArrayList<Sneaker> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataColor = resources.getStringArray(R.array.data_color)
        val dataDate = resources.getStringArray(R.array.data_date)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listSneaker = ArrayList<Sneaker>()

        for (i in dataName.indices) {
            val sk = Sneaker(dataName[i], dataDescription[i], dataColor[i], dataDate[i],dataPhoto.getResourceId(i, -1))
            listSneaker.add(sk)
        }
        return listSneaker
    }
}