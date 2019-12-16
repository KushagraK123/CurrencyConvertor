package com.empyrealgames.currencyconvertor

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONObject
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DownloadData().execute("http://data.fixer.io/api/latest?access_key=778a18d9d45590dfd908cf4338c0ddb3")
    }

     inner class DownloadData: AsyncTask<String, Void , String>(){
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                val jsonObject = JSONObject(result)
                println(jsonObject)

                val rates = JSONObject(jsonObject.get("rates").toString())

                println("rates are"  + rates)
                println("lenght = " + rates.length())
                var inr: Double = rates.getDouble("INR")
                var usd: Double = rates.getDouble("USD")
                println("1 USD equals to " + inr/usd + " rupees")

                }catch (e:Exception){
                e.printStackTrace()
            }
        }

        override fun doInBackground(vararg params: String?): String {

            println("here")
            val result = StringBuilder("")
            val url: URL
            val httpURLConnection: HttpURLConnection
            try {

                println("here1")
                url = URL(params[0])
                httpURLConnection = url.openConnection() as HttpURLConnection
                val inputStream = httpURLConnection.inputStream
                val inputStreamReader = InputStreamReader(inputStream)

                var data = inputStreamReader.read()
                while (data > 0){
                    result.append(data.toChar())
                    data =  inputStreamReader.read()
                }

            }catch (e: Exception){
                println("exception")
                e.printStackTrace()
            }


            println("here2")
            println(result)
            return result.toString()
        }

    }

}
