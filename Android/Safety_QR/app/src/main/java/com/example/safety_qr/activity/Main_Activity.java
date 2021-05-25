package com.example.safety_qr.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;

import com.example.safety_qr.R;
import com.example.safety_qr.infrastructure.ScanQR;
import com.example.safety_qr.infrastructure.Client;


public class Main_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goScan(View view) {
        Intent intent = new Intent(this, ScanQR.class);
        startActivity(intent);
    }

    public void goSearch(View view) {
        Intent intent = new Intent(this, SearchQR_Activity.class);
        startActivity(intent);
    }

    // 테스트용
    public void Client(View view) {
        Intent intent = new Intent(this, Client.class);
        startActivity(intent);
    }

    public void goHistory(View view) {
        Intent intent = new Intent(this, History_Activity.class);
        startActivity(intent);
    }

    public void goInfo(View view) {
        Intent intent = new Intent(this, Info_Activity.class);
        startActivity(intent);
    }

}
