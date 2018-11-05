package ru.antipiev.ktemplate.utils.extensions

import com.vicpin.krealmextensions.save
import com.vicpin.krealmextensions.saveAll
import io.realm.RealmObject
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun <E> BroadcastChannel<E>.subscribe(consumer: (value: E) -> Unit) {
    coroutineScope {
        consumeEach { value ->
            consumer.invoke(value)
        }
    }
}

fun <E : RealmObject> BroadcastChannel<E>.store(element: E) {
    GlobalScope.launch {
        send(element)
    }
    element.save()
}

fun <E : List<RealmObject>> BroadcastChannel<E>.store(elements: E) {
    GlobalScope.launch {
        send(elements)
    }
    elements.saveAll()
}


