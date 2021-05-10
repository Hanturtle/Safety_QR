package com.example.safety_qr;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends AppCompatActivity {

    private String html = "";
    private Handler mHandler;
    private String STOP_MSG = "stop";
    private Socket socket;

    private DataOutputStream dos;
    private DataInputStream dis;

    private String ip = "127.0.0.1";
    private int port = 8080;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("실행");

        int SDK_INT = android.os.Build.VERSION.SDK_INT;

        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //Intent urlIntent = getIntent();
        //String url = urlIntent.getStringExtra("url");
        //System.out.println("url :");
        //System.out.println(url);
        String url = "http://www.naver.com";
        //connect(url);
        ScanResult();


    }
    //임시용
    public void ScanResult() {
        Intent intent = new Intent(this, ScanResult.class);
        intent.putExtra("url", "http://www.naver.com");
        startActivity(intent);
    }


    void connect(final String url){
        mHandler = new Handler();
        Log.w("connect", "연결 하는중");
        // 받아오기
        Thread checkUpdate = new Thread() {
            public void run(){
                try {
                    socket = new Socket(ip, port);
                    Log.w("서버 접속됨", "서버 접속됨");
                } catch (IOException e1){
                    Log.w("서버 접속못함", "서버 접속못함");
                    e1.printStackTrace();
                }
                Log.w("edit 넘어가야 할 값 : ", "안드로이드에서 서버로 연결요청");

                try {
                    dos = new DataOutputStream(socket.getOutputStream());
                    dis = new DataInputStream(socket.getInputStream());
                    dos.writeUTF(url);
                    // url 넘겨줌
                } catch (IOException e){
                    e.printStackTrace();
                    Log.w("버퍼", "버퍼생성 잘못됨");
                }
                Log.w("버퍼", "버퍼생성 잘됨");


                    try {
                        int num, num2;
                        num = (int)dis.read();
                        num2 = (int)dis.read();
                        System.out.println(num);
                        Log.w("서버에서 받아온 값","" + num);
                        Log.w("서버에서 받아온 값","" + num2);

                    } catch (IOException e){
                        e.printStackTrace();
                    }


            }
        };
        checkUpdate.start();

    }



}
