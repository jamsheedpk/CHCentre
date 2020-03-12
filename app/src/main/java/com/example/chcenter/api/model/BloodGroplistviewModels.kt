package com.example.chcenter.api.model

data class BloodGroplistviewModels (var success:Boolean,var message :String,var blodgrp:ArrayList<Bloodgroups>)
data class Bloodgroups(var _id :String,var strName:String,var strContactNumber:String,var strAge :String,var strLastDonationDate :String,var strBloodGroup :String,var createdAt:String)