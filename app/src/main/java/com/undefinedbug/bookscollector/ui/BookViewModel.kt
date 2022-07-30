package com.undefinedbug.bookscollector.ui

import androidx.lifecycle.ViewModel
import com.undefinedbug.bookscollector.data.db.entities.BookItem
import com.undefinedbug.bookscollector.data.repositories.BookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(
    private val repository: BookRepository
) : ViewModel() {

    fun upsert(item: BookItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: BookItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllBookItems() = repository.getAllBookItems()
}