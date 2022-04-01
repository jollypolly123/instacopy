package com.example.instacopy

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.instacopy.fragments.ComposeFragment
import com.example.instacopy.fragments.FeedFragment
import com.example.instacopy.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {
            item ->
            var fragmentShow: Fragment? = null

            when (item.itemId) {
                R.id.action_home -> {
                    fragmentShow = FeedFragment()
                }
                R.id.action_compose -> {
                    fragmentShow = ComposeFragment()
                }
                R.id.action_profile -> {
                    fragmentShow = ProfileFragment()
                }
            }

            if (fragmentShow != null) {
                fragmentManager.beginTransaction().replace(R.id.container, fragmentShow).commit()
            }

            true
        }

        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home

    }

    companion object {
        const val TAG = "MainActivity"
    }
}