package info.xlkn.paws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_main.layoutManager = LinearLayoutManager(this)

        fetchJSON()
    }
    fun fetchJSON() {

        val id = "" // Add your access key here
        val Url = " https://api.unsplash.com/search/photos?query=dog&client_id=" + id

        val request = Request.Builder().url(Url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val httpBody = response.body?.string()

                val gson = GsonBuilder().create()

                val feed = gson.fromJson(httpBody, Feed::class.java)

                runOnUiThread{
                    recycler_main.adapter = MainAdapter(feed)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Error with request")
            }
        })

    }
}