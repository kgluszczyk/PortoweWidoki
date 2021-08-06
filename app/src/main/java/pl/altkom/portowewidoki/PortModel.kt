package pl.altkom.portowewidoki

import android.os.Parcelable
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import retrofit2.Call
import retrofit2.Response

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
data class PortModel(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "portName") @field:Json(name = "name") var name: String = "",
    @ColumnInfo(name = "countryCode") @field:Json(name = "countryCode") var location: String = "",
    @ColumnInfo(name = "imageUrl") @field:Json(name = "imageUrl") var image: String = "",
    @ColumnInfo(name = "lattitiude") @field:Json(name = "lattitiude") var lat: Double? = null,
    @ColumnInfo(name = "longitude") @field:Json(name = "longitude") var lon: Double? = null,
    @ColumnInfo(name = "isFavourite") var isFavourite: Boolean = false,
) : Parcelable

object PortStorage {

    fun fetchPorts() {
        NetworkService.portyService.getPorty().execute().body()
    }
}
