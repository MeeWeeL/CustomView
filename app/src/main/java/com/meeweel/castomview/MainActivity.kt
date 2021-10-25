package com.meeweel.castomview

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meeweel.castomview.api.ApiApp
import com.meeweel.castomview.api.MyApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetch((application as ApiApp).myApi)
    }

    private fun fetch(myApi: MyApi) {
        compositeDisposable.add(myApi.getPic()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val picLink = it.image
                loadPicture(picLink)
            }, {

            }))
    }

    private fun loadPicture(picLinc: String) {
        Thread {
            val pic: Bitmap
            try {
                val url = URL(picLinc)
                pic = BitmapFactory.decodeStream(url.openStream())
                runOnUiThread {
                    findViewById<MyView>(R.id.my_view).setImageBitmap(pic)
                }
            } catch (e: IOException) {

            }
        }.start()
    }
}