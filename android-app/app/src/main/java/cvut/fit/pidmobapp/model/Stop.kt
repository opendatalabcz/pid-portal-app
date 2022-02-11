package cvut.fit.pidmobapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName
import cvut.fit.pidmobapp.R
import cvut.fit.pidmobapp.utils.BaseClusterItem

@Entity
data class Stop(
    @PrimaryKey
    @SerializedName("id")
    val uid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("zoneId")
    val zoneId: String,
    @SerializedName("weelchair")
    val wheelchair: Int,
    @SerializedName("parentStation")
    val parentStation: String
    ) : BaseClusterItem() {

    override fun getPosition(): LatLng =
            LatLng(lat, lon)

    override fun getTitle(): String =
            name

    override fun getSnippet(): String =
            name

    override val drawable: Int
        get() = R.drawable.ic_baseline_directions_bus_24

    override val color: Int
        get() = R.color.black
}
