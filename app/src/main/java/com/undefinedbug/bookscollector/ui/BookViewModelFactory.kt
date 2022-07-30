package com.undefinedbug.bookscollector.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.undefinedbug.bookscollector.data.repositories.BookRepository

@Suppress("UNCHECKED_CAST")
class BookViewModelFactory(
    private val repository: BookRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookViewModel(repository) as T
    }
}