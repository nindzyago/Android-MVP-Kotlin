package ru.antipiev.ktemplate.utils.extensions

import com.vicpin.krealmextensions.save
import com.vicpin.krealmextensions.saveAll
import io.realm.RealmObject
import kotlinx.coroutines.experimental.channels.BroadcastChannel
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.launch

fun <E> BroadcastChannel<E>.subscribe(consumer: (value: E) -> Unit) {
    launch {
        consumeEach { value ->
            consumer.invoke(value)
        }
    }
}

fun <E : RealmObject> BroadcastChannel<E>.store(element: E) {
    launch {
        send(element)
        element.save()
    }
}

fun <E : List<RealmObject>> BroadcastChannel<E>.store(elements: E) {
    launch {
        send(elements)
        elements.saveAll()
    }
}


