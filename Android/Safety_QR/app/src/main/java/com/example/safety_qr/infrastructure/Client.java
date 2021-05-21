package com.example.safety_qr.infrastructure;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safety_qr.activity.ScanResult_Activity;

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

    //private String ip = "192.168.0.6";
    private String ip = "172.20.10.3";
    private int port = 8080;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("실행");
        Intent urlIntent = getIntent();
        String url = urlIntent.getStringExtra("url");
        //소켓 실
        connect(url);
    }

    public void ScanResult(String url) {
        Intent intent = new Intent(this, ScanResult_Activity.class);
        intent.putExtra("url", url);
        intent.putExtra("result", result);
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
                        //통신 성공
                        result = (int)dis.read();
                        System.out.println(result);
                        Log.w("서버에서 받아온 값","" + result);
                        //ScanResult로 값 넘겨줌
                        ScanResult(url);
                    } catch (IOException e){
                        e.printStackTrace();
                    }

            }

        };

        checkUpdate.start();
        finish();


    }


}
