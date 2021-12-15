package com.android.mycat.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.mycat.api.CatResponse
import com.android.mycat.databinding.ItemCatBinding

class CatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val binding = ItemCatBinding.bind(itemView)
    fun bind(catResponse: CatResponse, clickListener: (CatResponse) -> Unit){
        with(binding){
            val text = "${catResponse.id}"
            val name = "${catResponse.name}"

            binding.tvText.text = text
            binding.tvName.text = name
        }
        itemView.setOnClickListener {
            clickListener(catResponse)
        }
    }

}