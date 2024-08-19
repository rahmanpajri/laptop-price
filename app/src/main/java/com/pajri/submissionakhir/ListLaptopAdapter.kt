package com.pajri.submissionakhir

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pajri.submissionakhir.databinding.ItemRowLaptopBinding

class ListLaptopAdapter(private val listLaptop: ArrayList<Laptop>):RecyclerView.Adapter<ListLaptopAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemRowLaptopBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowLaptopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, price) = listLaptop[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.laptopPhoto)
        holder.binding.laptopName.text = name
        holder.binding.laptopDescription.text = description
        holder.binding.laptopPrice.text = price
        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_laptop", listLaptop[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }

    }

    override fun getItemCount(): Int = listLaptop.size

}
