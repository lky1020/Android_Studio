package com.example.lesson_2.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson_2.R;

public class LinearAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public LinearAdapter(Context context, OnItemClickListener listener){

        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == 0){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent, false));
        }
        else{
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position) == 0){

            ((LinearViewHolder) holder).textView.setText("Hello World!");

        }else{
            ((LinearViewHolder2) holder).textView.setText("Android Studio!");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public int getItemCount() {

        return 30;
    }

    public class LinearViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public LinearViewHolder(View itemView) {

            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    public class LinearViewHolder2 extends RecyclerView.ViewHolder{

        private TextView textView;
        private ImageView imagevIew;

        public LinearViewHolder2(View itemView) {

            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imagevIew = itemView.findViewById(R.id.iv_title);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
