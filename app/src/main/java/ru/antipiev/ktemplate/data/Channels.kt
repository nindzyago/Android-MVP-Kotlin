package ru.antipiev.ktemplate.data

import kotlinx.coroutines.channels.BroadcastChannel
import ru.antipiev.ktemplate.data.models.Item

class Channels {
    val items = BroadcastChannel<List<Item>>(3)
}