package pl.altkom.portowewidoki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    val tag = "LIFECYCLE"
    val ResumeCountKey = "ResumeCountKey"
    var onResumeCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tag, "ON_CREATE")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(ResumeCountKey, onResumeCount)
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        if(BuildConfig.DEBUG) {
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