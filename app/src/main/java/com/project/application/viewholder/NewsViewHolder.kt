package com.project.application.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_view.view.*

class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder (itemView) {
    val title = itemView.title_list
    val body = itemView.body_list
    val date = itemView.date_list
    val btnUpdate = itemView.btn_update
    val btnDelete = itemView.btn_delete
}