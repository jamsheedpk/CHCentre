package com.example.chcenter.api.model

import java.io.Serializable

data class VolunteerModelRequest(
    var name: String,
    var age: String,
    var place: String,
    var contactNumber: String
) : Serializable

