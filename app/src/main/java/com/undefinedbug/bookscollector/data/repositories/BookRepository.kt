package com.undefinedbug.bookscollector.data.repositories

import com.undefinedbug.bookscollector.data.db.BookDatabase
import com.undefinedbug.bookscollector.data.db.entities.BookItem

class BookRepository(
    private val db: BookDatabase
) {
    suspend fun upsert(item: BookItem) = db.getBookDao().upsert(item)

    suspend fun delete(item: BookItem) = db.getBookDao().delete(item)

    fun getAllBookItems() = db.getBookDao().getAllBookItems()
}