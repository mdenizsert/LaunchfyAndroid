package com.info.launchfy.model

import com.google.gson.annotations.SerializedName
import java.sql.Date

data class Car(var car_id:Int, var car_model:String, var city:String, var car_image_name:String) {
}
data class SignIn(
        val email:String,
        val password:String){
}
data class Feedback(
        @SerializedName("EventId")
        val eventId:Int,
        @SerializedName("CarPoint")
        val carPoint:Int,
        @SerializedName("EventPoint")
        val eventPoint:Int,
        @SerializedName("LocationPoint")
        val locationPoint:Int,
        @SerializedName("AvaragePoint")
        val averagePoint: Double,
        @SerializedName("Comment")
        val comment:String,
        @SerializedName("AttendeeId")
        val userId:Int){
}
data class EventDto(
        @SerializedName("EventId")
        val eventId:Int,
        @SerializedName("CarId")
        val carId:String,
        @SerializedName("CarName")
        val carName:String,
        @SerializedName("Date")
        val date:String,
        @SerializedName("CountryName")
        val countryName:String,
        @SerializedName("DestinationName")
        val destinationName:String,
        @SerializedName("Rating")
        val rating:Double
){}
data class Photos(
        @SerializedName("PhotoId")
        val photoId:Int,
        @SerializedName("CarId")
        val carId:Int,
        @SerializedName("Url")
        val url:String,
        @SerializedName("Description")
        val description:String,
        @SerializedName("DateAdded")
        val date: Date,
        @SerializedName("IsMain")
        val isMain:Int,
        @SerializedName("PublicId")
        val publicId:Int
){}

data class SuccessResult(
        @SerializedName("success")
        val success:Boolean,
        @SerializedName("message")
        val message:String?
){}

data class EventResult(
        @SerializedName("data")
        val event:List<EventDto>,
        @SerializedName("success")
        val success:Boolean,
        @SerializedName("message")
        val message:String?
){}
data class PhotoResult(
        @SerializedName("data")
        val photos:List<Photos>,
        @SerializedName("success")
        val success:Boolean,
        @SerializedName("message")
        val message:String?
){}