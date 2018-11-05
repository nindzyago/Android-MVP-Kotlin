package ru.antipiev.ktemplate


import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.android.startKoin
import ru.antipiev.ktemplate.di.appModules


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this);
        startKoin(this, appModules)
        setupRealm()
    }

    private fun setupRealm() {
        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .schemaVersion(Const.DB_VERSION) // Must be bumped when the schema changes
//                .migration(Migration())
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)
    }

}
