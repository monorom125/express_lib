package com.example.expresslib

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.expresslib.databinding.ActivityExpMainBinding

class ExpMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExpMainBinding
    private val viewModel : ExpMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.ButtonCount.setOnClickListener {
            viewModel.countClick()
        }

        viewModel.count.observe(this) {
            binding.textViewCount.text = it.toString()
        }
    }
}