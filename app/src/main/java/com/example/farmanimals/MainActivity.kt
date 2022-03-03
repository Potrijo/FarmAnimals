package com.example.farmanimals

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val datos = arrayOf("oca", "porc", "cavall", "gallina", "gos", "cabra", "vaca",
            "bou", "gat", "ovella", "ànec", "ratolí", "ruc")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adaptador = ArrayAdapter(this,
            R.layout.element_de_lista,
            datos)

        val mp:MediaPlayer = MediaPlayer.create(applicationContext, R.raw.audio)

        miLista.adapter = adaptador

        miLista.onItemClickListener =
            object : AdapterView.OnItemClickListener{
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        applicationContext,
                        "Escogido: ${miLista.getItemAtPosition(position)}", // other option: ${datos[postion]}
                        Toast.LENGTH_LONG
                    ).show()
                    mp.start()
                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_Imatge -> Toast.makeText(this, "Mostra Imatges", Toast.LENGTH_SHORT).show()
            R.id.action_Llista -> Toast.makeText(this, "Mostra Llistes", Toast.LENGTH_SHORT).show()

        }
        return super.onOptionsItemSelected(item)
    }
}