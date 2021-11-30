package com.example.finalproject.models

import android.util.Log
import com.example.finalproject.models.interfaces.APIService
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException
import org.json.JSONObject
import retrofit2.Retrofit
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.Socket
import java.net.URL

class LoginModel {

    var username : String = ""
    var password : String = ""

    var serverIP : String = "127.0.0.1"
    var port: Int = 9000

    private val socket: Socket = Socket()


    fun tryToConnect() {
        println("Inside Model: $username")
        println("Inside Model: $password")

        var obj = JSONObject()
        obj.put("username", username)
        obj.put("password", password)


        val client = OkHttpClient()
        val reqBody = FormBody.Builder().add("username", username).add("password", password).build()
        val request = Request.Builder().url("https://10.0.0.5:8080/test").post(reqBody).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed in onFailure")
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful)
                        println("Failed")
                    throw IOException("Unexpected code $response")

                    for ((name, value) in response.headers) {
                        println("header: $name: $value")
                    }

                    println(response.body!!.toString())
                }

                println(response.message)
            }

        })
    }











        /*
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.0.5:8080")
            .build()

        // Create Service
        val service = retrofit.create(APIService::class.java)


        // Convert JSONObject to String
        val jsonObjectString = obj.toString()

        // Create RequestBody ( We're not using any converter, like GsonConverter, MoshiConverter e.t.c, that's why we use RequestBody )
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        CoroutineScope(Dispatchers.IO).launch {
            // Do the POST request and get response
            val response = service.attemptLogin(requestBody)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    // Convert raw JSON to pretty JSON using GSON library
                    println(response.body().toString())
                }
            }
        }



    }

         */

}