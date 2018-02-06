package com.example.fran.intentservice

import android.os.SystemClock
import android.content.Intent
import android.app.IntentService

class IntentServiceOperacion : IntentService("IntentServiceOperacion") {

    override fun onHandleIntent(intent: Intent?) {
        val n = intent!!.extras!!.getDouble("numero")
        SystemClock.sleep(5000)
        //MainActivity.salida.append((n * n).toString() + "\n")

        val i = Intent()
        i.action = MainActivity.ReceptorOperacion().ACTION_RESP
        i.addCategory(Intent.CATEGORY_DEFAULT)
        i.putExtra("resultado", n * n)
        sendBroadcast(i)
    }
}
