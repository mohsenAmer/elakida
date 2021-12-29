package com.sharhelakida.sharhelakida

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2)
        entar.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        rate.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=MohsenAmer"))
            var intentchoos = Intent.createChooser(intent,"map")
            startActivity(intentchoos)

        }
    }
}