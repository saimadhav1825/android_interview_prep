package com.example.prepareinterview.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneMoodReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (p1?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            Toast.makeText(p0, "Airplane Mode Enabled", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(p0, "Airplane Mode Disabled", Toast.LENGTH_LONG).show()
        }
    }
}