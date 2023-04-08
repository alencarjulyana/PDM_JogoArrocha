package com.example.jogodoarrocha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.jogodoarrocha.jogo.Arrocha

class MainActivity : AppCompatActivity() {

    private lateinit var tvMenor: TextView
    private lateinit var tvMaior: TextView
    private lateinit var tvFeedback: TextView
    private lateinit var tvStatus: TextView
    private lateinit var etChute: EditText
    private lateinit var btnChutar: Button
    private lateinit var arrocha: Arrocha
    private lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.tvMenor = findViewById(R.id.tvMenor)
        this.tvMaior = findViewById(R.id.tvMaior)
        this.tvFeedback = findViewById(R.id.tvFeedback)
        this.tvStatus = findViewById(R.id.tvStatus)
        this.etChute = findViewById(R.id.etChute)
        this.btnChutar = findViewById(R.id.btnChutar)
        this.btnReset = findViewById(R.id.btnReset)

        this.arrocha = Arrocha(1,100)
        this.tvMenor.text = this.arrocha.menor.toString()
        this.tvMaior.text = this.arrocha.maior.toString()
        this.tvFeedback.text = ""
        this.tvStatus.text = this.arrocha.status.toString()
        this.atualiza()

        this.btnReset.setOnClickListener({
            this.arrocha = Arrocha(1,100)
            atualiza()
            Toast.makeText(this, "Novo Jogo!", Toast.LENGTH_SHORT).show()
             this.tvFeedback.text = ""
        })

        this.btnChutar.setOnClickListener(ClickBotao())
    }

    fun chutar(){
        var valor = this.etChute.text.toString().toInt()
        var resposta = this.arrocha.jogar(valor)
        if (resposta > 0){
            Toast.makeText(this, "Chutou alto!", Toast.LENGTH_SHORT).show()
        }else if (resposta < 0){

            Toast.makeText(this, "Chutou baixo!", Toast.LENGTH_SHORT).show()
        }else{

        }
        atualiza()
    }

    fun atualiza(){
        this.tvMenor.text = this.arrocha.menor.toString()
        this.tvMaior.text = this.arrocha.maior.toString()
        this.tvStatus.text = this.arrocha.status.toString()
        this.etChute.text.clear()
    }

    inner class ClickBotao: OnClickListener{
        override fun onClick(v: View?) {
            var valor = this@MainActivity.etChute.text.toString().toInt()
            var resposta = this@MainActivity.arrocha.jogar(valor)
            if (resposta > 0){

                Toast.makeText(this@MainActivity, "Chutou alto!", Toast.LENGTH_SHORT).show()
            }else if (resposta < 0){

                Toast.makeText(this@MainActivity, "Chutou baixo!", Toast.LENGTH_SHORT).show()
            }else{

            }
            atualiza()
        }

    }
}