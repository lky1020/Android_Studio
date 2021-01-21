package com.example.lesson_2.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson_2.R;

public class HorizontalAdapter extends RecyclerView.Adapter <HorizontalAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public HorizontalAdapter(Context context, OnItemClickListener listener){

        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public HorizontalAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("Hello !");

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {

        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public LinearViewHolder(View itemView) {

            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
