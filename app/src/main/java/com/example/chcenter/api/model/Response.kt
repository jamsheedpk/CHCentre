package com.example.chcenter.api.model

import java.io.Serializable


data class Response(var name: String, var job: String, var id: String, var createdAt: String) :
    Serializable
