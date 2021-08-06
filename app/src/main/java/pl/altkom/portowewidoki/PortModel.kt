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
data class PortModel(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "countryCode") val countryCode: String,
    @field:Json(name = "imageUrl") val imageUrl: String = "",
    @field:Json(name = "lattitiude") val lattitiude: Double? = null,
    @field:Json(name = "longitude") val longitude: Double? = null,
    val isFavourite: Boolean = false
) : Parcelable

object PortStorage {

    fun getPorts() = NetworkService.portyService.getPorty().enqueue(object : retrofit2.Callback<List<PortModel>>{
        override fun onResponse(call: Call<List<PortModel>>, response: Response<List<PortModel>>) {
            TODO("Not yet implemented")
        }

        override fun onFailure(call: Call<List<PortModel>>, t: Throwable) {
            Log.e("HARBOURS", "Failed to fetch harbours", t)
        }

    })
}
