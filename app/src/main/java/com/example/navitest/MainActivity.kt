package com.example.navitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.navigation.NavigationView;

class MainActivity : AppCompatActivity() {
    private var drawerLayout : DrawerLayout ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        var actionBar = supportActionBar
        drawerLayout = findViewById(R.id.drawer_layout)

        actionBar?.setDisplayShowTitleEnabled(false) // 기존 title 지우기
        actionBar?.setDisplayHomeAsUpEnabled(true) // 뒤로가기 버튼 만들기
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_format_align_left_black_24dp)
        nav_view.setNavigationItemSelectedListener { item ->
            item.isChecked = true
            drawerLayout?.closeDrawers()

            var id = item.itemId
            var title = item.title.toString()

            when(id) {
                R.id.account -> Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()
                R.id.setting -> Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()
                R.id.logout -> Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> { // 왼쪽 상단 버튼 눌렀을 때
                drawerLayout?.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}