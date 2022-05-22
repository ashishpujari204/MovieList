package com.ashish.movielist.ui.baseactivity

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ashish.movielist.R

abstract class BaseActivity : AppCompatActivity() {

    fun showAlertDialog(dialogBuilder: AlertDialog.Builder.() -> Unit) {
        val builder = AlertDialog.Builder(this)
        builder.dialogBuilder()
        val dialog = builder.create()
        dialog.show()
    }

    fun AlertDialog.Builder.positiveButton(
        text: String = getString(R.string.dialog_okay_text),
        handleClick: (which: Int) -> Unit = {}
    ) {
        this.setPositiveButton(text) { _, which -> handleClick(which) }
    }

    fun AlertDialog.Builder.negativeButton(
        text: String = getString(R.string.dialog_cancel_text),
        handleClick: (which: Int) -> Unit = {}
    ) {
        this.setNegativeButton(text) { _, which -> handleClick(which) }
    }
}