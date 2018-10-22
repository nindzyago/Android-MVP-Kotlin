package ru.antipiev.ktemplate.contracts

interface BaseLifeCycle: BaseContract {
    fun setupUI()
    fun setupUX()
    fun unbindUX()
}
