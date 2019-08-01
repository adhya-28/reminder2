package com.example.remainder;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class AlarmReceiver extends BroadcastReceiver {
String no,msg;
    public static final String mob = "mobKey";
    public static final String msge = "msgeKey";
    public static final String PREFS_NAME = "MyPrefs";
    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Toast.makeText(arg0, "Alarm received!", Toast.LENGTH_LONG).show();
        SharedPreferences settings = arg0.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

       String no=settings.getString(mob, "");
       String msg=settings.getString(msge, "");
     //   String no=mobileno.getText().toString();
       // String msg=message.getText().toString();
        Intent intent=new Intent(arg0,MainActivity.class);
        PendingIntent pi= PendingIntent.getActivity(arg0, 0, intent,0);
        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage(no, null, msg, pi,null);

        Toast.makeText(arg0, "Message Sent successfully!",
                Toast.LENGTH_LONG).show();
    }

}