package com.example.safety_qr.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safety_qr.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Detail_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent detailIntent = getIntent();
        // **** 악성 : malicious // 백신 수 : total
        final int malicious = detailIntent.getIntExtra("malicious", 1);
        final int total = detailIntent.getIntExtra("total", 1);
        final String VTUrl = detailIntent.getStringExtra("VTUrl");
        final String url = detailIntent.getStringExtra("url");


        //원형차트
        PieChart pieChart = findViewById(R.id.picChart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setHoleColor(0xff17375e);
        pieChart.setCenterText(malicious+" / "+total);
        pieChart.setCenterTextSize(27);
        pieChart.setCenterTextColor(0xffe0e0e0);
        pieChart.setTransparentCircleRadius(57f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();
        yValues.add(new PieEntry(malicious, "악성 검출"));
        yValues.add(new PieEntry(total - malicious, "악성 미검출"));

        Description description = new Description();
        description.setText("악성 검출도");
        description.setTextColor(0xffe0e0e0);
        description.setTextSize(15);
        description.setPosition(1000, 1050);
        pieChart.setDescription(description);

        pieChart.animateY(1000, Easing.EaseInOutCubic);
        PieDataSet dataSet = new PieDataSet(yValues,"");
        dataSet.setValueTextColor(0xffe0e0e0);
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColor(0xffe84c3d);
        dataSet.addColor(0xff5E7E9B);
        Legend l = pieChart.getLegend();
        l.setEnabled(false);


        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);
        pieChart.setData(data);

        Button ok_button = findViewById(R.id.ok_button);
        Button go_button = findViewById(R.id.go_button);


        //접속하기
        ok_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(!url.contains("http")){
                    String http = "http://";
                    http = http.concat(url);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(http));
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }

            }
        });

        //바이러스토탈가서 분석하기
        go_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //바이러스토탈로가는 링크 연결해야함
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(VTUrl));
                startActivity(intent);
            }
        });

    }

}
