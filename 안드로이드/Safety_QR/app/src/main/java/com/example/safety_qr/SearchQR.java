package com.example.safety_qr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
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

    //url인지 판별
    public static String isURL(String str){
        StringBuffer answer = new StringBuffer();
        String regex ="[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        if(m.find()){
            answer.append(m.group(0));
        }

        return answer.toString();
    }



    public void Search_URL(View view){
        //문자열로 받아오기
        EditText get_url = findViewById(R.id.url_input);
        String URL = get_url.getText().toString();

        //입력값이 URL인지 판별
        URL = isURL(URL);



        //정확한 값이 나오는지 테스트
        TextView set_url = findViewById(R.id.url_test);

        //URL이 아니라면
        if(URL.isEmpty()) {
            set_url.setText(get_url.getText()+"는 잘못된 URL입니다.");
        }
        else{  //URL이라면
            set_url.setText(URL);

            //Client.class 인텐트 넘겨줌
            Intent url = new Intent(this, SearchQR.class);
            url.putExtra("url", URL);
        }
    }


}
