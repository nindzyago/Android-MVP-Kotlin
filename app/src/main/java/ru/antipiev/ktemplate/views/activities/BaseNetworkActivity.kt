package ru.antipiev.ktemplate.views.activities

import ru.antipiev.ktemplate.contracts.NetworkContract

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
