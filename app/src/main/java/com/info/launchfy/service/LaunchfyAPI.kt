package com.info.launchfy.service


import com.info.launchfy.model.*
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface LaunchfyAPI {

        //  apiUrl = 'https://localhost:44366/api/Cars/';    let newPath = this.apiUrl + "getall";

    @GET("/Events/geteventsofattendee")
    fun getEventDtos():Call<EventResult>


    @POST("/Feedback/add")
    fun addFeedback(@Field("Feedback") feedback: Feedback):Call<SuccessResult>

    @GET("/Photos/getphotosbycarid")
    fun getphotos():Call<PhotoResult>


}