package com.example.bottomnavview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val dashboardFragment = DashboardFragment()
    private val notificationsFragment = NotificationsFragment()

    private val fragmentManager = supportFragmentManager
    private var activeFragment: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        fragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, notificationsFragment, "3")
            hide(notificationsFragment)
            add(R.id.fragment_container, dashboardFragment, "2")
            hide(dashboardFragment)
            add(R.id.fragment_container, homeFragment, "1")
        }.commit()

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    fragmentManager
                        .beginTransaction()
                        .hide(activeFragment)
                        .show(homeFragment)
                        .commit()
                    activeFragment = homeFragment
                    true
                }
                R.id.nav_dashboard -> {
                    fragmentManager
                        .beginTransaction()
                        .hide(activeFragment)
                        .show(dashboardFragment)
                        .commit()
                    activeFragment = dashboardFragment
                    true
                }
                R.id.nav_notifications -> {
                    fragmentManager
                        .beginTransaction()
                        .hide(activeFragment)
                        .show(notificationsFragment)
                        .commit()
                    activeFragment = notificationsFragment
                    true
                }
                else -> false
            }
        }
    }
}