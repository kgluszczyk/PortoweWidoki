package pl.altkom.portowewidoki

import android.app.Application
import androidx.room.Room

class App : Application() {

    companion object {

        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "appDatabase"
        ).fallbackToDestructiveMigration()
            .build()
    }
}