package com.example.mark1.object;

import android.widget.Filter;

import com.example.mark1.object.news.NewsAdapter;
import com.example.mark1.object.news.NewsObject;

import java.util.ArrayList;

public class CustomFilter extends Filter {

    ArrayList<NewsObject> filterList;
    NewsAdapter adapter;

    public CustomFilter(ArrayList<NewsObject> filterList, NewsAdapter adapter) {
        this.filterList = filterList;
        this.adapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        FilterResults result = new FilterResults();

        if(constraint != null && constraint.length() > 0){

            constraint = constraint.toString().toLowerCase();

            ArrayList<NewsObject> filterNewsObjects = new ArrayList<>();

            for(int i = 0; i < filterList.size(); i++){

                if(filterList.get(i).getTitle().toLowerCase().contains(constraint)){

                    filterNewsObjects.add(filterList.get(i));
                }

                result.count = filterNewsObjects.size();
                result.values = filterNewsObjects;
            }

        }else{

            result.count = filterList.size();
            result.values = filterList;

        }

        return result;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.newsObjects = (ArrayList<NewsObject>) results.values;
        adapter.notifyDataSetChanged();
    }
}
