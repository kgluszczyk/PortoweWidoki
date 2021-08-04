package pl.altkom.portowewidoki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class PortyActivity : AppCompatActivity() {

    companion object {

        const val CountryKey = "CountryKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_porty)
        intent.extras?.getString(CountryKey).also { text ->
            Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}

