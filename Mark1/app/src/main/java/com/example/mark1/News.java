package com.example.mark1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;

import com.example.mark1.object.news.NewsAdapter;
import com.example.mark1.object.news.NewsObject;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class News extends Fragment{

    private RecyclerView recyclerView;
    private Toolbar newsToolbar;
    private NewsAdapter newsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);

        recyclerView = view.findViewById(R.id.news_recyclerView);
        newsToolbar = view.findViewById(R.id.news_toolbar);
        newsToolbar.setTitle("News");
        ((AppCompatActivity)getActivity()).setSupportActionBar(newsToolbar); //To let the fragment support the toolbar

        setHasOptionsMenu(true);

        //getActivity is to get the current fragment associated with the activity
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        newsAdapter = new NewsAdapter(getActivity(), getNewsList());
        recyclerView.setAdapter(newsAdapter);

        return view;

    }

    private ArrayList<NewsObject> getNewsList(){
        final ArrayList<NewsObject> newsObjects = new ArrayList<>();

        //Retrieve News from db
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        CollectionReference newsRef = firebaseFirestore.collection("News");

        newsRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){

                    NewsObject news = documentSnapshot.toObject(NewsObject.class);
                    newsObjects.add(news);

                }
            }
        });

        return newsObjects;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        System.out.println("Calling onCreateOptionsMenu");
        System.out.println("Calling onCreateOptionsMenu");

        inflater.inflate(R.menu.news_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);

        MenuItem searchItem = menu.findItem(R.id.news_search);
        SearchView searchView = (SearchView)searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                newsAdapter.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                newsAdapter.getFilter().filter(newText);

                return false;
            }
        });

    }

}
