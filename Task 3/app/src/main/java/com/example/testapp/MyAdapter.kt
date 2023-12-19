package com.example.testapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response

class MyAdapter(var data: ArrayList<Products>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    class MyViewHolder(val h:View) : RecyclerView.ViewHolder(h)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_item,parent,false)
        val holder = MyViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val textId =  holder.itemView.findViewById<TextView>(R.id.TextId)
        val title = holder.itemView.findViewById<TextView>(R.id.title)
        val description = holder.itemView.findViewById<TextView>(R.id.description)

        textId.text = data[position].id.toString()
        title.text = data[position].title
        description.text = data[position].description

    }
    override fun getItemCount(): Int {
        return  data.size
    }
}