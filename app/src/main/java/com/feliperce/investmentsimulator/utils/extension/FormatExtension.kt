package com.feliperce.investmentsimulator.utils.extension

import java.math.BigDecimal
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.iso9801ToDateFormattedString(requiredFormat: String = "dd/MM/yyyy"): String {

    val init = this.replaceAfter("T", "")
    val df1 = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val result1 = df1.parse(init)

    val df2 = SimpleDateFormat(requiredFormat, Locale.getDefault())

    return if (result1 == null) {
        ""
    } else {
        df2.format(result1)
    }
}

fun String.toFormattedDate(currentFormat: String = "dd/MM/yyyy",
                           requiredFormat: String = "yyyy-MM-dd"): String {

    var format =
        SimpleDateFormat(currentFormat, Locale.getDefault())
    val newDate = format.parse(this)

    return if (newDate == null) {
        ""
    } else {
        format = SimpleDateFormat(requiredFormat, Locale.getDefault())
        format.format(newDate)
    }
}

fun String.stringCurrencyToBigDecimal(locale: Locale = Locale("pt", "BR")): BigDecimal {
    val replaceable = String.format(
        "[%s,.\\s]",
        NumberFormat.getCurrencyInstance(locale).currency?.symbol
    )
    val cleanString = this.replace(replaceable.toRegex(), "")
    return BigDecimal(cleanString).setScale(
        2, BigDecimal.ROUND_FLOOR
    ).divide(
        BigDecimal(100), BigDecimal.ROUND_FLOOR
    )
}