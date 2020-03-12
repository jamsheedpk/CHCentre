package com.example.chcenter.api.model

data class AmbulancelistviewModels (var success:Boolean,var message :String,var data:ArrayList<Ambulances>)
data class Ambulances(var _id: String,var strName:String,var strContactNumber:String)