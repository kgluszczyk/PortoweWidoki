package pl.altkom.portowewidoki

import androidx.annotation.DrawableRes

data class PortModel(val name: String, val location: String, @DrawableRes val image: Int, val isFavourite: Boolean = false)

object PortStorage {

    val ports = listOf(
        PortModel(name = "Port1", location = "PL", image = R.drawable.port),
        PortModel(name = "Port2", location = "PL", image = R.drawable.port_2),
        PortModel(name = "Port3", location = "PL", image = R.drawable.port_3),
        PortModel(name = "Port4", location = "PL", image = R.drawable.port_4),
        PortModel(name = "Port5", location = "PL", image = R.drawable.port_5),
        PortModel(name = "Port6", location = "PL", image = R.drawable.port_6),
        PortModel(name = "Port7", location = "PL", image = R.drawable.port_7),
        PortModel(name = "Port8", location = "DE", image = R.drawable.port_8),
        PortModel(name = "Port12", location = "PL", image = R.drawable.port),
        PortModel(name = "Port22", location = "PL", image = R.drawable.port_2),
        PortModel(name = "Port32", location = "PL", image = R.drawable.port_3),
        PortModel(name = "Port42", location = "PL", image = R.drawable.port_4),
        PortModel(name = "Port52", location = "PL", image = R.drawable.port_5),
        PortModel(name = "Port62", location = "PL", image = R.drawable.port_6),
        PortModel(name = "Port72", location = "PL", image = R.drawable.port_7),
        PortModel(name = "Port82", location = "DE", image = R.drawable.port_8),
        PortModel(name = "Port13", location = "PL", image = R.drawable.port),
        PortModel(name = "Port23", location = "PL", image = R.drawable.port_2),
        PortModel(name = "Port33", location = "PL", image = R.drawable.port_3),
        PortModel(name = "Port43", location = "PL", image = R.drawable.port_4),
        PortModel(name = "Port53", location = "PL", image = R.drawable.port_5),
        PortModel(name = "Port63", location = "PL", image = R.drawable.port_6),
        PortModel(name = "Port73", location = "PL", image = R.drawable.port_7),
        PortModel(name = "Port83", location = "DE", image = R.drawable.port_8),
    )
}
