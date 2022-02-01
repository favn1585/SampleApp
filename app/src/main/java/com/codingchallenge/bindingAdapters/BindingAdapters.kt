package com.codingchallenge.bindingAdapters

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleOrGone")
fun visibleOrGone(view: View, visible: Boolean?) {
    view.visibility = when (visible) {
        true -> View.VISIBLE
        null,
        false -> View.GONE
    }
}
