package ru.antipiev.ktemplate.views.activities.base

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle

import com.arellomobile.mvp.MvpAppCompatActivity
import org.koin.android.ext.android.get
import ru.antipiev.ktemplate.Const

import ru.antipiev.ktemplate.R
import ru.antipiev.ktemplate.contracts.base.BaseLifeCycle
import ru.antipiev.ktemplate.utils.KeyboardHelper
import ru.antipiev.ktemplate.views.activities.MainActivity
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.SupportAppNavigator

abstract class BaseActivity : MvpAppCompatActivity(), BaseLifeCycle {

    abstract val layout: Int
    open val TAG = javaClass.simpleName

//    internal fun getNavigationHolder(): NavigatorHolder = get()
    val navigationHolder: NavigatorHolder = get()

    open val navigator = object : SupportAppNavigator(this, R.id.container) {
        override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?)= when (screenKey) {
            Const.Screen.MAIN -> Intent(context, MainActivity::class.java)
            else -> null
        }
        override fun createFragment(screenKey: String?, data: Any?) = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        setupUI()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onResume() {
        super.onResume()
        navigationHolder.setNavigator(navigator)
        setupUX()
    }

    override fun onPause() {
        unbindUX()
        navigationHolder.removeNavigator()
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
