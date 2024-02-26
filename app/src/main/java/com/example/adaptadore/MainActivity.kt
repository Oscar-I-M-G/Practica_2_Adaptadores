package com.example.adaptadore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var etiqueta: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.sLista)
        etiqueta = findViewById(R.id.tvEtiqueta)

/*
        val adaptador = ArrayAdapter.createFromResource(
            this,
            R.array.animales,
            android.R.layout.simple_spinner_item
        )

*/

        val adaptador = ArrayAdapter(
            this,
            R.layout.spinner_cerrado,
            R.id.texto,
            resources.getStringArray(R.array.animales)
        )

        adaptador.setDropDownViewResource(R.layout.spinner_dropdown)
        spinner.adapter = adaptador

       spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccion: TextView? = view?.findViewById(R.id.texto)
                etiqueta.text = seleccion?.text
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

    }
}