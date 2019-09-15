package com.tong.coderswag.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.tong.coderswag.R
import com.tong.coderswag.model.Category

class CategoryRecycleAdapter(val context: Context, val categories: List<Category>): RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        println("create new holder")
        val view = LayoutInflater.from(context)
            .inflate(R.layout.category_list_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        println("bind to holder")
        holder.bindCategory(categories[position], context)
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category: Category, context: Context) {
            println("inside bind ${category.title}")
            val recourceId = context.resources.getIdentifier(category.image,
                "dreawable", context.packageName)
            categoryImage.setImageResource(recourceId)
            categoryName.text = category.title
        }
    }
}