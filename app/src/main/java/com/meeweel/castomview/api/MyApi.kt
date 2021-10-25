package com.meeweel.castomview.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface MyApi {

    @GET("./test.php?q=post&id=1")
    @Headers("Content-type: application/json")
    fun getPic(): Single<ObjectResponse>

}