package pl.altkom.portowewidoki

import android.view.View
import android.widget.ImageView
import android.widget.TextView

fun View.setUpPortCardView(port: PortModel) {
    findViewById<ImageView>(R.id.portImage).setImageResource(port.image)
    findViewById<TextView>(R.id.portName).text = port.name
    findViewById<TextView>(R.id.portCountry).text = port.location
    if (port.isFavourite) {
        findViewById<TextView>(R.id.portName).setTextColor(resources.getColor(R.color.teal_700))
    } else {
        findViewById<TextView>(R.id.portName).setTextColor(resources.getColor(R.color.black))
    }
}