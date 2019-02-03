package com.example.marioandres.laboratorio4

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.marioandres.laboratorio4.Fragments.FragmentOne
import com.example.marioandres.laboratorio4.Fragments.FragmentThree
import com.example.marioandres.laboratorio4.Fragments.FragmentTwo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    //Esta funcion permite utilizar el fragment managaer y reemplazar
    //en el contenedor principal cualquier de los 3 fragments
    private fun load(fragment: Fragment){
        val fm = supportFragmentManager
        fm.beginTransaction().replace(R.id.fragment_place,fragment).commit()
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Al presionar los items de la lista de navegacipn
        // aparecera un fragment en el main activity
        when (item.itemId) {
            R.id.nav_initiation -> {
                //Menu del fragment de la presentacion
                load(FragmentOne())
            }
            R.id.nav_proyects -> {
                //Menu del fragment de las paginas de github
                load(FragmentTwo())

            }
            R.id.nav_direction -> {
                //Menu del mapa de Google
                load(FragmentThree())
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
