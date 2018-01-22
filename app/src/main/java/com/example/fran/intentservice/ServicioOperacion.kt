package com.example.fran.intentservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock

class ServicioOperacion : Service() {

    override fun onStartCommand(i: Intent, flags: Int, idArranque: Int): Int {
        val n = i.extras!!.getDouble("numero")
        SystemClock.sleep(25000)
        MainActivity.salida.append((n * n).toString() + "\n")
        return Service.START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}
