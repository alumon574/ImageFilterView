package com.example.imagefilterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ContactView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_view)

        val nombre = findViewById<TextView>(R.id.textNombre)
        val bundle = intent.extras
        val name = bundle?.getString("nombre")
    }
}