package ru.antipiev.ktemplate.presenters

import android.util.Log
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.android.Main
import kotlin.coroutines.CoroutineContext

open class BasePresenter<View : MvpView> : MvpPresenter<View>(), CoroutineScope {

    val TAG = javaClass.simpleName
    var job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    init {
        Log.d(TAG, "init")
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}
