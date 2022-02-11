package cvut.fit.pidmobapp.presentation.interfaces

import cvut.fit.pidmobapp.model.Trip

interface OnTripSelectListener {
    fun onTripSelect(trip: Trip)
}