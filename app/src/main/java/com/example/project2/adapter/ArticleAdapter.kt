package com.example.project2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.project2.R
import com.example.project2.model.Doc

class ArticleAdapter(var mContext: Context, var mList: List<Doc>?, var onClickItem: (Doc?) -> Unit) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    var articles: ArrayList<Doc>? = null
    fun setList(list: List<Doc>) {
        mList = list
        notifyDataSetChanged()
    }
    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvSnippet: TextView = itemView.findViewById(R.id.tvSnippet)
        val imgThumbnail: ImageView = itemView.findViewById(R.id.ivThumbnail)
        override fun onClick(v: View?) {
            onClickItem(mList?.get(adapterPosition))
        }

        init {
            itemView.setOnClickListener(this)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleAdapter.ArticleViewHolder {
        return ArticleViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.activity_item, parent, false)
            )
        }
    override fun getItemCount(): Int {
        return mList?.size?:0
    }
    fun setData(data: List<Doc>) {
        articles?.clear()
        articles?.addAll(data)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ArticleAdapter.ArticleViewHolder, position: Int) {
        var article: Doc? = mList?.get(position)

        holder.tvTitle.text = mList?.get(position)?.headline.toString()
        holder.tvSnippet.text = mList?.get(position)?.snippet
        holder.imgThumbnail.setImageResource(0);
        var thumbnailUrl: String = mList?.get(position)?.thumbnailUrl() ?: ""
        Glide.with(holder.itemView.context)
            .applyDefaultRequestOptions(RequestOptions().placeholder(R.drawable.placeholder).error(R.drawable.loading))
            .load(thumbnailUrl)
            .into(holder.imgThumbnail)
    }


}