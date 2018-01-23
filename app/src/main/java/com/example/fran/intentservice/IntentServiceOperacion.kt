package com.example.fran.intentservice

import android.os.SystemClock
import android.content.Intent
import android.app.IntentService

/**
 * Created by Fran on 23/01/2018.
 */
class IntentServiceOperacion : IntentService("IntentServiceOperacion") {

    override fun onHandleIntent(intent: Intent?) {
        val n = intent!!.extras!!.getDouble("numero")
        SystemClock.sleep(5000)
        MainActivity.salida.append((n * n).toString() + "\n")
    }
}
