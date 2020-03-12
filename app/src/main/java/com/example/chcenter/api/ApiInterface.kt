package com.example.chcenter.api

import com.example.chcenter.api.model.*
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {


    @POST("users")
    fun userRegistration(@Body params: Request): Observable<Response>


    @POST("doctors")
    fun doctorRegistration(@Body params: DoctorModelRequest): Observable<DoctorModelResponse>

    @POST("volunteers")
    fun volunteerRegistration(@Body params: VolunteerModelRequest): Observable<VolunteerModelResponse>
    

    @GET("users?page=2")
    fun getAllUserList(): Observable<Users>

    @POST("doctor/getDoctorDetailsData")
    fun getDocoterlistview():Observable<DoctorlistviewModels>

    @POST("doctor/SaveDoctorDetails")
    fun saveDoctorDetails(@Body params: Doctors):Observable<DoctorlistviewModels>

    @POST("doctor/UpdateDoctorDetails")
    fun updateDoctorDetails(@Body params: Request):Observable<DoctorlistviewModels>

    @POST("ambulance/getAmbulanceDetailsData")
    fun getAmbulanceDetailsData():Observable<AmbulancelistviewModels>


    @POST("ambulance/SaveAmbulanceDetails")
    fun saveAmbulanceDetails(@Body params: Ambulances):Observable<AmbulancelistviewModels>

    @POST("freezer/getFreezerDetailsData")
    fun getFreezerDetailsData():Observable<FreezerlistviewModels>

    @POST("freezer/SaveFreezerDetails")
    fun SaveFreezerDetails(@Body params: Freezers):Observable<FreezerlistviewModels>


    @POST("volunteer/getVolunteerDetailsData")
    fun getVolunteerDetailsData():Observable<VolunteerlistviewModels>


    @POST("volunteer/SaveVolunteerDetails")
    fun SaveVolunteerDetails(@Body params: Volunteers):Observable<VolunteerlistviewModels>


    @POST("bloodgroup/SaveBloodGroupDetails")
    fun SaveBloodGroupDetails(@Body params: Bloodgroups):Observable<BloodGroplistviewModels>

    @GET("getBloodGroupDetailsData")
    fun bloodgrouplistview():Observable<BloodGroplistviewModels>

    @GET("getFreezerDetailsData")
    fun freezerlistview():Observable<FreezerlistviewModels>

    @GET("getVolunteerDetailsData")
    fun volunteerlistview():Observable<VolunteerlistviewModels>


}

