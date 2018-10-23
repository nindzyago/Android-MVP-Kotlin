package ru.antipiev.ktemplate.presenters

import com.arellomobile.mvp.InjectViewState
import ru.antipiev.ktemplate.contracts.MainActivityContract
import ru.antipiev.ktemplate.data.Channels
import ru.antipiev.ktemplate.data.managers.SampleManager
import ru.antipiev.ktemplate.utils.extensions.subscribe

@InjectViewState
class MainActivityPresenter (private val sampleManager: SampleManager,
                             private val channels: Channels) : BasePresenter<MainActivityContract>() {

    init {
        getItems()
    }

    private fun getItems() {
        channels.items.subscribe { it -> viewState.showItems(it) }
        sampleManager.getItems()
    }

}
