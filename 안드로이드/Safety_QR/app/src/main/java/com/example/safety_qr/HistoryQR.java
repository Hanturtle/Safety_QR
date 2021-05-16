package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRv_memo;
    private FloatingActionButton mBtn_write;
    private FloatingActionButton mBtn_delete;
    private ArrayList<MemoItem> mMemoItems;
    private DBHelper mDBHelper;
    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInit();
    }

    private void setInit() {
        mDBHelper = new DBHelper(this);
        mRv_memo = findViewById(R.id.rv_memo);
        mBtn_write = findViewById(R.id.btn_write);
        mMemoItems = new ArrayList<>();

        // load recent DB
        loadRecentDB();


        mBtn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //팝업
                Dialog dialog = new Dialog(MainActivity.this, android.R.style.Theme_Material_Light_Dialog);
                dialog.setContentView(R.layout.dialog_edit);
                EditText vt_date = dialog.findViewById(R.id.vt_date);
                EditText vt_url = dialog.findViewById(R.id.vt_url);
                Button btn_b = dialog.findViewById(R.id.btn_b);
                btn_b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // insert DB
                        mDBHelper.InsertMemo(vt_date.getText().toString(), vt_url.getText().toString());

                        // insert UI
                        MemoItem item = new MemoItem();
                        item.setSearchDate(vt_date.getText().toString());
                        item.setUrl(vt_url.getText().toString());

                        mAdapter.addItem(item);
                        mRv_memo.smoothScrollToPosition(0);
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "목록에 추가되었습니다." ,Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });

        /*
        mBtn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int curPos = getAdapterPosition();
                MemoItem memoItem = mMemoItems.get(curPos);


                int id = memoItem.getId();
                mDBHelper.DeleteMemo(id);
                mMemoItems.remove(curPos);
                notifyItemRemoved(curPos);
                Toast.makeText(MainActivity.this, "목록이 제거되었습니다", Toast.LENGTH_SHORT).show();
            }
        });


         */
    }

    private void loadRecentDB(){
        // 저장되어있던 DB 가져옴
        mMemoItems = mDBHelper.getMemoList();
        if(mAdapter == null){
            mAdapter = new CustomAdapter(mMemoItems, this);
            mRv_memo.setHasFixedSize(true);
            mRv_memo.setAdapter(mAdapter);
        }
    }
}