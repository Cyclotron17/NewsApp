package com.example.newsly

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

//               https://newsapi.org//v2/top-headlines?apikey=$Api_Key&country=in&page=1
const val Base_Url="https://newsapi.org/"
const val Api_Key="402b2cf7806a4b8baaa84e440fc9ede0"
interface NewsInterface {

    @GET("v2/top-headlines?apikey=$Api_Key")
    fun getHeadlines(@Query("country") country: String, @Query("page") page: Int): Call<Article>

}
object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance= retrofit.create(NewsInterface::class.java)
    }
}