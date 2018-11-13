package com.miramicodigo.placesautocomplete

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.places.Places
import com.google.android.gms.location.places.ui.PlaceAutocomplete
import com.google.android.gms.location.places.Place
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener, OnMapReadyCallback {

    val PLACE_AUTOCOMPLETE_REQUEST_CODE = 1
    lateinit var mGoogleApiClient: GoogleApiClient
    lateinit var latLong: LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Demo Google Places"

        panelData.visibility = View.INVISIBLE
        panelTemp.visibility = View.VISIBLE





    }

    private fun abrirBusquedaPlaces() {
        try {



        } catch (e: GooglePlayServicesRepairableException) {
            Toast.makeText(this, "Catch...", Toast.LENGTH_SHORT).show()
        } catch (e: GooglePlayServicesNotAvailableException) {
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            when {
                resultCode == Activity.RESULT_OK -> {



                }
                resultCode == PlaceAutocomplete.RESULT_ERROR -> {
                    val status = PlaceAutocomplete.getStatus(this, data)
                }
                requestCode == Activity.RESULT_CANCELED -> {
                    val status = PlaceAutocomplete.getStatus(this, data)
                }
            }
        }
    }

    fun mostrarInfo(place: Place) {



    }

    override fun onMapReady(googleMap: GoogleMap) {





    }

    override fun onConnectionFailed(p0: ConnectionResult) {

    }

    override fun onConnected(p0: Bundle?) {

    }

    override fun onConnectionSuspended(p0: Int) {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menuBusqueda -> {
                abrirBusquedaPlaces()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        mGoogleApiClient.connect()
    }

    override fun onStop() {
        mGoogleApiClient.disconnect()
        super.onStop()
    }
}
