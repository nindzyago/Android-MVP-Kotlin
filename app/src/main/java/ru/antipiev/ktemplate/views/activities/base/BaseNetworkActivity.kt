package ru.antipiev.ktemplate.views.activities.base

import ru.antipiev.ktemplate.contracts.base.NetworkContract

abstract class BaseNetworkActivity : BaseActivity(), NetworkContract {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
    override fun showProgress(show: Boolean) {
    }

    override fun showData() {
    }

    override fun showError(text: String) {
    }
}
