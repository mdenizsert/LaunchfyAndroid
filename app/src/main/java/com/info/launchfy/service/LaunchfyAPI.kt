package com.info.launchfy.service


import com.info.launchfy.model.*
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface LaunchfyAPI {

        //  apiUrl = 'https://localhost:44366/api/Cars/';    let newPath = this.apiUrl + "getall";

    @GET("/Events/geteventsofattendee")
    fun getEventDtos():Single<List<EventResult>>


    @POST("/Feedback/add")
    fun addFeedback():Single<SuccessResult>

    @GET("/Photos/getphotosbycarid")
    fun getphotos():Single<List<PhotoResult>>


}