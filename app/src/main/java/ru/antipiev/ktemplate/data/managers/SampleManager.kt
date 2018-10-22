package ru.antipiev.ktemplate.data.managers

import com.vicpin.krealmextensions.queryAll
import io.realm.Realm
import io.realm.RealmObject
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import ru.antipiev.ktemplate.data.api.RestApi
import ru.antipiev.ktemplate.data.models.Item

class SampleManager(private val restApi: RestApi,
                    private val realm: Realm) {

//    fun items : ReceiveChannel<Int>
//
//    fun getData() = produce<List<Item>> {
//        var results = realm.where(Item::class.java).findAll()
//        send(results)
//        results.addChangeListener { it -> run { launch { send(it) } } }
//    }

    fun getNetItems() = runBlocking { restApi.sample.list().await() }
    fun getDbItems() = Item().queryAll()

}

fun RealmObject.getAllResults(): Any {
    val realm = Realm.getDefaultInstance()
    realm.use { it -> return it.copyFromRealm(it.where(this::class.java).findAll()) }
}

//fun RealmObject.produceAll() = produce<this::class.java> {
//        var results = realm.where(Item::class.java).findAll()
//        send(results)
//        results.addChangeListener { it -> run { launch { send(it) } } }
//    }
//}
