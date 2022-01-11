package com.info.launchfy.service

class ApiUtils {

    companion object{
        val BASE_URL="https://localhost:44366/api/"


        fun getApiService():LaunchfyAPI{
            return LaunchfyAPIService.getClient(BASE_URL).create(LaunchfyAPI::class.java)
        }

    }
}