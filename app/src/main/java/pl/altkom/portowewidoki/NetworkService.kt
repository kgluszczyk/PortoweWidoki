package pl.altkom.portowewidoki

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object NetworkService {

    //val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL_HARBOURS)
        .build()
    val portyService = retrofit.create(HarboursService::class.java)
}

interface HarboursService {

    @GET("harbours")
    fun getPorty(): Call<List<PortModel>>

    @GET("harbours")
    suspend fun getPortyNew(): List<PortModel>
}