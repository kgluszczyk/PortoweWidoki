package pl.altkom.portowewidoki

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

fun View.setUpPortCardView(port: PortModel) {
    // TODO: Przywróć obrazki - > wsparcie Urls
    val imageView = findViewById<ImageView>(R.id.portImage)
    Glide.with(imageView)
        .load(port.image)
        .placeholder(R.drawable.ic_launcher_background)
        .into(imageView)
    findViewById<TextView>(R.id.portName).text = port.name
    findViewById<TextView>(R.id.portCountry).text = port.location
    if (port.isFavourite) {
        findViewById<TextView>(R.id.portName).setTextColor(resources.getColor(R.color.teal_700))
    } else {
        findViewById<TextView>(R.id.portName).setTextColor(resources.getColor(R.color.black))
    }
}