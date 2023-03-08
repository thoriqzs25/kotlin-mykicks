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
    private val skListWishlist = ArrayList<Sneaker>()

    private lateinit var rvPurchasedSk: RecyclerView
    private lateinit var rvWishlistSk: RecyclerView

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()

        setContentView(binding.root)

        binding.icProfile.setOnClickListener {
            val intent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        rvPurchasedSk = binding.rvSkList
        rvWishlistSk = binding.rvSkListWl

        rvPurchasedSk.setHasFixedSize(true)
        rvWishlistSk.setHasFixedSize(true)

        skListPurchased.addAll(getListSkPurchased())
        skListWishlist.addAll(getListSkWishlist())

        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvPurchasedSk.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        rvWishlistSk.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)

        val listPurchasedSkAdapter = ListPurchasedSkAdapter(skListPurchased, onClick = {
            val intent = Intent(this@MainActivity, KicksDetailActivity::class.java)
            intent.putExtra("DATA", it)
            startActivity(intent)
        })

        val listWishlistSkAdapter = ListWishlistSkAdapter(skListWishlist, onClick = {
            val intent = Intent(this@MainActivity, KicksDetailActivity::class.java)
            intent.putExtra("DATA", it)
            startActivity(intent)
        })

        rvPurchasedSk.adapter = listPurchasedSkAdapter
        rvWishlistSk.adapter = listWishlistSkAdapter
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

    private fun getListSkWishlist(): ArrayList<Sneaker> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataColor = resources.getStringArray(R.array.data_color)
        val dataDate = resources.getStringArray(R.array.data_date)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listSneaker = ArrayList<Sneaker>()

        for (i in dataName.indices) {
            val sk = Sneaker(dataName[dataName.size-1-i], dataColor[dataName.size-1-i], dataPrice[dataName.size-1-i], dataDate[dataName.size-1-i], dataPhoto.getResourceId(dataName.size-1-i, -1), dataDescription[dataName.size-1-i])
            listSneaker.add(sk)
        }
        return listSneaker
    }
}