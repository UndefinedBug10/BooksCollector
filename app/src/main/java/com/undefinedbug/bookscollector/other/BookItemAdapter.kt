package com.undefinedbug.bookscollector.other

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.undefinedbug.bookscollector.data.db.entities.BookItem
import com.undefinedbug.bookscollector.databinding.ItemBookBinding
import com.undefinedbug.bookscollector.ui.BookViewModel

class BookItemAdapter(
    var items: List<BookItem>,
    private val viewModel: BookViewModel,
    private val context: Context
) : RecyclerView.Adapter<BookItemAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentBookItem = items[position]

        holder.binding.textViewName.text = currentBookItem.name
        holder.binding.textViewAuthor.text = currentBookItem.author

        Glide.with(context).load(currentBookItem.url).into(holder.binding.imageViewUrl)

        holder.binding.imageViewDelete.setOnClickListener {
            viewModel.delete(currentBookItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class BookViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root)
}