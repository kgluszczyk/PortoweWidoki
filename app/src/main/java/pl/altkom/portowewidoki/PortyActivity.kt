package pl.altkom.portowewidoki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import java.lang.IllegalStateException

class PortyActivity : AppCompatActivity() {

    companion object {

        const val CountryKey = "CountryKey"
    }

    lateinit var adapter: PortsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_porty)
        val selectedCountryCode = intent.extras?.getString(CountryKey)
        var portList = PortStorage.ports.filter { it.location == selectedCountryCode }
        adapter = PortsAdapter(portList) { port ->
            Toast.makeText(this, "Kliknięto2:${port.name}", Toast.LENGTH_SHORT).show()
            portList = portList.map { it ->
                if (it == port) {
                    it.copy(isFavourite = !port.isFavourite)
                } else {
                    it
                }
            }
            adapter.setData(portList)
            supportFragmentManager.beginTransaction()
                .replace(R.id.port_detail_container, PortFragment.newInstance(port))
                .addToBackStack("PortFragment")
                .commit()
        }
        //Interface aka. Java style
        /* val adapter = PortsAdapter(portList, object : OnClick2 {
            override fun onClick(port: PortModel) {
                Toast.makeText(this@PortyActivity, "Kliknięto:${port.name}", Toast.LENGTH_SHORT).show()
            }

        })*/

        findViewById<RecyclerView>(R.id.port_list).adapter = adapter
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar?.let {
            it.setNavigationOnClickListener {
                throw IllegalStateException("Mówiełem, nie klikać!")
            }

            it.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action0 -> {
                        Log.d("MENU", "Żartowałem!")
                        return@setOnMenuItemClickListener true
                    }
                    R.id.action1 -> {
                        Toast.makeText(this, "KLIK!", Toast.LENGTH_SHORT).show()
                        return@setOnMenuItemClickListener true
                    }
                }
                false
            }
        }
    }
}

