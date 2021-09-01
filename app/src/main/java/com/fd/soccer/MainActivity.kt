package com.fd.soccer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.fd.core.utils.Constant
import com.fd.soccer.databinding.ActivityMainBinding
import com.fd.soccer.ui.home.HomeFragment
import com.fd.soccer.ui.setting.SettingDialog
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var settingDialog: SettingDialog
    private var idLeague = Constant.DEFAULT_LEAGUE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        supportActionBar?.title = getString(R.string.app_name)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment(idLeague))
        }

        settingDialog = SettingDialog(this)
        settingDialog.setListener(object : SettingDialog.Listener {
            override fun onItemClick(selectedIdLeague : String) {
                idLeague = selectedIdLeague
                replaceFragment(HomeFragment(idLeague))
            }
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                replaceFragment(HomeFragment(idLeague))
            }
            R.id.nav_favorite -> {
                val uri = Uri.parse("soccerapp://favourite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
            R.id.nav_setting -> {
                settingDialog.show()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment?) {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }
    }
}