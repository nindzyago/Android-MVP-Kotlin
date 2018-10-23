package ru.antipiev.ktemplate.views.activities

import ru.antipiev.ktemplate.contracts.AuthContract
import ru.antipiev.ktemplate.presenters.AuthPresenter
import ru.antipiev.ktemplate.R

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_auth.*
import org.jetbrains.anko.sdk25.listeners.onClick

import org.koin.android.ext.android.get
import ru.antipiev.ktemplate.views.activities.base.BaseActivity


class AuthActivity : BaseActivity(), AuthContract {

    override fun setupUI() {
    }

    override fun setupUX() {
        btn_login.onClick { authPresenter.loginClick() }
    }

    override fun unbindUX() {
        btn_login.setOnClickListener(null)
    }

    override val layout = R.layout.activity_auth

    @InjectPresenter
    lateinit var authPresenter : AuthPresenter

    @ProvidePresenter
    internal fun provideAuthPresenter(): AuthPresenter = get()

}
