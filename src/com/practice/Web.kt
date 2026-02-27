package com.practice;

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.InputStreamReader
import java.net.URL

class Web {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val weatherStation = weatherStation("ing")
            for (i in 1..weatherStation.size) {
                println(weatherStation[i - 1])
            }
        }

        fun weatherStation(keyword: String): Array<String> {

            val url = URL("https://jsonmock.hackerrank.com/api/weather/search?name=$keyword")
            val reader = InputStreamReader(url.openStream())
            try {
                val dto: WeatherData = Gson().fromJson(reader, WeatherData::class.java)
                if (dto.totalResults == 0) {
                    return emptyArray()
                }
                return dto.records.sortedBy { it.name }.map { weatherRecordData ->
                    val regex = Regex("\\d+")
                    val matchResult = regex.find(weatherRecordData.temperature)
                    val temperature = matchResult?.value?.toIntOrNull() ?: 0
                    //wind speed parsing
                    val windData = weatherRecordData.status.firstOrNull() { it.contains("Wind:") }
                    val windSpeed = windData?.let {
                        val matchWindResult = regex.find(it)
                        matchWindResult?.value?.toIntOrNull() ?: 0
                    } ?: run { 0 }

                    val humidityData = weatherRecordData.status.firstOrNull() { it.contains("Humidity:") }
                    val humidity = humidityData?.let {
                        val matchHumidityResult = regex.find(it)
                        matchHumidityResult?.value?.toIntOrNull() ?: 0
                    } ?: run { 0 }

                    val record = WeatherCityRecord(
                        cityName = weatherRecordData.name,
                        temperature = temperature,
                        windSpeed = windSpeed,
                        humidity = humidity
                    )
                    "${record.cityName},${record.temperature},${record.windSpeed},${record.humidity}"
                }.toTypedArray()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return emptyArray()
        }

        data class WeatherCityRecord(
            val cityName: String,
            val temperature: Int,
            val windSpeed: Int,
            val humidity: Int,
        )

        /*
        IMPORTANT: This class is created based on assumption that we receive non nullable data in certain parameters
        which are required for the weather data list records to work and show data properly. We handle the parsing of the
        data fails then the data received will be empty or no records found.
         */
        class WeatherData(
            /*
            current page number which starts from 1
             */
            @SerializedName("page")
            val pageNumber: Int,
            /*
            The maximum number of results per page
             */
            @SerializedName("per_page")
            val perPageResultsCount: Int,
            /*
            The total number of weather records in the search query
             */
            @SerializedName("total")
            val totalResults: Int,
            /*
            the total number of pages to query to get all the results
             */
            @SerializedName("total_pages")
            val totalNumberOfPages: Int,
            /*
            all the weather records
             */
            @SerializedName("data")
            val records: List<WeatherRecordCityData>
        )

        class WeatherRecordCityData(
            /*
            name of the city
             */
            val name: String,
            /*
            temperature of the city
             */
            @SerializedName("weather")
            val temperature: String,
            /*
            other details for e.g. wind, humidity
             */
            val status: List<String>
        )
    }
}
