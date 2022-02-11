package cvut.fit.pidmobapp.model

import androidx.room.PrimaryKey

data class Shape(
    val distTraveled: Double,
    val lat: Double,
    val lon: Double,
    val uid: ShapeUid
) {
    @PrimaryKey(autoGenerate = true)
    var id :Int = 0
}