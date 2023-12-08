package com.leaftware.dental.clinic.data.network

import com.leaftware.dental.clinic.data.UserDataResponse.UserDataResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    //@GET("/.json")
    //suspend fun getAllQuotes(): Response<List<QuoteModel>>

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") username: String,
        @Field("password") password: String
    ): Response<UserDataResponse>
}