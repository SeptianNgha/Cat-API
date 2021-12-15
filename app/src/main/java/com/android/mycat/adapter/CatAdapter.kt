package com.android.mycat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.mycat.R
import com.android.mycat.api.CatResponse

class CatAdapter(
    private val list: ArrayList<CatResponse>,
    private val clickListener: (CatResponse) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as CatViewHolder
        viewHolder.bind(list[position], clickListener)

    }

    override fun getItemCount(): Int {
        return list.size
    }

}