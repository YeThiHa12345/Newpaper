package com.yethiha.newsapp_kt.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yethiha.newsapp_kt.R
import com.yethiha.newsapp_kt.model.Article
import kotlinx.android.synthetic.main.item_topheadline.view.*

class TopHeadLineAAdapter (var articlelist:List<Article> = ArrayList()):RecyclerView.Adapter<TopHeadLineAAdapter.TopHeadLineViewHolder>(){

var clickListener:ClickListener?= null
  fun setOnclicklistener(clickListener: ClickListener){

      this.clickListener = clickListener
   }

  fun updateArticel(article: List<Article>)
    {
        this.articlelist = article
     notifyDataSetChanged()
   }


    inner  class TopHeadLineViewHolder(iteview: View):RecyclerView.ViewHolder(iteview),View.OnClickListener{
        lateinit var article: Article
      init {
         iteview.setOnClickListener(this)
     }

        fun bind(article: Article){
            this.article=article

 // picasson.get().load().into()
            Glide.with(itemView).load(article.urlToImage).into(itemView.toheadline_image)
            itemView.toheadline_text.text= article.title
        }

        override fun onClick(view: View?) {
            clickListener?.Click(article)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadLineViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_topheadline,parent,false)
        return TopHeadLineViewHolder(view)

    }

    override fun getItemCount(): Int {
        return articlelist.size

    }

    override fun onBindViewHolder(holder: TopHeadLineViewHolder, position: Int) {
       holder.bind(articlelist[position])
    }

  interface ClickListener{
     fun Click(article:Article)
  }
}