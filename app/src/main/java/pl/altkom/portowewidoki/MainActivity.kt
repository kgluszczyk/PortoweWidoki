package pl.altkom.portowewidoki

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    val tag = "LIFECYCLE"
    val ResumeCountKey = "ResumeCountKey"
    var onResumeCount = 0

    val takePhotoAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if(result.resultCode == Activity.RESULT_OK) {
            val image = result.data?.extras?.get("data") as Bitmap
            findViewById<ImageView>(R.id.icon).setImageBitmap(image)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onResumeCount = savedInstanceState?.getInt(ResumeCountKey) ?: onResumeCount
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.cta).setOnClickListener {
            findViewById<EditText>(R.id.country).text.also { text ->
                Intent(this, PortyActivity::class.java).apply {
                    putExtra(PortyActivity.CountryKey, text.toString())
                }.also {
                    startActivity(it)
                }
            }
        }
        Log.d(tag, "ON_CREATE")

        findViewById<ImageView>(R.id.icon).setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            takePhotoAction.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(ResumeCountKey, onResumeCount)
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        if (BuildConfig.DEBUG) {
            Log.d(tag, "ON_START")
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "ON_RESTART")
    }

    override fun onResume() {
        super.onResume()
        onResumeCount++
        Log.d(tag, "ON_RESUME_$onResumeCount")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "ON_PAUSE")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "ON_STOP")
    }

    override fun onDestroy() {
        Log.d(tag, "ON_DESTROY")
        super.onDestroy()
    }

    override fun onBackPressed() {
        Log.d(tag, "ON_BACK_PRESSED")
        super.onBackPressed()
    }
}