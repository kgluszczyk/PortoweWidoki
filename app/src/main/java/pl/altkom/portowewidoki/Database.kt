package pl.altkom.portowewidoki

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase

@Database(entities = [PortModel::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPortyDao(): PortyDao
}

@Dao
interface PortyDao {

    @Query("DELETE FROM portmodel")
    fun delete()

    @Query("SELECT * FROM portmodel ORDER BY portmodel.lattitiude DESC")
    fun get(): List<PortModel>

    @Insert
    fun insert(porty: List<PortModel>)
}