package pl.altkom.portowewidoki

import androidx.annotation.DrawableRes

data class PortModel(val name: String, val location: String, @DrawableRes val image: Int)

object PortStorage {

    val ports = listOf(PortModel(name = "Port1", location = "PL", image = R.drawable.port))
}
