package com.example.test_7.presentation


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_7.R
import com.example.test_7.databinding.ActivityMainBinding
import com.example.test_7.presentation.model.NavigationItemModel
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        val itemsForRecycler = listOf(
            NavigationItemModel(1,"Dashboard", R.drawable.ic_dashboard),
            NavigationItemModel(2,"Inbox", R.drawable.ic_inbox),
            NavigationItemModel(3,"Notifications", R.drawable.ic_notif),
            NavigationItemModel(4,"Calendar", R.drawable.ic_calendar),
            NavigationItemModel(5,"Statistics", R.drawable.ic_statistics),
            NavigationItemModel(6,"Settings", R.drawable.ic_settings)
        )

        val adapter = DrawerAdapter()

        val recyclerView = binding.navView.getHeaderView(0).findViewById<RecyclerView>(R.id.recyclerViewForList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.submitList(itemsForRecycler)
    }
}