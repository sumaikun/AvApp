package com.example.jesus.avapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import core.Objects.KeyValueDB;

import com.sinch.android.rtc.Sinch;
import com.sinch.android.rtc.SinchClient;

public class CallActivity extends AppCompatActivity {

    String peer = KeyValueDB.getStringProperty(this,"peer");



    SinchClient sinchClient = Sinch.getSinchClientBuilder()
            .context(this)
            .userId("current-user-id")
            .applicationKey("03e83360-e7bd-4ab7-90fe-1bfa6243fb56")
            .applicationSecret("YmBwPY0LRU6rBRyqG6gkMw==")
            .environmentHost("sandbox.sinch.com")
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        Button Callbutton = (Button) findViewById(R.id.button);
        Callbutton .setOnClickListener(new CallActivity.calling());

    }


    private class calling implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // make a call!
        }
    }
}
