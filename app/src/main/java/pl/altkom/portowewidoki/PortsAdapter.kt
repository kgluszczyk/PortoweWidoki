package pl.altkom.portowewidoki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PortsAdapter(var portList: List<PortModel> = emptyList(), val clickListener: OnPortClick) : RecyclerView.Adapter<PortsViewHolder>() {

    fun setData(portList: List<PortModel>) {
        this.portList = portList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_port, parent, false)
        return PortsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PortsViewHolder, position: Int) {
        val port = portList[position]
        holder.bind(port, clickListener)
    }

    override fun getItemCount() = portList.size

}

class PortsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(port: PortModel, clickListener: OnPortClick) {
        with(itemView) {
            findViewById<ImageView>(R.id.portImage).setImageResource(port.image)
            findViewById<TextView>(R.id.portName).text = port.name
            findViewById<TextView>(R.id.portCountry).text = port.location
            setOnClickListener {
                clickListener(port)
                //Interface aka. Java style
                //clickListener.onClick(port)
            }
        }
    }
}
typealias OnPortClick = (PortModel) -> Unit

interface OnClick2 {
    fun onClick(model: PortModel)
}