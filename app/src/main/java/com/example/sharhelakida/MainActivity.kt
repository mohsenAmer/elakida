package com.sharhelakida.sharhelakida

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.util.FitPolicy
import kotlinx.android.synthetic.main.activity_main.*

var pdfView : PDFView?=null

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pdfView = pdfviewer
        var shared = getSharedPreferences("info", MODE_PRIVATE);//<<<<<<=======================
        var  CurrentPage = shared.getInt("pagenum",0);//<<<<<<=======================
        pdfView!!.fromAsset("elakida2.pdf")
            .defaultPage(CurrentPage)//<<<<<<=======================
            .enableAnnotationRendering(true)
            .spacing(0) // in dp
            .swipeHorizontal(false)
            .pageFling(true)
            .swipeHorizontal(false)
            .load();

        home.setOnClickListener { pdfView!!.jumpTo(0) }

        save.setOnClickListener {
            var pref = getSharedPreferences("info", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = pref.edit()//<<<<<<=======================
            editor.putInt("pagenum", pdfView!!.getCurrentPage())//<<<<<<=======================
            editor.commit()//<
            Toast.makeText(this,"تم حفظ الصفحة",Toast.LENGTH_SHORT).show()

            }
        popmenu.setOnClickListener {
            val popup = PopupMenu(this@MainActivity,popmenu)
            popup.menuInflater.inflate(R.menu.menu,popup.menu)
            popup.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener{
                override fun onMenuItemClick(p0: MenuItem?): Boolean {
                    when(p0!!.itemId){
                        R.id.t1-> pdfView!!.jumpTo(45)
                        R.id.t2-> pdfView!!.jumpTo(79)
                        R.id.t3-> pdfView!!.jumpTo(161)
                        R.id.t4-> pdfView!!.jumpTo(188)
                        R.id.t5-> pdfView!!.jumpTo(215)
                        R.id.t6-> pdfView!!.jumpTo(283)
                        R.id.t7-> pdfView!!.jumpTo(336)

                    }
                    return true
                }
            })
            popup.show()
        }
        }


    }