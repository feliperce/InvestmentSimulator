package com.feliperce.investmentsimulator.utils.bindingadapter

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:boolVisibility")
fun boolVisibility(view: View, isVisible: Boolean) {
    if (isVisible) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter("app:boolEnabled")
fun boolEnabled(view: View, isEnabled: Boolean) {
    view.isEnabled = isEnabled
}