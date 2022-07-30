package com.undefinedbug.bookscollector.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.undefinedbug.bookscollector.data.db.entities.BookItem

@Database(
    entities = [BookItem::class],
    version = 1
)
abstract class BookDatabase : RoomDatabase() {

    abstract fun getBookDao(): BookDao

    companion object {
        @Volatile
        private var instance: BookDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, BookDatabase::class.java, "BookDB.db")
                .build()
    }
}