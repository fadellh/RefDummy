package com.example.feature_home

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_home.R
import com.example.feature_home.databinding.MainActivityBinding
import com.example.feature_home.ui_auth.AutActivity
import com.example.feature_home.ui_home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imgHome = findViewById<ImageView>(R.id.ivHome)

        imgHome.setOnClickListener {
            Intent(this,HomeActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.ivAuth.setOnClickListener {
            Intent(this, AutActivity::class.java).also{
                startActivity(it)
            }
        }

    }

}