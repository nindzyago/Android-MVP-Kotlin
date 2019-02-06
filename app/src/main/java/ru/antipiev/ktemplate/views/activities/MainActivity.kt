package ru.antipiev.ktemplate.views.activities

import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get

import ru.antipiev.ktemplate.contracts.MainActivityContract
import ru.antipiev.ktemplate.data.adapters.ItemsAdapter
import ru.antipiev.ktemplate.data.models.Item
import ru.antipiev.ktemplate.presenters.MainActivityPresenter
import ru.antipiev.ktemplate.views.activities.base.DrawerActivity

class MainActivity : DrawerActivity(), MainActivityContract {

    private lateinit var adapter: ItemsAdapter
    override var navigationListener = { item: MenuItem -> mainPresenter.onNavigationItemSelected(item) }

    override fun setupUI() {
    }

    override fun setupUX() {
        adapter = ItemsAdapter { item -> mainPresenter.itemClick(item) }
        rv_items.adapter = adapter
        rv_items.layoutManager = LinearLayoutManager(this)
    }

    override fun unbindUX() {
    }

    override fun showItems(items: List<Item>) {
        adapter.items = items
    }

    @InjectPresenter
    lateinit var mainPresenter: MainActivityPresenter

    @ProvidePresenter
    internal fun provideMainActivityPresenter(): MainActivityPresenter = get()

}
