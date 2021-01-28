package com.example.feature_home.ui_home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.feature_home.R
import com.example.feature_home.data.persistance.dao.RefferalDao
import com.example.feature_home.data.repository.RefferalRepository
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.NavigationMenu
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.navigation.Navigation as Navigation1

@AndroidEntryPoint
internal class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.btnNav)

        bottomNav.setupWithNavController(navHostFragment.findNavController())

        navHostFragment.findNavController()
                .addOnDestinationChangedListener{_,destination,_ ->
                    when(destination.id){
                        R.id.refferalListFragment, R.id.summaryFragment, R.id.filterFragment ->
                            bottomNav.visibility = View.VISIBLE
                        else -> bottomNav.visibility = View.GONE
                    }
                }


    }
}