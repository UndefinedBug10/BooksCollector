package com.undefinedbug.bookscollector

import android.app.Application
import com.undefinedbug.bookscollector.data.db.BookDatabase
import com.undefinedbug.bookscollector.data.repositories.BookRepository
import com.undefinedbug.bookscollector.ui.BookViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class BookApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@BookApplication))
        bind() from singleton { BookDatabase(instance()) }
        bind() from singleton { BookRepository(instance()) }
        bind() from provider {
            BookViewModelFactory(instance())
        }
    }
}