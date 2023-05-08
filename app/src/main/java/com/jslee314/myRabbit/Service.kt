package com.jslee314.myRabbit

import com.squareup.moshi.JsonClass
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface DevbyteService {
    @GET("devbytes")
    suspend fun getPlaylist(): NetworkVideoContainer
}



/**
 * Main entry point for network access. Call like `DevByteNetwork.devbytes.getPlaylist()`
 */
object DevByteNetwork {

    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val devbytes = retrofit.create(DevbyteService::class.java)

}

@JsonClass(generateAdapter = true)
data class NetworkVideoContainer(val videos: List<NetworkVideo>)

@JsonClass(generateAdapter = true)
data class NetworkVideo(
    val title: String,
    val description: String,
    val url: String,
    val updated: String,
    val thumbnail: String, )


//"title":"Android Jetpack: EmojiCompat",
//"description":"With the EmojiCompat library, part of Jetpack, your app can get backwards-compatible emoji support on devices with API level 19 and higher and get rid of the blank square characters. To use EmojiCompat, initialize the library when the application starts by using downloadable or bundled fonts. Start supporting emojis in your text views, either by integrating the provided widgets or update your custom views by using the provided helper classes. \n\nFor more information:\nEmojiCompat guide → https://goo.gl/7bEoXB \nEmojiCompat sample app → https://goo.gl/7bEoXB \nGoogle I/O 2017 talk on “What’s new in Support Library” → https://goo.gl/KeRvqB\n\nWatch more Android Jetpack videos here → https://goo.gl/kw8LPv\n\nSubscribe to the Android Developers channel here → https://goo.gl/vLYDU\n\n#jetpack #featured",
//"url":"https://www.youtube.com/watch?v=sYGKUtM2ga8",
//"updated":"2018-06-07T17:09:43+00:00",
//"thumbnail":"https://i4.ytimg.com/vi/sYGKUtM2ga8/hqdefault.jpg