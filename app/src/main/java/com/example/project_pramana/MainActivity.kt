package com.example.project_pramana

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_pramana.databinding.ActivityMainBinding
import com.example.project_pramana.pertemuan5.LimaActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")
        binding.txtUsername.text=user
        binding.txtPassword.text=pass

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(binding.root,"Halo ini Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Info"){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Kembali ke halaman Activity", Toast.LENGTH_LONG).show()
                }
                .show()
        }
        binding.btnAlert.setOnClickListener { MaterialAlertDialogBuilder(this)
            .setTitle("Hapus data")
            .setMessage("Data tidak bisa di kembalikan.")
            .setNegativeButton("Batal", null)
            .setPositiveButton("Hapus"){dialog, _ ->
                dialog.dismiss()}
            .setCancelable(false)
            .show()
        }
        binding.btnToLima.setOnClickListener {
            val intent = Intent(this@MainActivity, LimaActivity::class.java)
            startActivity(intent)

        }
    }

}