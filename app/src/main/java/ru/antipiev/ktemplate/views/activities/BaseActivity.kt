package ru.antipiev.ktemplate.views.activities

import android.content.pm.ActivityInfo
import android.os.Bundle

import com.arellomobile.mvp.MvpAppCompatActivity

import ru.antipiev.ktemplate.R
import ru.antipiev.ktemplate.contracts.BaseLifeCycle
import ru.antipiev.ktemplate.utils.KeyboardHelper

abstract class BaseActivity : MvpAppCompatActivity(), BaseLifeCycle {

    abstract val layout: Int
    open val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        setupUI()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onResume() {
        super.onResume()
        setupUX()
    }

    override fun onPause() {
        unbindUX()
        super.onPause()
    }

    protected fun hideKeyboard() {
        KeyboardHelper.hide(this)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }
}
