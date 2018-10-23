package ru.antipiev.ktemplate.contracts.base

interface NetworkContract : BaseContract {
    fun showProgress(show: Boolean)
    fun showData()
    fun showError(text: String)
}
