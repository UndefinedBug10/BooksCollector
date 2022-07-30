package com.undefinedbug.bookscollector.ui

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.Toast
import com.undefinedbug.bookscollector.R
import com.undefinedbug.bookscollector.data.db.entities.BookItem
import com.undefinedbug.bookscollector.databinding.DialogAddBookBinding

class AddBookDialog(context: Context, private val addDialogListener: AddDialogListener) : Dialog(context, R.style.Theme_Dialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val binding = DialogAddBookBinding.inflate(LayoutInflater.from(context), null, false)
        setContentView(binding.root)

        binding.buttonAdd.setOnClickListener {
            val name = binding.editTextName.text.toString().trim()
            val author = binding.editTextAuthor.text.toString().trim()
            val url = binding.editTextUrl.text.toString().trim()

            if (name.isEmpty() || author.isEmpty() || url.isEmpty()) {
                Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = BookItem(name, author, url)
            addDialogListener.onAddClicked(item)
            dismiss()
        }

        binding.buttonCancel.setOnClickListener { cancel() }
    }
}