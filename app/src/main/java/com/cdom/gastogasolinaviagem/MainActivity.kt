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

        title = "Gasto de gasolina"

        binding.buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(button: View) {
        if(button.id == binding.buttonCalcular.id){
            calcular()
        }
    }

    private fun validado(): Boolean{
        return !(binding.editDistancia.text.isNullOrBlank()
                || binding.editPreco.text.isNullOrBlank()
                || binding.editConsumo.text.isNullOrBlank()
                || binding.editConsumo.text.toString().toFloat() == 0f)
    }

    private fun calcular() {
        if (validado()) {
            val distancia = binding.editDistancia.text.toString().toFloat()
            val preco = binding.editPreco.text.toString().toFloat()
            val consumoCarro = binding.editConsumo.text.toString().toFloat()

            val valorTotal = (distancia * preco) / consumoCarro
            binding.textViewGastoValor.text = "R$ ${"%.2f".format(valorTotal)}"
        } else {
            Toast.makeText(this, "Insira valores válidos", Toast.LENGTH_SHORT).show()
        }
    }
}