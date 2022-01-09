package com.info.launchfy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class Events : AppCompatActivity() {

    private lateinit var carsArrayList: ArrayList<Cars>
    private lateinit var adapter: CarsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)


        val rvEvents = findViewById<View>(R.id.rv) as RecyclerView
        rvEvents.setHasFixedSize(true)
        rvEvents.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)



        val c1 = Cars(1,"C180","Lisbon","c180")
        val c2 = Cars(2,"E180","Mallorca","e180")
        val c3 = Cars(3,"G63","Istanbul","g63")


        carsArrayList = ArrayList<Cars>()
        carsArrayList.add(c1)
        carsArrayList.add(c2)
        carsArrayList.add(c3)


        adapter = CarsAdapter(this,carsArrayList)

        rvEvents.adapter = adapter

    }

}