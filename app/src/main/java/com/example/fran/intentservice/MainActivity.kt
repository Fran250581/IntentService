package com.example.fran.intentservice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.EditText
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter

class MainActivity : AppCompatActivity() {

    private var entrada: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        entrada = findViewById<View>(R.id.entrada) as EditText?
        salida = findViewById<View>(R.id.salida) as TextView

        val filtro = IntentFilter(ReceptorOperacion().ACTION_RESP)
        filtro.addCategory(Intent.CATEGORY_DEFAULT)
        registerReceiver(ReceptorOperacion(), filtro)
    }

    fun calcularOperacion(view: View) {
        val n = java.lang.Double.parseDouble(entrada!!.text.toString())
        salida.append(n.toString() + "^2 = ")
        //val i = Intent(this, ServicioOperacion::class.java)
        val i = Intent(this, IntentServiceOperacion::class.java)
        i.putExtra("numero", n)
        startService(i)
    }

    companion object {
        lateinit var salida: TextView
    }

    class ReceptorOperacion : BroadcastReceiver() {

        var ACTION_RESP: String = "org.example.intentservice.intent.action.RESPUESTA_OPERACION"

        override fun onReceive(context: Context?, intent: Intent?) {
            val res = intent!!.getDoubleExtra("resultado", 0.0)
            salida.append(" " + res)
        }
    }

}


