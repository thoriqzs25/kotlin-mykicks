package com.mykicks

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mykicks.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val skListPurchased = ArrayList<Sneaker>()
    private lateinit var rvPurchasedSk: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()

        setContentView(binding.root)

        rvPurchasedSk = binding.rvSkList
        rvPurchasedSk.setHasFixedSize(true)

        skListPurchased.addAll(getListSkPurchased())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvPurchasedSk.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)

        val listPurchasedSkAdapter = ListPurchasedSkAdapter(skListPurchased, onClick = {
            val intent = Intent(this@MainActivity, KicksDetailActivity::class.java)
            intent.putExtra("DATA", it)
            startActivity(intent)
        })

        rvPurchasedSk.adapter = listPurchasedSkAdapter
    }

    private fun getListSkPurchased(): ArrayList<Sneaker> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataColor = resources.getStringArray(R.array.data_color)
        val dataDate = resources.getStringArray(R.array.data_date)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listSneaker = ArrayList<Sneaker>()

        for (i in dataName.indices) {
            val sk = Sneaker(dataName[i], dataColor[i], dataPrice[i], dataDate[i], dataPhoto.getResourceId(i, -1), dataDescription[i])
            listSneaker.add(sk)
        }
        return listSneaker
    }
}