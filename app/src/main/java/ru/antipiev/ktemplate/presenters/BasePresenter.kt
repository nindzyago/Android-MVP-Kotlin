package ru.antipiev.ktemplate.presenters

import android.util.Log
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView

open class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    open val TAG = javaClass.simpleName

    init {
        Log.d(TAG, "init")
    }

//    open var restApi: RestApi? = null
//    open var tokenHelper: TokenHelper? = null

//    private val compositeDisposable = CompositeDisposable()
//
//
//    protected fun unSubscribeOnDestroy(disposable: Disposable) {
//        compositeDisposable.add(disposable)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        compositeDisposable.clear()
//    }

}
