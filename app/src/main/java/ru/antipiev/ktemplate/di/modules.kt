package ru.antipiev.ktemplate.di

import org.koin.dsl.module.module
import ru.antipiev.ktemplate.data.Channels
import ru.antipiev.ktemplate.api.RestApi
import ru.antipiev.ktemplate.data.managers.SampleManager
import ru.antipiev.ktemplate.presenters.AuthPresenter
import ru.antipiev.ktemplate.presenters.MainActivityPresenter
import ru.antipiev.ktemplate.views.activities.AuthActivity
import ru.antipiev.ktemplate.views.activities.MainActivity
import ru.terrakok.cicerone.Cicerone

val singletons = module {
    val cicerone = Cicerone.create()
    single { RestApi() }
    single { Channels() }
    single { cicerone.router }
    single { cicerone.navigatorHolder }
    single { SampleManager(get(), get()) }
}

val views = module {
    factory { MainActivity() }
    factory { AuthActivity() }
}

val presenters = module {
    factory { MainActivityPresenter(get(), get(), get()) }
    factory { AuthPresenter(get()) }
}

val appModules = listOf(singletons, views, presenters)
