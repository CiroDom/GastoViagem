package com.cdom.gastogasolinaviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cdom.gastogasolinaviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(button: View) {
        if(button.id == R.id.button_calcular){
            calcular()
        }
    }

    private fun validado(): Boolean{
        return !(binding.editTextDistancia.text.toString() != ""
                || binding.editTextPreco.text.toString() != ""
                || binding.editTextConsumoCarro.text.toString() != ""
                || binding.editTextConsumoCarro.text.toString().toFloat() == 0f)
    }

    private fun calcular() {
            if (validado()) {
                val distancia = binding.editTextDistancia.text.toString().toFloat()
                val preco = binding.editTextPreco.text.toString().toFloat()
                val consumoCarro = binding.editTextConsumoCarro.text.toString().toFloat()

                val valorTotal = (distancia * preco) / consumoCarro
                binding.textViewGastoValor.text = "R$ ${"%.2f".format(valorTotal)}"
            } else {
                Toast.makeText(this, "Insira valores válidos", Toast.LENGTH_SHORT).show()
            }
    }
}