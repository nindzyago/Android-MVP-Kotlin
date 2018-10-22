package ru.antipiev.ktemplate.views.fragments

import ru.antipiev.ktemplate.contracts.NetworkContract

abstract class BaseNetworkFragment : BaseFragment(), NetworkContract {


//    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
//    }

    override fun showProgress(show: Boolean) {
    }

    override fun showData() {
    }

    override fun showError(text: String) {
    }
}
