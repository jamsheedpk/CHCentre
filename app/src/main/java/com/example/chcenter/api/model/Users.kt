package com.example.chcenter.api.model

data class Users(
    var page: Int,
    var per_page: Int,
    var total: Int,
    var total_pages: Int,
    var data: ArrayList<ObjData>
)

data class ObjData(
    var id: Int,
    var email: String,
    var first_name: String,
    var last_name: String,
    var avatar: String
)
