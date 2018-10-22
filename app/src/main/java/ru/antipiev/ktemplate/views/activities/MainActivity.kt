package ru.antipiev.ktemplate.views.activities

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get

import ru.antipiev.ktemplate.R
import ru.antipiev.ktemplate.contracts.MainActivityContract
import ru.antipiev.ktemplate.presenters.MainActivityPresenter

class MainActivity : BaseActivity(), MainActivityContract {

    override fun setupUI() {
    }

    override fun setupUX() {
    }

    override fun unbindUX() {
    }

    override fun showItems(items: List<String>) {
        tvHello.text = items.toString()
    }

    override val layout = R.layout.activity_main

    @InjectPresenter
    lateinit var mainPresenter: MainActivityPresenter

    @ProvidePresenter
    internal fun provideMainActivityPresenter(): MainActivityPresenter = get()

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }


}
