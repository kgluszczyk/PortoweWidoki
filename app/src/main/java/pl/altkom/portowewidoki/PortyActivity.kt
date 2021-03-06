package pl.altkom.portowewidoki

import android.hardware.Sensor
import android.hardware.Sensor.TYPE_ACCELEROMETER
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.altkom.portowewidoki.App.Companion.database
import pl.altkom.portowewidoki.PortStorage.fetchPorts
import retrofit2.Call
import retrofit2.Response
import java.lang.IllegalStateException
import kotlin.coroutines.CoroutineContext

class PortyActivity : AppCompatActivity() {

    companion object {

        const val CountryKey = "CountryKey"
    }

    val activityScope = CoroutineScope(Dispatchers.IO)

    lateinit var adapter: PortsAdapter
    var accelerometrListener: SensorEventListener? = null
    var portList: List<PortModel> = emptyList()

    override fun onStop() {
        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerometrListener?.let {
            sensorManager.unregisterListener(accelerometrListener)
        }
        super.onStop()
    }

    override fun onDestroy() {
        activityScope.cancel()
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_porty)
        val selectedCountryCode = intent.extras?.getString(CountryKey)
        //Wątki
        val zadanie1 = Thread {
            NetworkService.portyService.getPorty().execute().body()
            runOnUiThread {
                Toast.makeText(this, "Udało się", Toast.LENGTH_SHORT).show()
            }
        }
        //zadanie1.start()

        //Coroutines
        activityScope.launch {
            portList = NetworkService.portyService.getPortyNew().filter { it.location == selectedCountryCode }
            database.getPortyDao().delete()
            database.getPortyDao().insert(portList)
            val list2 = database.getPortyDao().get()
            withContext(Dispatchers.Main) {
                adapter.setData(list2)
            }
        }

        //Callback
        NetworkService.portyService.getPorty().enqueue(object : retrofit2.Callback<List<PortModel>> {
            override fun onResponse(call: Call<List<PortModel>>, response: Response<List<PortModel>>) {
            }

            override fun onFailure(call: Call<List<PortModel>>, t: Throwable) {
                Log.e("HARBOURS", "Failed to fetch harbours", t)
            }

        })
        adapter = PortsAdapter(portList) { port ->
            Toast.makeText(this, "Kliknięto2:${port.name}", Toast.LENGTH_SHORT).show()
            portList = portList.map { it ->
                if (it == port) {
                    it.copy(isFavourite = !port.isFavourite)
                } else {
                    it
                }
            }
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
                        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
                        val accelerometer = sensorManager.getDefaultSensor(TYPE_ACCELEROMETER)
                        accelerometrListener = object : SensorEventListener {
                            override fun onSensorChanged(event: SensorEvent) {
                                Log.d(
                                    "SENSORY",
                                    "AC:x:${event.values[0]}, y:${event.values[1]}, z:${event.values[2]}"
                                )
                            }

                            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

                            }

                        }
                        sensorManager.registerListener(
                            accelerometrListener,
                            accelerometer,
                            SensorManager.SENSOR_DELAY_UI
                        )

                        Log.d("MENU", "Żartowałem!")
                        return@setOnMenuItemClickListener true
                    }
                    R.id.action1 -> {
                        return@setOnMenuItemClickListener true
                    }
                }
                false
            }
        }
    }
}

