package ru.antipiev.ktemplate.views.fragments

import android.view.View

import com.arellomobile.mvp.MvpAppCompatFragment

import ru.antipiev.ktemplate.contracts.base.BaseLifeCycle
import ru.antipiev.ktemplate.utils.KeyboardHelper

abstract class BaseFragment : MvpAppCompatFragment(), BaseLifeCycle {

    protected val TAG = javaClass.simpleName
    protected var rootView: View? = null


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    protected fun hideKeyboard() {
        KeyboardHelper.hide(activity!!)
    }

}
