package ru.antipiev.ktemplate.data.managers

import com.vicpin.krealmextensions.queryAll
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import ru.antipiev.ktemplate.data.Channels
import ru.antipiev.ktemplate.api.RestApi
import ru.antipiev.ktemplate.data.models.Item
import ru.antipiev.ktemplate.utils.extensions.store

class SampleManager(private val restApi: RestApi,
                    private val channels: Channels) {

    private fun getNetItems() = runBlocking { restApi.sample.list().await() }
    private fun getDbItems() = Item().queryAll()

    fun getItems() {
        launch { channels.items.send(getDbItems()) }
        channels.items.store(getNetItems())
    }
}
