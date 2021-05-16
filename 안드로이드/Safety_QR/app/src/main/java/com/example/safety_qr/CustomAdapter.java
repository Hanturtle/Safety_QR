package com.example.sqliteexample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>
{

    private ArrayList<MemoItem> mMemoItems;
    private Context mContext;
    private DBHelper mDBHelper;

    private FloatingActionButton mBtn_delete;

    public CustomAdapter(ArrayList<MemoItem> mMemoItems, Context mContext) {
        this.mMemoItems = mMemoItems;
        this.mContext = mContext;
        mDBHelper = new DBHelper(mContext);
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memo, parent, false);
        return new ViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        holder.tv_date.setText(mMemoItems.get(position).getSearchDate());
        holder.tv_url.setText(mMemoItems.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return mMemoItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_date;
        private TextView tv_url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //tv_date = itemView.findViewById(R.id.tv_date);
            tv_url = itemView.findViewById(R.id.tv_url);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int curPos = getAdapterPosition();
                    MemoItem memoItem = mMemoItems.get(curPos);

                    String[] strChoiceItems = {"삭제하기"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("원하는 작업을 선택해주세요");
                    builder.setItems(strChoiceItems, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (which == 0) {
                                int id = memoItem.getId();
                                mDBHelper.DeleteMemo(id);
                                mMemoItems.remove(curPos);
                                notifyItemRemoved(curPos);
                                Toast.makeText(mContext, "목록이 제거되었습니다", Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                    builder.show();
                }
            });

        }


    }
    // 액티비티에서 호출되는 함수, 현재 어댑터에 새로운 메모를 전달받아 추가
    public void addItem(MemoItem _item){
        mMemoItems.add(0, _item);
        notifyItemInserted(0);
    }
}
