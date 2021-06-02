package com.example.safety_qr.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safety_qr.R;
import com.example.safety_qr.adapter.RecyclerAdapter;
import com.example.safety_qr.domain.History;
import com.example.safety_qr.infrastructure.SQLiteHelper;

import java.util.List;

public class History_Activity extends AppCompatActivity {

    SQLiteHelper dbHelper;
    List<History> history;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        dbHelper = new SQLiteHelper(History_Activity.this);
        history = dbHelper.selectALL();


        for(int i = 0; i < history.size(); i++){
            System.out.println("history list : " + history.get(i));
        }

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                History_Activity.this, RecyclerView.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);


        recyclerAdapter = new RecyclerAdapter(history, this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();

    }
}
