package cvut.fit.pidmobapp.repository.database.dao

import androidx.room.*
import cvut.fit.pidmobapp.model.Route

@Dao
interface RouteDao {

    @Query("SELECT * FROM Route WHERE uid LIKE :uid")
    fun getById(uid: String) : Route?

    @Query("SELECT * FROM Route WHERE longName LIKE '%' || :request || '%'")
    fun getByNameLike(request: String) : List<Route>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(route: Route)

    @Update
    fun update(route: Route)

    @Delete
    fun delete(route: Route)

    @Query("delete from Route")
    fun deleteAllRoutes()
}