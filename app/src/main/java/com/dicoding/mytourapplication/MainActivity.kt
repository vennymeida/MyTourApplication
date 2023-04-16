package com.dicoding.mytourapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvTours: RecyclerView
    private val list = ArrayList<Tour>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTours = findViewById(R.id.rv_tours)
        rvTours.setHasFixedSize(true)

        list.addAll(getListTours())
        showRecyclerList()
    }

    private fun getListTours(): ArrayList<Tour> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listTour = ArrayList<Tour>()
        for (i in dataName.indices) {
            val tour = Tour(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listTour.add(tour)
        }
        return listTour
    }

    private fun showRecyclerList() {
        rvTours.layoutManager = LinearLayoutManager(this)
        val listTourAdapter = ListTourAdapter(list)
        rvTours.adapter = listTourAdapter
    }
}