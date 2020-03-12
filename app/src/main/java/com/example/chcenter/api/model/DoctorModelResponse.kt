package com.example.chcenter.api.model


data class DoctorModelResponse(
    var nameSerializable: String,
    var specialisation: String,
    var place: String,
    var contactNumber: String,
    var id: String
)