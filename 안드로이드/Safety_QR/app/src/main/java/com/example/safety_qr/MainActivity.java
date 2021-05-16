package com.example.safety_qr;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }


    public void goScan(View view) {
        Intent intent = new Intent(this, ScanQR.class);
        startActivity(intent);
    }

    public void goSearch(View view) {
        Intent intent = new Intent(this, SearchQR.class);
        startActivity(intent);
    }

    // 테스트용
    public void Client(View view) {
        Intent intent = new Intent(this, Client.class);
        startActivity(intent);
    }


}
