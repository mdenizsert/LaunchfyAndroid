package com.info.launchfy.service

import com.info.launchfy.model.EventDto
import com.info.launchfy.model.EventResult
import com.info.launchfy.model.PhotoResult
import com.info.launchfy.model.Photos
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LaunchfyAPIService {

    //  apiUrl = 'https://localhost:44366/api/Cars/';    let newPath = this.apiUrl + "getall";

    private val BASE_URL="https://localhost:44366/api"
    private val api=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(LaunchfyAPI::class.java)


    fun getEventDtos():Single<List<EventResult>>{
        return api.getEventDtos()
    }

    fun getPhotos():Single<List<PhotoResult>>{
        return api.getphotos()
    }
}