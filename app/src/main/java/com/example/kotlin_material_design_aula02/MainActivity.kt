package com.example.kotlin_material_design_aula02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext

import com.example.kotlin_material_design_aula02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf<String>("Opção 1", "Opção 2", "Opção 3", "Opção 4")
        val adapter =ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, items)
        (binding.TextInputMenu.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        binding.btnMenu.setOnClickListener {abrirMenu(binding.btnMenu)}
        binding.btnConfirmar.setOnClickListener({itemSelecionado()})
    }

    private fun itemSelecionado(){
        when (binding.txtEscolha.text.toString()){
            "Opção 1" -> {
                Toast.makeText(this@MainActivity, "Opção 1", Toast.LENGTH_SHORT).show()
            }
            "Opção 2" -> {
                Toast.makeText(this@MainActivity, "Opção 2", Toast.LENGTH_SHORT).show()
            }
            "Opção 3" -> {
                Toast.makeText(this@MainActivity, "Opção 3", Toast.LENGTH_SHORT).show()
            }
            "Opção 4" -> {
                Toast.makeText(this@MainActivity, "Opção 4", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun abrirMenu(view: View) {
        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.exemplo_menu)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId) {
                R.id.op1 -> {
                    Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
                }
                R.id.op2 -> {
                    Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
                }
                R.id.op3 -> {
                    Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
                }
            }

            true
        })

        popup.show()
    }
}