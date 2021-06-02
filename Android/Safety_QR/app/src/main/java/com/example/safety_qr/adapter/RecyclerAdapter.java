package com.example.safety_qr.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safety_qr.R;
import com.example.safety_qr.domain.History;
import com.example.safety_qr.infrastructure.SQLiteHelper;

import java.util.List;
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>{
    public List<History> historyList;
    SQLiteHelper dbHelper;
    Context mContext;
    //Button item_button = (Button)findViewById(R.id.item_button);
    class ItemViewHolder extends RecyclerView.ViewHolder{

        private final TextView url;
        private ImageView result;
        // Button
        private Button item_button;

        public ItemViewHolder(@NonNull View itemView){
            super(itemView);

            url = itemView.findViewById(R.id.item_url);
            result = itemView.findViewById(R.id.item_result);
            // Button
            item_button = itemView.findViewById(R.id.item_button);

            // DB 삭제
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    final int curPos = getAdapterPosition();
                    final History historyItem = historyList.get(curPos);

                    String[] ChoiceItems = {"삭제", "취소"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("삭제하시겠습니까?");
                    builder.setItems(ChoiceItems, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(which == 0){
                                int id = historyItem.getId();
                                dbHelper.deleteHistory(id);
                                historyList.remove(curPos);
                                notifyItemRemoved(curPos);
                                Toast.makeText(mContext, "목록이 삭제 되었습니다", Toast.LENGTH_LONG).show();
                            }
                            else if(which == 1){
                            }
                        }
                    });
                    builder.show();
                }
            });
        }



    }

    public RecyclerAdapter(List<History> historyList, Context mContext){
        this.historyList = historyList;
        this.mContext = mContext;
        dbHelper = new SQLiteHelper(mContext);
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
        if(Integer.parseInt(history.getResult()) == 0){
            itemViewHolder.result.setImageResource(R.drawable.green_mark);

        }
        else {
            itemViewHolder.result.setImageResource(R.drawable.red_mark);
        }



    }
    void addItem(History history) {
        historyList.add(history);
    }

    void removeItem(int position){
        historyList.remove(position);

    }


}