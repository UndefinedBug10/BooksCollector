package com.undefinedbug.bookscollector.ui

import com.undefinedbug.bookscollector.data.db.entities.BookItem

interface AddDialogListener {
    fun onAddClicked(item: BookItem)
}