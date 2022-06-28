package com.example.mygmap

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.mygmap.databinding.ActivityMapsBinding
import com.google.android.gms.maps.GoogleMap.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        val bang = LatLng(12.9716, 77.5946)

        if(mMap.isMyLocationEnabled) {
            mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            mMap.addMarker(MarkerOptions().position(bang).title("Bangalore"))

            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            mMap.uiSettings.isZoomControlsEnabled = true

            mMap.mapType = MAP_TYPE_HYBRID
        } else {
            Toast.makeText(this, "Location service not enabled", Toast.LENGTH_LONG).show()
            checkPermission()
        }
    }

    fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) ==
            PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                this,
                ACCESS_COARSE_LOCATION
            ) ==
            PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true
            Toast.makeText(this, "Location enabled", Toast.LENGTH_LONG).show()
            return
        }

        requestPermissions(
            arrayOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }

    companion object {
        const val LOCATION_PERMISSION_REQUEST_CODE = 100
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
                for (i in grantResults) {
                    if (ActivityCompat.checkSelfPermission(
                            this,
                            ACCESS_FINE_LOCATION
                        ) != PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                            this,
                            ACCESS_COARSE_LOCATION
                        ) != PERMISSION_GRANTED
                    ) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return
                    }
                    if (permissions[i] == ACCESS_FINE_LOCATION || permissions[i] == ACCESS_COARSE_LOCATION)
                        mMap.isMyLocationEnabled = true
                }
            }
            else -> {
                Toast.makeText(this, "App requires location permission", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

}