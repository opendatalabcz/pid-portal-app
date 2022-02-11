package cvut.fit.pidmobapp.repository.database.dao

import androidx.room.*
import cvut.fit.pidmobapp.model.Route

@Dao
interface FavouriteRoutesDao {

    @Query("SELECT * FROM Route")
    fun getAll() : List<Route>?

    @Query("SELECT * FROM Route WHERE uid = :uid")
    fun getById(uid: String) : Route?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(route: Route)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(route: List<Route>)

    @Update
    fun update(route: Route)

    @Delete
    fun delete(route: Route)

    @Query("delete from Route")
    fun deleteAllFavouriteRoutes()
}