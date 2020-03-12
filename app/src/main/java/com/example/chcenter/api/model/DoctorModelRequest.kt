package com.example.chcenter.api.model

import java.io.Serializable

data class DoctorModelRequest(
    var name: String,
    var specialisation: String,
    var place: String,
    var contactNumber: String
) : Serializable
