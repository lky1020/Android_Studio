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

public class WaterFallAdapter extends RecyclerView.Adapter <WaterFallAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public WaterFallAdapter(Context context, OnItemClickListener listener){

        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public WaterFallAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_waterfall_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WaterFallAdapter.LinearViewHolder holder, final int position) {

        if(position % 2 != 0){
            holder.imageView.setImageResource(R.drawable.img_1);
        }
        else{
            holder.imageView.setImageResource(R.drawable.img_2);
        }


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

        private ImageView imageView;

        public LinearViewHolder(View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
