package com.example.ralph.servicesclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this,MyIntentService.class);

    }

    public void start(View view){

        startService(intent);
    }

    public void stop(View view){
        stopService(intent);
    }


}
