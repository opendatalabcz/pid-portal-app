package cvut.fit.pidmobapp.model

data class User(
    val email: String,
    val favouriteRoutes: List<Route>,
    val favouriteTrips: List<Trip>,
    val id: Int,
    val name: String,
    val password: String,
    val role: String,
    val username: String
)