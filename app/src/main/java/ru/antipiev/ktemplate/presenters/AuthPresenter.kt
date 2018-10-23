package ru.antipiev.ktemplate.presenters

import ru.antipiev.ktemplate.contracts.AuthContract

import com.arellomobile.mvp.InjectViewState
import ru.antipiev.ktemplate.Const
import ru.terrakok.cicerone.Router

@InjectViewState
class AuthPresenter(private val router: Router) : BasePresenter<AuthContract>() {
    fun loginClick() {
        router.navigateTo(Const.Screen.MAIN)
    }
}