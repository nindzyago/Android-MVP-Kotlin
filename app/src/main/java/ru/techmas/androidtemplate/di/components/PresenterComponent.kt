package ru.techmas.androidtemplate.di.components

import javax.inject.Singleton

import dagger.Component
import ru.techmas.androidtemplate.App
import ru.techmas.androidtemplate.di.modules.RestModule
import ru.techmas.androidtemplate.di.modules.UtilsModule
import ru.techmas.androidtemplate.presenters.MainActivityPresenter
import ru.techmas.androidtemplate.presenters.SplashPresenter

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */


@Singleton
@Component(modules = arrayOf(RestModule::class, UtilsModule::class))
interface PresenterComponent {
    //@formatter:off
    fun inject(app: App)

    val mainActivityPresenter: MainActivityPresenter
    val splashPresenter: SplashPresenter
}
