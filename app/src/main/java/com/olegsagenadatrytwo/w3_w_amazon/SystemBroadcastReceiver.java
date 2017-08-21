package com.olegsagenadatrytwo.w3_w_amazon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SystemBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()) {

            case "android.intent.action.AIRPLANE_MODE":
                Toast.makeText(context, "ACTION_AIRPLANE_MODE_CHANGED", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "ACTION_POWER_CONNECTED", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_NEW_OUTGOING_CALL:
                Toast.makeText(context, "ACTION_NEW_OUTGOING_CALL", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_HEADSET_PLUG:
                Toast.makeText(context, "ACTION_HEADSET_PLUG", Toast.LENGTH_SHORT).show();

                break;
            case Intent.ACTION_SCREEN_OFF:
                Toast.makeText(context, "ACTION_SCREEN_OFF", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
