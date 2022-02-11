package cvut.fit.pidmobapp.repository.database.dao

import androidx.room.*
import cvut.fit.pidmobapp.model.Trip

@Dao
interface FavouriteTripsDao {

    @Query("SELECT * FROM Trip")
    fun getAll() : List<Trip>?

    @Query("SELECT * FROM Trip WHERE uid = :uid")
    fun getById(uid: String) : Trip?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(trip: Trip)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(trip: List<Trip>)

    @Update
    fun update(trip: Trip)

    @Delete
    fun delete(trip: Trip)

    @Query("delete from Trip")
    fun deleteAllFavouriteRoutes()
}
