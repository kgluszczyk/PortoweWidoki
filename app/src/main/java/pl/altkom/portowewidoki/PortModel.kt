package pl.altkom.portowewidoki

import android.os.Parcelable
import android.util.Log
import androidx.annotation.DrawableRes
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import retrofit2.Call
import retrofit2.Response

@Parcelize
@JsonClass(generateAdapter = true)
data class PortModel(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "countryCode") val location: String,
    @field:Json(name = "imageUrl") val image: String = "",
    @field:Json(name = "lattitiude") val lat: Double? = null,
    @field:Json(name = "longitude") val long: Double? = null,
    val isFavourite: Boolean = false
) : Parcelable

object PortStorage {

    fun fetchPorts() {
        NetworkService.portyService.getPorty().execute().body()
    }
}
