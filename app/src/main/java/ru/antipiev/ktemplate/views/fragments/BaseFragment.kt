package ru.antipiev.ktemplate.views.fragments

import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.animation.Animation

import com.arellomobile.mvp.MvpAppCompatFragment

import ru.antipiev.ktemplate.views.activities.BaseActivity
import ru.antipiev.ktemplate.contracts.BaseLifeCycle
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
