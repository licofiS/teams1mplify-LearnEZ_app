package com.example.learnez

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnez.databinding.ActivityQuotesViewBinding

class QuotesView : AppCompatActivity() {
    lateinit var binding: ActivityQuotesViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuotesViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Profile Activity mover
        binding.Home.setOnClickListener{
            val intent_Home: Intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent_Home)
        }
    }
}