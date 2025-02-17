package com.bonak.steady

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import android.util.Log
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : BaseActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setupToolbar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)

        val menuIcon: ImageButton = findViewById(R.id.menu_icon)
        menuIcon.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        val notificationIcon: ImageButton = findViewById(R.id.notification_icon)
        notificationIcon.setOnClickListener {
            showNotificationDialog() //Placeholder for notification behavior
        }

        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.settings -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                }
                R.id.info -> {
                    startActivity(Intent(this, InfoActivity::class.java))
                }
                R.id.faq -> {
                    startActivity(Intent(this, FAQActivity::class.java))
                }
                R.id.help -> {
                    startActivity(Intent(this, HelpActivity::class.java))
                }
                R.id.terms -> {
                    startActivity(Intent(this, TermsActivity::class.java))
                }
                R.id.signOut -> {
                    showSignOutDialog() //Placeholder behavior for sign out item
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)

        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter
        viewPager.offscreenPageLimit = 2

        tabLayout.setBackgroundColor(resources.getColor(R.color.black, theme))

        tabLayout.setTabTextColors(
            resources.getColor(R.color.text_light, theme),
            resources.getColor(R.color.brown, theme)
        )

        tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.light_brown, theme))

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Map"
                1 -> tab.text = "News"
                2 -> tab.text = "Stats"
            }
        }.attach()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun showSignOutDialog() { //Placeholder function for sign out behavior
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sign Out")
        builder.setMessage("Are you sure you want to sign out?")

        builder.setPositiveButton("Yes") { dialog, _ ->
            Toast.makeText(this, "Signing you out...", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun showNotificationDialog() { //Placeholder function for notifications
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Notification")
        builder.setMessage("Notifications are opened")

        builder.setPositiveButton("Close") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

}