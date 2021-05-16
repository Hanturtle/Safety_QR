package com.example.safety_qr;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchQR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();


    }

    public void Search_URL(View view){
        EditText get_url = findViewById(R.id.url_input);
        //문자열로 받아오기
        get_url.getText().toString();

        //입력값 제대로 불러와지는지 테스트
        TextView set_url = findViewById(R.id.url_test);
        set_url.setText(get_url.getText());
    }


}
