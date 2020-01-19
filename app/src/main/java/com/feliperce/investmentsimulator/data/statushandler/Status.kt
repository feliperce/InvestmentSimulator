package com.example.githubviewer.data.statushandler

import com.example.githubviewer.exception.ErrorException

sealed class Status {
    object Success : Status()
    class Error(val exception: ErrorException? = null) : Status()
    class Loading(val isLoading: Boolean) : Status()
}