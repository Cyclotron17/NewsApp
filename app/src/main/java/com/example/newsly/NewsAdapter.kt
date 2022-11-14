package com.example.newsly

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsAdapter(val context:Context, val articles: List<ArticleX>):
    RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {
    class ArticleViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var newsImage=itemView.findViewById<ImageView>(R.id.newsimg)
        var newsTitle=itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDescription=itemView.findViewById<TextView>(R.id.newsdesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
      val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        val article=articles[position]
        holder.newsTitle.text=article.title
        holder.newsDescription.text=article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)


    }

    override fun getItemCount(): Int {
     return articles.size
    }

}





