package com.example.movies.ui.utils

import android.content.Context
import android.content.res.Resources
import android.widget.Toast

/*
    Handle Toast Messages
 */
class Boast private constructor(toast: Toast?) {
    private val internalToast: Toast
    fun cancel() {
        internalToast.cancel()
    }

    @JvmOverloads
    fun show(cancelCurrent: Boolean = true) { // cancel current
        if (cancelCurrent && globalBoast != null) {
            globalBoast!!.cancel()
        }
        // save an instance of this current notification
        globalBoast = this
        //internalToast.setGravity(Gravity.CENTER, 0, 0);
        internalToast.show()
    }

    companion object {
        @Volatile
        private var globalBoast: Boast? = null

        @Throws(
            Resources.NotFoundException::class,
            NullPointerException::class
        )
        fun makeText(
            context: Context,
            text: CharSequence?,
            duration: Int
        ): Boast {
            return Boast(Toast.makeText(context, text, duration))
        }

        @Throws(
            Resources.NotFoundException::class,
            NullPointerException::class
        )
        fun makeText(context: Context, resId: Int, duration: Int): Boast {
            return Boast(Toast.makeText(context, resId, duration))
        }

        @Throws(
            Resources.NotFoundException::class,
            NullPointerException::class
        )
        fun makeText(context: Context, text: CharSequence?): Boast {
            return Boast(Toast.makeText(context, text, Toast.LENGTH_SHORT))
        }

        @Throws(
            Resources.NotFoundException::class,
            NullPointerException::class
        )
        fun makeText(context: Context, resId: Int): Boast {
            return Boast(Toast.makeText(context, resId, Toast.LENGTH_SHORT))
        }

        @Throws(Resources.NotFoundException::class)
        fun showText(
            context: Context,
            text: CharSequence?,
            duration: Int
        ) {
            makeText(context, text, duration).show()
        }

        @Throws(Resources.NotFoundException::class)
        fun showText(context: Context, resId: Int, duration: Int) {
            makeText(context, resId, duration).show()
        }

        @Throws(Resources.NotFoundException::class)
        fun showText(context: Context, text: CharSequence) {
            makeText(context, "" + text, Toast.LENGTH_SHORT).show()
        }

        @Throws(Resources.NotFoundException::class)
        fun showText(context: Context, resId: Int) {
            makeText(context, resId, Toast.LENGTH_SHORT).show()
        }
    }

    init { // null check
        if (toast == null) {
            throw NullPointerException("Boast.Boast(Toast) requires a non-null parameter.")
        }
        internalToast = toast
    }
}