package com.feliperce.investmentsimulator.data.statushandler

import com.feliperce.investmentsimulator.exception.ErrorException

sealed class Status {
    object Success : Status()
    class Error(val exception: ErrorException? = null) : Status()
    class Loading(val isLoading: Boolean) : Status()
}