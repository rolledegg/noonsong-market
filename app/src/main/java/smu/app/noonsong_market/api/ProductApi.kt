package smu.app.noonsong_market.api

import retrofit2.Call
import retrofit2.http.GET
import smu.app.noonsong_market.model.Product

interface ProductApi {
    @GET("/products")
    fun getProducts(): Call<List<Product>>
}