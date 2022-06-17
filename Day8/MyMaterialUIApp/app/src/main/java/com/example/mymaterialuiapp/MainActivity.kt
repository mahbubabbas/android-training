package com.example.mymaterialuiapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.mymaterialuiapp.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.util.HalfSerializer.onNext
import io.reactivex.rxjava3.kotlin.toFlowable
import io.reactivex.rxjava3.kotlin.toObservable


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        val list = listOf<Int>(1, 2, 3, 5, 9) // provider/publisher

        binding.fab.setOnClickListener { view ->

//            list.toObservable()
//                .subscribe (
//                    {
//                        v -> println(v)
//                    },
//                    {
//                        e -> println(e)
//                    },
//                    { println("completed") }
//                )

            val observable = myObservable()
            val observer = myObserver()

            observable.subscribe (observer)


        //            for(i in list) { //consumer
//                println("Value: $i")
//            }

//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAnchorView(R.id.fab)
//                .setAction("Action", null).show()
        }
    }

    fun myObservable() : Observable<Int> {
        return Observable.just(1, 2, 3, 4 ,5)
    }

    fun myObserver() : Observer<Int> {
        return object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                //TODO("Not yet implemented")
            }

            override fun onNext(t: Int) {
                println("Value $t")
            }

            override fun onError(e: Throwable) {
                println("Error")
            }

            override fun onComplete() {
                println("Completed")
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Setting is clicked", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_mymenu -> {
                Toast.makeText(this, "My menu is clicked", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}