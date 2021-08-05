package pl.altkom.portowewidoki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PortyActivity : AppCompatActivity() {

    companion object {

        const val CountryKey = "CountryKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_porty)
        val selectedCountryCode = intent.extras?.getString(CountryKey)
        val portList = PortStorage.ports.filter { it.location == selectedCountryCode }
        val adapter = PortsAdapter(portList) { port ->
            Toast.makeText(this, "Kliknięto2:${port.name}", Toast.LENGTH_SHORT).show()
        }
        //Interface aka. Java style
        /* val adapter = PortsAdapter(portList, object : OnClick2 {
            override fun onClick(port: PortModel) {
                Toast.makeText(this@PortyActivity, "Kliknięto:${port.name}", Toast.LENGTH_SHORT).show()
            }

        })*/

        findViewById<RecyclerView>(R.id.port_list).adapter = adapter
    }
}

