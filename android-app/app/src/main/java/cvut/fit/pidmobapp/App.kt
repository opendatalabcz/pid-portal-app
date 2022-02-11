package cvut.fit.pidmobapp

import android.app.Application
import cvut.fit.pidmobapp.di.appModule
import cvut.fit.pidmobapp.di.dataModule
import cvut.fit.pidmobapp.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}