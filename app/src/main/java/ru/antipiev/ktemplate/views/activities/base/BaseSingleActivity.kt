package ru.antipiev.ktemplate.views.activities.base

import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.toolbar_single.*

abstract class BaseSingleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolbar()
    }

    open fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


//    override fun onBackPressed() {
//        finish()
//        overridePendingTransition(team.asapp.android.R.anim.no_animation, team.asapp.android.R.anim.no_animation)
//    }


//    protected fun hideView(view: View) {
//        if (view.visibility == View.VISIBLE) {
//            view.visibility = View.GONE
//        }
//    }
//
//    protected fun showView(view: View) {
//        if (view.visibility == View.GONE) {
//            view.visibility = View.VISIBLE
//        }
//    }
}
