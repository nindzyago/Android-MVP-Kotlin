package ru.techmas.androidtemplate.activities


import android.os.Bundle

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import ru.techmas.androidtemplate.R
import ru.techmas.androidtemplate.interfaces.views.MainView
import ru.techmas.androidtemplate.presenters.MainActivityPresenter
import ru.techmas.androidtemplate.utils.Injector

class MainActivity : BaseActivity(), MainView {


    companion object {
        private val LAYOUT = R.layout.call_chat_group
    }

    @InjectPresenter
    lateinit var mainPresenter: MainActivityPresenter

    @ProvidePresenter
    internal fun provideMainActivityPresenter(): MainActivityPresenter {
        return Injector.presenterComponent!!.mainActivityPresenter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)
    }

    override fun setupUI() {

    }

    override fun setupUX() {

    }


}
