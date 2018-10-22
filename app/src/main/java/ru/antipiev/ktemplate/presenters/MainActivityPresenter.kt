package ru.antipiev.ktemplate.presenters

import com.arellomobile.mvp.InjectViewState
import ru.antipiev.ktemplate.contracts.MainActivityContract
import ru.antipiev.ktemplate.data.managers.SampleManager

@InjectViewState
class MainActivityPresenter (private val sampleManager: SampleManager) : BasePresenter<MainActivityContract>() {

    init {
        getItems()
    }

    private fun getItems() {
        viewState.showItems(sampleManager.getNetItems())
    }

}
