package pl.altkom.portowewidoki

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class PortFragment : Fragment(R.layout.item_fragment) {

    companion object {

        val PortDetailsKey = "PortDetailsKey"

        fun newInstance(portModel: PortModel): Fragment {
            val fragment = PortFragment()
            fragment.arguments = Bundle().apply {
                putParcelable(PortDetailsKey, portModel)
            }
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val portModel = arguments?.getParcelable<PortModel>(PortDetailsKey)
        portModel?.let {
            view.setUpPortCardView(it)
            view.findViewById<TextView>(R.id.title).text = it.name
        }
    }
}