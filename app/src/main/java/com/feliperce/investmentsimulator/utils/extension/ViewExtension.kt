package com.feliperce.investmentsimulator.utils.extension

import android.app.DatePickerDialog
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.DatePicker
import android.widget.EditText
import com.feliperce.investmentsimulator.R
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

inline fun EditText.addTextChangeWithCurrencyFormatListener(
    crossinline beforeTextChanged: (
        text: CharSequence?,
        start: Int,
        count: Int,
        after: Int
    ) -> Unit = { _, _, _, _ -> },
    crossinline onTextChanged: (
        text: CharSequence?,
        start: Int,
        count: Int,
        after: Int
    ) -> Unit = { _, _, _, _ -> },
    crossinline afterTextChanged: (text: Editable?) -> Unit = {},
    crossinline afterTextFormatted: (String) -> Unit = { ft -> }
): TextWatcher {
    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {

            val editText = this@addTextChangeWithCurrencyFormatListener

            if (editable.toString().isEmpty()) return
            editText.removeTextChangedListener(this)
            val str = editable.toString()
            var formatted = ""

            val parsed: BigDecimal? = str.stringCurrencyToBigDecimal(Locale("pt", "BR"))
            formatted = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(parsed)
            val replaceable =
                String.format(
                    "[%s\\s]",
                    NumberFormat.getCurrencyInstance(Locale("pt", "BR")).currency?.symbol
                )
            formatted = formatted.replace(replaceable.toRegex(), "")

            editText.setText(formatted)
            editText.setSelection(editText.text.toString().length)
            editText.addTextChangedListener(this)

            afterTextChanged.invoke(editable)
            afterTextFormatted.invoke(formatted)
        }

        override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {
            beforeTextChanged.invoke(text, start, count, after)
        }

        override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
            onTextChanged.invoke(text, start, before, count)
        }
    }
    addTextChangedListener(textWatcher)

    return textWatcher
}

fun EditText.onDateSelectListener(context: Context, block: String.() -> Unit) {
    this.setOnClickListener {

        Calendar.getInstance().also { c ->
            DatePickerDialog(context,
                { view, year, month, day ->
                    block(context.getString(R.string.formated_date,
                        day.toString(), (month+1).toString(), year.toString()))
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).also {
                it.show()
            }
        }
    }
}
