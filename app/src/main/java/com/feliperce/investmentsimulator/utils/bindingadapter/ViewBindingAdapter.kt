package com.feliperce.investmentsimulator.utils.bindingadapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import com.feliperce.investmentsimulator.exception.ErrorException
import com.google.android.material.snackbar.Snackbar

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

@BindingAdapter("app:errorHandlerSnackbar")
fun errorHandlerSnackbar(viewGroup: ViewGroup, errorException: ErrorException?) {
    errorException?.let {
        Snackbar.make(viewGroup, it.msg, Snackbar.LENGTH_LONG).show()
    }
}