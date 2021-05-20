package com.example.safety_qr.infrastructure;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safety_qr.R;
import com.example.safety_qr.infrastructure.Client;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanQR extends AppCompatActivity {
    int ScaneResultActivityId = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);
        new IntentIntegrator(this).initiateScan();
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setOrientationLocked(false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();

                // todo
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                //url 정보 넘겨주기(url 값 == result.getContents() ), 악성판별% 받아오기

                /*int percent = 0;
                //판별 결과 알려주는 화면 전환
                Intent intent = new Intent(getApplicationContext(), ScanResult.class);
                intent.putExtra("percent", percent);  //percent의 값을 부가 데이터로 넣기
                startActivityForResult(intent, ScaneResultActivityId);    // 응답보내
                finish(); //현재 액티비티 없애*/

                // todo
                //Client.class 인텐트 넘겨줌
                Intent url = new Intent(this, Client.class);
                url.putExtra("url", result.getContents());
                startActivity(url);

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
        finish();
        /*int request = requestCode & 0xffff;
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("Fragment1");
        fragment.onActivityResult(request, resultCode, data);*/
    }
}