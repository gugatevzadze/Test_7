package com.example.test_7.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_7.R
import com.example.test_7.R.drawable
import com.example.test_7.databinding.ActivityMainBinding
import com.example.test_7.databinding.NavHeaderMainBinding
import com.example.test_7.presentation.model.NavigationItemModel
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDrawerLayout()
        setupRecyclerView()
    }
    private fun setupDrawerLayout() {
        drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun setupRecyclerView() {
        val adapter = DrawerAdapter(
            onItemClick = { item ->
                when (item.id) {
                    1 -> navigateTo(R.id.dashboardFragment)
                    2 -> navigateTo(R.id.inboxFragment)
                    3 -> navigateTo(R.id.notificationFragment)
                    4 -> navigateTo(R.id.calendarFragment)
                    5 -> navigateTo(R.id.statisticsFragment)
                    6 -> navigateTo(R.id.settingsFragment)
                }
                drawerLayout.closeDrawer(GravityCompat.START)
            }
        )

        val headerBinding = NavHeaderMainBinding.bind(binding.navView.getHeaderView(0))
        val recyclerView = headerBinding.recyclerViewForList

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.submitList(getNavigationItems())
    }
    private fun navigateTo(id: Int) {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(id)
    }

    private fun getNavigationItems() = listOf(
        NavigationItemModel(1,"Dashboard", drawable.ic_dashboard, 15),
        NavigationItemModel(2,"Inbox", drawable.ic_inbox, 20),
        NavigationItemModel(3,"Notifications", drawable.ic_notif, null),
        NavigationItemModel(4,"Calendar", drawable.ic_calendar, null),
        NavigationItemModel(5,"Statistics", drawable.ic_statistics, null),
        NavigationItemModel(6,"Settings", drawable.ic_settings, null)
    )
}