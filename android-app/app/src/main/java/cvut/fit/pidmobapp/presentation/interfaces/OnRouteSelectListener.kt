package cvut.fit.pidmobapp.presentation.interfaces

import cvut.fit.pidmobapp.model.Route

interface OnRouteSelectListener{
    fun onRouteSelect(stopId: String, route: Route)
}