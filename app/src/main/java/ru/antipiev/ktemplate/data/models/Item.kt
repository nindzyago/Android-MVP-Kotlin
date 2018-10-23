package ru.antipiev.ktemplate.data.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Item : RealmObject() {
    @PrimaryKey
    var id: Int = 0
    var name: String = ""
}
