package cvut.fit.pidmobapp.di

import cvut.fit.pidmobapp.domain.viewmodel.LoginSharedViewModel
import cvut.fit.pidmobapp.domain.viewmodel.MapsSharedViewModel
import cvut.fit.pidmobapp.presentation.fragment.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { cvut.fit.pidmobapp.App() }

    viewModel {
        MapsSharedViewModel(application = get())
    }

    viewModel {
        LoginSharedViewModel(application = get())
    }

    factory {
        RouteFragment()
    }

    factory {
        SearchResultsFragment()
    }

    factory {
        StopFragment()
    }

    factory {
        TripFragment()
    }

    factory {
        LoginFragment()
    }

    factory {
        SignUpFragment()
    }

    factory {
        FavouriteRoutesFragment()
    }

    factory {
        FavouriteTripsFragment()
    }
}