

package com.example.prepareinterview.retorfitwithhilt

import android.os.Parcelable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
@Parcelize

open class Event<out T>(private val content: @RawValue T) : Parcelable {

    @IgnoredOnParcel
    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content
}


fun <T> LiveData<Event<T>>.observeIfNotHandled(
    viewLifecycleOwner: LifecycleOwner,
    handle: (content: T) -> Unit
) {
    observe(viewLifecycleOwner) { event ->
        event.getContentIfNotHandled()?.let { handle(it) }
    }
}