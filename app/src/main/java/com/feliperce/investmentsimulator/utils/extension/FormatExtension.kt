package com.example.githubviewer.extension

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