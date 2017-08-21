package com.olegsagenadatrytwo.w3_w_amazon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MessageReceivedActivity extends AppCompatActivity {

    private TextView tvNumber;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_received);

        tvNumber = (TextView) findViewById(R.id.tvFrom);
        tvMessage = (TextView) findViewById(R.id.tvMessage);

        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        String message = intent.getStringExtra("message");

        tvNumber.setText(number);
        tvMessage.setText(message);

    }
}
