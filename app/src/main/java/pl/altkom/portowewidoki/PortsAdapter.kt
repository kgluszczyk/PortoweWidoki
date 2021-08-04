package pl.altkom.portowewidoki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PortsAdapter(var portList: List<PortModel> = emptyList()) : RecyclerView.Adapter<PortsViewHolder>() {

    fun setData(portList: List<PortModel>) {
        this.portList = portList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_port, parent, false)
        return PortsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PortsViewHolder, position: Int) {
        val port = portList[position]
        holder.bind(port)
    }

    override fun getItemCount() = portList.size

}

class PortsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(port: PortModel) {
        with(itemView) {
            findViewById<ImageView>(R.id.portImage).setImageResource(port.image)
            findViewById<TextView>(R.id.portName).text = port.name
            findViewById<TextView>(R.id.portCountry).text = port.location
        }
    }
}