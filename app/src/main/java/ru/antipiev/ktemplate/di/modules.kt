package ru.antipiev.ktemplate.di

import org.koin.dsl.module.module
import ru.antipiev.ktemplate.data.api.RestApi
import ru.antipiev.ktemplate.data.managers.SampleManager
import ru.antipiev.ktemplate.presenters.MainActivityPresenter
import ru.antipiev.ktemplate.views.activities.MainActivity

val singleModule = module {
    single { RestApi() }
    single { SampleManager(get()) }
}

val logicModule = module {
    factory { MainActivity() }
    factory { MainActivityPresenter(get()) }
}

val appModules = listOf(singleModule, logicModule)
