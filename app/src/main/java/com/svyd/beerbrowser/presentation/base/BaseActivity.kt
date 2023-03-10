package com.svyd.beerbrowser.presentation.base

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes

abstract class BaseActivity : Activity(), ViewPresenterContract.View {

    @get:LayoutRes
    protected abstract val contentView: Int

    protected abstract fun getPresenter(): ViewPresenterContract.Presenter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(contentView)
        initializeUi()
        initializePresenter()
    }

    override fun onStart() {
        super.onStart()
        getPresenter().onStart()
    }

    override fun onStop() {
        super.onStop()
        getPresenter().onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        getPresenter().saveState(outState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        savedInstanceState?.let { state -> getPresenter().restoreState(state)}
    }

    protected abstract fun initializeUi()

    protected abstract fun initializePresenter()

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showMessage(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun showNoInternetConnectionError() =
        Toast.makeText(this, "Please, check your internet connection", Toast.LENGTH_SHORT).show()

    override fun unauthorised() {

    }

}