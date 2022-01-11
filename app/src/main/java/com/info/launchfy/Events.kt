package com.info.launchfy


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.info.launchfy.model.Car

class Events : AppCompatActivity() {

    private lateinit var carsArrayList: ArrayList<Car>
    private lateinit var adapter: CarsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)


        val rvEvents = findViewById<View>(R.id.rv) as RecyclerView
        rvEvents.setHasFixedSize(true)
        rvEvents.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)



        val c1 = Car(1, "C180", "Lisbon", "c180")
        val c2 = Car(2, "E180", "Mallorca", "e180")
        val c3 = Car(3, "G63", "Istanbul", "g63")


        carsArrayList = ArrayList<Car>()
        carsArrayList.add(c1)
        carsArrayList.add(c2)
        carsArrayList.add(c3)


        adapter = CarsAdapter(this,carsArrayList)

        rvEvents.adapter = adapter
        adapter.setOnItemClickListener(object : CarsAdapter.onItemClickListener{


            override fun onItemClick(position: Int) {

                val Intent = Intent(this@Events, CommentActivity::class.java)
                startActivity(Intent)
            }


        })

    }

}