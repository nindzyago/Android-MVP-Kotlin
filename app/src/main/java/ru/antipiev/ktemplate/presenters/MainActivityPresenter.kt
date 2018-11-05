package ru.antipiev.ktemplate.presenters

import com.arellomobile.mvp.InjectViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.android.Main
import kotlinx.coroutines.android.UI
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ru.antipiev.ktemplate.Const
import ru.antipiev.ktemplate.contracts.MainActivityContract
import ru.antipiev.ktemplate.data.Channels
import ru.antipiev.ktemplate.data.managers.SampleManager
import ru.antipiev.ktemplate.data.models.Item
import ru.antipiev.ktemplate.utils.extensions.subscribe
import ru.terrakok.cicerone.Router
import kotlin.coroutines.CoroutineContext

@InjectViewState
class MainActivityPresenter(private val sampleManager: SampleManager,
                            private val router: Router,
                            private val channels: Channels) : BasePresenter<MainActivityContract>(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    init {
        getItems()
    }

    private fun getItems() {
        launch { channels.items.subscribe { it -> viewState.showItems(it) } }
        sampleManager.getItems()
    }

    fun itemClick(item: Item) {
        router.navigateTo(Const.Screen.AUTH)
    }

}
