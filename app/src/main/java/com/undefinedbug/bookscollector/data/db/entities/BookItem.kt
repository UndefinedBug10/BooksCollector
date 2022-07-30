package com.undefinedbug.bookscollector.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_items")
data class BookItem(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_author")
    var author: String,
    @ColumnInfo(name = "item_url")
    var url: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
