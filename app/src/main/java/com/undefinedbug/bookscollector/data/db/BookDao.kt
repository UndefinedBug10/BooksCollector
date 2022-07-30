package com.undefinedbug.bookscollector.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.undefinedbug.bookscollector.data.db.entities.BookItem

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: BookItem)

    @Delete
    suspend fun delete(item: BookItem)

    @Query("SELECT * FROM book_items")
    fun getAllBookItems(): LiveData<List<BookItem>>
}