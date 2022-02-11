package cvut.fit.pidmobapp.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cvut.fit.pidmobapp.repository.database.dao.*
import cvut.fit.pidmobapp.model.*

@Database(entities = [Trip::class, Route::class, Stop::class, Position::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tripDao(): TripDao
    abstract fun favouriteRoutesDao(): FavouriteRoutesDao
    abstract fun favouriteTripsDao(): FavouriteTripsDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): AppDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, AppDatabase::class.java,
                    "note_database")
                    .fallbackToDestructiveMigration()
                    .build()
            return instance!!
        }
    }
}