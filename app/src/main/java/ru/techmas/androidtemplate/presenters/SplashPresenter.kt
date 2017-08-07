package ru.techmas.androidtemplate.presenters

import com.arellomobile.mvp.InjectViewState

import javax.inject.Inject

import ru.techmas.androidtemplate.activities.MainActivity
import ru.techmas.androidtemplate.api.RestApi
import ru.techmas.androidtemplate.interfaces.views.SplashView
import ru.techmas.androidtemplate.utils.presenter.TokenHelper


@InjectViewState
class SplashPresenter @Inject
internal constructor(restApi: RestApi, preferenceHelper: TokenHelper) : BasePresenter<SplashView>() {

    init {
        this.restApi = restApi
        this.tokenHelper = preferenceHelper
        startNext()
    }


    fun startNext() {
        viewState.showErrorConnection(false)
        if (tokenHelper!!.isFirstRun) {
            viewState.startActivity(MainActivity::class.java)
        }
    }

}
