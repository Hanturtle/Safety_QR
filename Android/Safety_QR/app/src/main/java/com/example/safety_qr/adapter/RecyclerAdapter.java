package com.example.safety_qr.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safety_qr.R;
import com.example.safety_qr.domain.History;
import com.example.safety_qr.infrastructure.SQLiteHelper;

import java.util.List;
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>{
    public List<History> historyList;
    SQLiteHelper dbHelper;

    class ItemViewHolder extends RecyclerView.ViewHolder{

        private final TextView url;
        private TextView result;

        public ItemViewHolder(@NonNull View itemView){
            super(itemView);

            url = itemView.findViewById(R.id.item_url);
            result = itemView.findViewById(R.id.item_result);

            // ****삭제기능 들어가야함****
        }



    }

    public RecyclerAdapter(List<History> historyList){
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_history, viewGroup, false);

        return new ItemViewHolder(view);
    }

    @Override
    public int getItemCount() {
        System.out.println("DB 개수" + historyList.size());
        return historyList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        History history = historyList.get(i);


        itemViewHolder.url.setText(history.getUrl());
        itemViewHolder.result.setText(history.getResult());



    }
    void addItem(History history) {
        historyList.add(history);
    }

    void removeItem(int position){
        historyList.remove(position);

    }


}