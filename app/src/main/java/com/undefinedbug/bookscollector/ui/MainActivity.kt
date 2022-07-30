package com.undefinedbug.bookscollector.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.undefinedbug.bookscollector.data.db.entities.BookItem
import com.undefinedbug.bookscollector.databinding.ActivityMainBinding
import com.undefinedbug.bookscollector.other.BookItemAdapter
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    private lateinit var binding: ActivityMainBinding

    override val kodein: Kodein by kodein()
    private val factory: BookViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProviders.of(this, factory)[BookViewModel::class.java]

        val adapter = BookItemAdapter(listOf(), viewModel, this)

        binding.recyclerViewItems.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerViewItems.adapter = adapter

        viewModel.getAllBookItems().observe(this) {
            adapter.items = it
            adapter.notifyDataSetChanged()

            if (it.isEmpty()) {
                binding.textViewIsEmpty.visibility = View.VISIBLE
            } else {
                binding.textViewIsEmpty.visibility = View.GONE
            }
        }

        binding.fabAddBook.setOnClickListener {
            AddBookDialog(this, object : AddDialogListener {
                override fun onAddClicked(item: BookItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}