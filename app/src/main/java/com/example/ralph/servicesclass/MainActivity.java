package com.example.ralph.servicesclass;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    MyService myService;
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.CustomBinder binder = (MyService.CustomBinder) service;
            myService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this,MyService.class);

    }

    public void start(View view){

        bindService(intent, connection,BIND_AUTO_CREATE);
    }

    public void stop(View view){
        unbindService(connection);
    }

    public void play(View view){
        if(myService != null){
            myService.play();
        }
    }

    public void pause(View view){
        if(myService != null){
            myService.pause();
        }
    }


}
