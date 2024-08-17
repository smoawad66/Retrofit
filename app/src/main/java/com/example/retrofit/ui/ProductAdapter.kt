package com.example.retrofit.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.models.Product

class ProductAdapter(private var data: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    fun setData(data: List<Product>) {
        this.data = data
    }

    fun getData() = data

    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class ViewHolder(private val row: View) : RecyclerView.ViewHolder(row) {
        val tv_title: TextView = row.findViewById(R.id.tv_title)
        val tv_price: TextView = row.findViewById(R.id.tv_price)
        val imageView: ImageView = row.findViewById(R.id.iv)

        init {
            itemView.setOnClickListener { listener?.onItemClick(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_title.text = data[position].title
        holder.tv_price.text = "Price: $${data[position].price}"
        Glide.with(holder.itemView)
            .load(data[position].thumbnail)
            .error(R.drawable.baseline_error_24)
            .placeholder(R.drawable.loading)
            .into(holder.imageView)

    }

    override fun getItemCount(): Int = data.size
}