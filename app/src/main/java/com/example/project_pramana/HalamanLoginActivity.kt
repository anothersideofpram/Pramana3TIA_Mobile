package com.example.project_pramana

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_pramana.databinding.ActivityHalamanLoginBinding

class HalamanLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHalamanLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHalamanLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnLogin.setOnClickListener {
            val user = binding.edtUsername.text
            val pass = binding.edtPassword.text

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            intent.putExtra("username", user)
            intent.putExtra("password", pass)
            startActivity(intent)

            Log.d("Output", "Username $user Password $pass")
            Toast.makeText(this, "Username: $user Password: $pass", Toast.LENGTH_LONG).show()
        }
    }
}