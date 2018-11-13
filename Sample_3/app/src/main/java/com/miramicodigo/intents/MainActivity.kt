package com.miramicodigo.intents

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import android.app.Activity
import android.app.SearchManager
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener {
    val DEVUELVE_DATOS = 2
    val PERMISO_LLAMADA = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ibAbrirActivity.setOnClickListener{
            abrirActivity()
        }

        ibEnviarDatos.setOnClickListener{
            enviarDatos()
        }

        ibDevolverDatos.setOnClickListener{
            devolverDatos()
        }

        ibAbrirMarcado.setOnClickListener(this)
        ibLlamar.setOnClickListener(this)
        ibAbrirGoogleMaps.setOnClickListener(this)
        ibAbrirStreetView.setOnClickListener(this)
        ibAbrirPaginaWeb.setOnClickListener(this)
        ibAbrirBuscador.setOnClickListener(this)
        ibCompartirTexto.setOnClickListener(this)
        ibEnviarEmail.setOnClickListener(this)
        ibAbrirApp.setOnClickListener(this)
        ibAsignarWallpaper.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when(view!!.id) {
            ibAbrirMarcado.id -> abrirMarcado()
            ibLlamar.id -> llamar()
            ibAbrirGoogleMaps.id -> abrirGoogleMaps()
            ibAbrirStreetView.id -> abrirStreetView()
            ibAbrirPaginaWeb.id -> abrirPaginaWeb()
            ibAbrirBuscador.id -> abrirBuscador()
            ibCompartirTexto.id -> compartirTexto()
            ibEnviarEmail.id -> enviarEmail()
            ibAbrirApp.id -> abrirApp()
            ibAsignarWallpaper.id -> asignarWallpaper()
        }
    }

    fun abrirActivity() {


    }

    fun enviarDatos() {


    }

    fun devolverDatos() {


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == DEVUELVE_DATOS) {
            if (resultCode == Activity.RESULT_OK) {


            } else {
                Toast.makeText(this, "Se cancelo la respuesta", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun abrirMarcado() {


    }

    fun llamar() {
        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CALL_PHONE), PERMISO_LLAMADA)
        } else {


        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISO_LLAMADA -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                llamar()
            } else {
                Toast.makeText(this, "PERMISO DENEGADO", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun abrirGoogleMaps() {


    }

    fun abrirStreetView() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("google.streetview:cbll=-16.508355,-68.126270")
        startActivity(intent)
    }

    fun abrirPaginaWeb() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.com")
        startActivity(intent)
    }

    fun abrirBuscador() {
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.putExtra(SearchManager.QUERY, "Android")
        startActivity(intent)
    }

    fun compartirTexto() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Descarga esta aplicacion de Google Play: https://play.google.com/id=android.com.tekhne")
        startActivity(intent)
    }

    fun enviarEmail() {
        val TO = arrayOf("lizarraga.gux@gmail.com, gustavo@gmail.com")
        val CC = arrayOf("android@gmail.com")
        val asunto = "Correo importante"
        val contenido = "Este correo electronico es de prueba"

        val intent = Intent(Intent.ACTION_SENDTO)
        intent.type = "text/plain"
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, TO)
        intent.putExtra(Intent.EXTRA_CC, CC)
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto)
        intent.putExtra(Intent.EXTRA_TEXT, contenido)

        startActivity(Intent.createChooser(intent, "Enviar correo (demo)"))
    }

    fun abrirApp() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.setClassName("com.facebook.katana",
                "com.facebook.katana.LoginActivity")
        startActivity(intent)
    }

    fun asignarWallpaper() {
        val intent = Intent(Intent.ACTION_SET_WALLPAPER)
        startActivity(Intent.createChooser(intent, "Cambiar fondo de pantalla"))
    }

}
