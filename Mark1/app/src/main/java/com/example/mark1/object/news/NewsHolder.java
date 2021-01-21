package com.example.mark1.object.news;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mark1.R;

public class NewsHolder extends RecyclerView.ViewHolder {

    ImageView ivNews;
    TextView tvTitle, tvDescription;
    CardView newsCardView;

    public NewsHolder(@NonNull View itemView) {
        super(itemView);

        this.newsCardView = itemView.findViewById(R.id.news_cardView);
        this.ivNews = itemView.findViewById(R.id.iv_news);
        this.tvTitle = itemView.findViewById(R.id.tv_news_title);
        this.tvDescription = itemView.findViewById(R.id.tv_news_description);
        tvDescription.setSelected(true);
    }
}
