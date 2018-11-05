package ru.antipiev.ktemplate.data.managers

import com.vicpin.krealmextensions.queryAll
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.custom.async
import ru.antipiev.ktemplate.data.Channels
import ru.antipiev.ktemplate.api.RestApi
import ru.antipiev.ktemplate.data.models.Item
import ru.antipiev.ktemplate.utils.extensions.store
import kotlin.coroutines.CoroutineContext

class SampleManager(private val restApi: RestApi,
                    private val channels: Channels) {

    private fun getNetItems() = runBlocking { restApi.sample.list().await() }
    private fun getDbItems() = Item().queryAll()

    fun getItems() {
        launch { channels.items.send(getDbItems()) }
        channels.items.store(getNetItems())
    }
}
