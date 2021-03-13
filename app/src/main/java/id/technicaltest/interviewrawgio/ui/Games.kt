package id.technicaltest.interviewrawgio.ui

import android.app.Application
import id.technicaltest.core.di.apiModule
import id.technicaltest.core.di.databaseModule
import id.technicaltest.core.di.repositoryModule
import id.technicaltest.interviewrawgio.di.useCaseModule
import id.technicaltest.interviewrawgio.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Games : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@Games)
            modules(
                listOf(
                    databaseModule,
                    apiModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}