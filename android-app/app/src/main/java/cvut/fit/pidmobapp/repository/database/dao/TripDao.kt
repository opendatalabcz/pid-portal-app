package cvut.fit.pidmobapp.repository.database.dao

import androidx.room.*
import cvut.fit.pidmobapp.model.Trip

@Dao
interface TripDao {

    @Query("SELECT * FROM trip WHERE uid LIKE :id")
    fun getById(id: String): Trip?

    @Query("SELECT * FROM trip WHERE routeId LIKE :routeId")
    fun getByRouteId(routeId: String): Trip?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(trip: Trip)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(trips: List<Trip>)

    @Update
    fun update(trip: Trip)

    @Delete
    fun delete(trip: Trip)

    @Query("delete from Trip")
    fun deleteAllTrips()
}