package com.example.imagefilterview.ui.Contact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imagefilterview.R

class ItemAdapter(val items: ArrayList<Items>,var onClick:(View) -> Boolean):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val textView = itemView.findViewById<TextView>(R.id.recyclerText)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_card_layout,viewGroup,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = items[position]
        viewHolder.textView.text = item.text
        viewHolder.itemView.setOnClickListener{
            onClick(it)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}