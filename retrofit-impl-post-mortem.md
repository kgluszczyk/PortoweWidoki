# Wersja 1, bez generacji kodu, bazujaca na refleksji

```
    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
```
    
Uwagi:
1. Pole klasy musi mieć tą samą nazwę to pole w kontrakcie -> uwaga na proguarda, jesli nie damy keep-a na klasy, zapytanie sieciowe przestanie działać na releasowym buildzie
      
# Wersja 2, generacja klasy podczas przetwarzania anotacji

```
    build.gradle
    plugins {
        .   
        .
        .
        id 'kotlin-kapt'
    }
    
    dependencies {
        .
        .
        .
        kapt "com.squareup.moshi:moshi-kotlin-codegen:1.12.0"
    }
    
    @JsonClass(generateAdapter = true)
    data class PortModel(....
    
    NetworkService.kts
    
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
        
```

Uwagi:
1. Możliwość oznaczenia pól annotacją `@field:Json` w celu uniknięcia problemu z werji 1