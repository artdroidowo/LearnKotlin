package com.example.karol.learnkotlin

import android.content.Intent
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.karol.learnkotlin.model.Search
import kotlinx.android.synthetic.main.row_search.view.*

class ResultsAdapter(var search: MutableList<Search>, val activity: MainActivity) : RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var description = search[position].snippet
        description = description.replace("<span class=\"searchmatch\">", "<b>")
        description = description.replace("</span>", "</b>")
        holder.tvTitle?.text = search[position].title
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            holder.tvDescription?.text = (Html.fromHtml(description, Html.FROM_HTML_MODE_COMPACT))
        } else {
            holder.tvDescription?.text = Html.fromHtml(description)
        }
        holder.itemView.setOnClickListener {
            var intent = Intent(activity, WebViewActivity::class.java)
            intent.putExtra(INTENT_URL_CODE, search[position].pageid)
            activity.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(activity).inflate(
                R.layout.row_search,
                parent,
                false
        ))
    }

    override fun getItemCount(): Int {
        return search.size
    }

    fun addMore(search_: MutableList<Search>) {
        search.addAll(search_)
        notifyDataSetChanged()
    }
}

class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var tvTitle = itemView?.tv_search_title
    var tvDescription = itemView?.tv_search_description
}