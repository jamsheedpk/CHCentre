package com.example.chcenter.api.model



data class FreezerlistviewModels (var success:Boolean,var message :String,var data:ArrayList<Freezers>)
data class Freezers(var _id: String,var strName:String,var strContactNumber:String)