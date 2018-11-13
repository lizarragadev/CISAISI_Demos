package com.miramicodigo.pedidos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    var cantidad = 1
    var precio = 2.5
    var total : Double = 0.toDouble()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun mas(v: View) {


    }

    fun menos(v: View) {


    }

    fun calcular(v: View) {



    }
}
