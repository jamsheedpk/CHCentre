package com.example.chcenter.api.model




data class VolunteerlistviewModels (var success:Boolean,var message :String,var data:ArrayList<Volunteers>)
data class Volunteers(var _id: String,var strName:String,var strContactNumber:String)