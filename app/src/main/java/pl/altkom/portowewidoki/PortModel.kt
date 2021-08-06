package pl.altkom.portowewidoki

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class PortModel(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "countryCode") val location: String,
    @field:Json(name = "imageUrl") val image: String = "",
    @field:Json(name = "lattitiude") val lat: Double? = null,
    @field:Json(name = "longitude") val long: Double? = null,
    val isFavourite: Boolean = false
) : Parcelable

object PortStorage {

    val ports = listOf(
        PortModel(name = "Port1", location = "PL"),
        PortModel(name = "Port2", location = "PL"),
        PortModel(name = "Port3", location = "PL"),
        PortModel(name = "Port4", location = "PL"),
        PortModel(name = "Port5", location = "PL"),
        PortModel(name = "Port6", location = "PL"),
        PortModel(name = "Port7", location = "PL"),
        PortModel(name = "Port8", location = "DE"),
        PortModel(name = "Port12", location = "PL"),
        PortModel(name = "Port22", location = "PL"),
        PortModel(name = "Port32", location = "PL"),
        PortModel(name = "Port42", location = "PL"),
        PortModel(name = "Port52", location = "PL"),
        PortModel(name = "Port62", location = "PL"),
        PortModel(name = "Port72", location = "PL"),
        PortModel(name = "Port82", location = "DE"),
        PortModel(name = "Port13", location = "PL"),
        PortModel(name = "Port23", location = "PL"),
        PortModel(name = "Port33", location = "PL"),
        PortModel(name = "Port43", location = "PL"),
        PortModel(name = "Port53", location = "PL"),
        PortModel(name = "Port63", location = "PL"),
        PortModel(name = "Port73", location = "PL"),
        PortModel(name = "Port83", location = "DE"),
    )
}
