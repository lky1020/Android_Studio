package com.example.mark1.object.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mark1.R;
import com.example.mark1.object.CustomFilter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> implements Filterable {

    private Context context;
    public ArrayList<NewsObject> newsObjects, filterList;
    CustomFilter filter;

    public NewsAdapter(Context context, ArrayList<NewsObject> newsObjects) {
        this.context = context;
        this.newsObjects = newsObjects;
        this.filterList = newsObjects;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_row, null);

        return new NewsHolder(view); //return view to the holder class
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int position) {

        //Set animation for news (Recycler view)
        newsHolder.newsCardView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_from_right));

        newsHolder.tvTitle.setText(newsObjects.get(position).getTitle());
        newsHolder.tvDescription.setText(newsObjects.get(position).getDescription());

        //Use Picasso to put the image into the imageView
        Picasso.with(context).load(newsObjects.get(position).getImage()).into(newsHolder.ivNews);
    }

    @Override
    public int getItemCount() {
        return newsObjects.size();
    }

    @Override
    public Filter getFilter() {

        if (filter == null){

            filter = new CustomFilter(filterList, this);

        }

        return filter;
    }
}
