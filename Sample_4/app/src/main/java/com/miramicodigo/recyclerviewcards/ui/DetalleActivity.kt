package com.miramicodigo.recyclerviewcards.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Typeface
import com.miramicodigo.recyclerviewcards.R
import com.miramicodigo.recyclerviewcards.model.Pokemon
import kotlinx.android.synthetic.main.activity_detalle.*

class DetalleActivity : AppCompatActivity() {

    lateinit var tf_black: Typeface
    lateinit var tf_thin: Typeface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        tf_black = Typeface.createFromAsset(assets, "fonts/roboto_black.ttf")
        tf_thin = Typeface.createFromAsset(assets, "fonts/roboto_thin.ttf")

        tvDetalleTitulo.typeface = tf_black
        tvDetalleSubtitulo.typeface = tf_thin




    }
}
