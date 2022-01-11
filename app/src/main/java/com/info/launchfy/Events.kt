package com.info.launchfy


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.info.launchfy.model.*
import com.info.launchfy.service.ApiUtils
import com.info.launchfy.service.LaunchfyAPIService
import io.reactivex.rxjava3.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Events : AppCompatActivity() {

    private lateinit var carsArrayList: ArrayList<Car>
    private lateinit var adapter: CarsAdapter

    private lateinit var events:MutableLiveData<List<EventDto>>
    private val disposable=CompositeDisposable()
    private val launchfyAPI=LaunchfyAPIService()


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

    private  fun getPhotos(){

        val apiService=ApiUtils.getApiService()
        apiService.getphotos().enqueue(object :Callback<PhotoResult>{
            override fun onFailure(call: Call<PhotoResult>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<PhotoResult>?, response: Response<PhotoResult>?) {
                if(response?.body()!!.success){
                    Log.e("Başarı",response.body().photos[0].url)
                }
            }

        })
    }



    private  fun addFeedBack(){
        var feedback:Feedback= Feedback(1,2,3,4,0.0,"deneme",12)

        val apiService=ApiUtils.getApiService()

        apiService.addFeedback(feedback).enqueue(object :Callback<SuccessResult>{
            override fun onFailure(call: Call<SuccessResult>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<SuccessResult>?, response: Response<SuccessResult>?) {
                if(response?.body()!!.success){
                    Log.e("Başarı",response.body().message.toString())
                }
            }

        })
    }
    private fun getDataFromAPI(){
        val apiService=ApiUtils.getApiService()
        apiService.getEventDtos().enqueue(object :Callback<EventResult>{
            override fun onFailure(call: Call<EventResult>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<EventResult>?, response: Response<EventResult>?) {
                if(response?.body()!!.success){
                    Log.e("Başarı",response.body().event[0].carName)
                }
            }

        })
    }

}