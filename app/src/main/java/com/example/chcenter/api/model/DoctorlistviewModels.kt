package com.example.chcenter.api.model

data class DoctorlistviewModels (var success:Boolean,var message :String,var data:ArrayList<Doctors>)
data class Doctors(var _id: String,var strName:String,var strSpecialisation:String,var strPlace:String,var strContactNumber
:String,var createdAt:String,var strEmail :String,var strAddress :String,var strGender:String)