package com.svyd.beerbrowser.presentation.base

import android.os.Bundle

interface ViewPresenterContract {

    interface View {
        fun showProgress()
        fun hideProgress()
        fun showMessage(message: String)
        fun showNoInternetConnectionError()
        fun unauthorised()
    }

    interface Presenter<in V: View> {
        fun onStart()
        fun initialize(view: V)
        fun onStop()
        fun restoreState(state: Bundle)
        fun saveState(state: Bundle)
    }
}