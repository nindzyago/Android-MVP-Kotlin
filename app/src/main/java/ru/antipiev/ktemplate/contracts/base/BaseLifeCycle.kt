package ru.antipiev.ktemplate.contracts.base

interface BaseLifeCycle: BaseContract {
    fun setupUI()
    fun setupUX()
    fun unbindUX()
}
