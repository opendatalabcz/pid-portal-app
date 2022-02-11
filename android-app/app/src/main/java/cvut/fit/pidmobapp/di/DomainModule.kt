package cvut.fit.pidmobapp.di

import cvut.fit.pidmobapp.domain.actions.*
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetAllStopsAction(appRepository =  get())
    }

    factory {
        GetRouteByIdAction(appRepository =  get())
    }

    factory {
        GetRouteByNameLikeAction(appRepository =  get())
    }

    factory {
        GetRouteNextArriveAction(appRepository =  get())
    }

    factory {
        GetRouteShapeVehiclesByRouteIdAction(appRepository =  get())
    }

    factory {
        GetClosesTripAction(appRepository =  get())
    }

    factory {
        GetVehicleAction(appRepository =  get())
    }

    factory {
        GetTripAction(appRepository =  get())
    }

    factory {
        GetFavouriteRouteByUidAction(appRepository =  get())
    }

    factory {
        GetFavouriteRoutesAction(appRepository =  get())
    }

    factory {
        GetFavouriteTripsAction(appRepository =  get())
    }

    factory {
        SaveFavouriteRouteAction(appRepository =  get())
    }

    factory {
        DeleteFavouriteRouteAction(appRepository =  get())
    }

    factory {
        SignInAction(appRepository =  get())
    }

    factory {
        SignUpAction(appRepository =  get())
    }

    factory {
        ClearFavouritesAction(appRepository =  get())
    }

    factory {
        SaveFavouriteRoutesAction(appRepository =  get())
    }

    factory {
        SaveFavouriteTripsAction(appRepository =  get())
    }

    factory {
        GetFavouriteTripByUidAction(appRepository =  get())
    }

    factory {
        DeleteFavouriteAction(appRepository =  get())
    }

    factory {
        SaveFavouriteTripAction(appRepository =  get())
    }
}