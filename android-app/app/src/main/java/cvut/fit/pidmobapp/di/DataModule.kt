package cvut.fit.pidmobapp.di

import cvut.fit.pidmobapp.repository.database.AppDatabase
import cvut.fit.pidmobapp.repository.server.ServerCommunicator
import cvut.fit.pidmobapp.repository.AppRepository
import org.koin.dsl.module

val dataModule = module {

    single { ServerCommunicator() }

    single { AppDatabase.getInstance( get() ) }

    single<AppRepository> {
        cvut.fit.pidmobapp.repository.AppRepositoryImpl(
            serverCommunicator = get(),
            database = get()
        )
    }

}