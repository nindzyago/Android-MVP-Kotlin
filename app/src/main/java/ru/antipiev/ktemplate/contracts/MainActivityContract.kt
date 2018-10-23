package ru.antipiev.ktemplate.contracts

import ru.antipiev.ktemplate.contracts.base.BaseContract
import ru.antipiev.ktemplate.data.models.Item

interface MainActivityContract : BaseContract {
    fun showItems(items: List<Item>)
}
