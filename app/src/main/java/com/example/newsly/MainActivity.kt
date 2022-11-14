  package com.example.newsly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

  class MainActivity : AppCompatActivity() {
      lateinit var adapter: NewsAdapter
      lateinit var nlist:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }
    private fun getNews(){
        nlist=findViewById(R.id.newsList)
        val news: Call<Article> =NewsService.newsInstance.getHeadlines("in",1)
        news.enqueue(object : Callback<Article>{
            override fun onResponse(call: Call<Article>, response: Response<Article>) {
                val news:Article?=response.body()
                if (news!=null){
                    Log.d("NewsApp",news.toString())
                    adapter=NewsAdapter(this@MainActivity,news.articles)

                    nlist.adapter=adapter

                }

            }

            override fun onFailure(call: Call<Article>, t: Throwable) {

                Log.d("NewsApp","Error in Fetching News")
            }
        })
    }
}