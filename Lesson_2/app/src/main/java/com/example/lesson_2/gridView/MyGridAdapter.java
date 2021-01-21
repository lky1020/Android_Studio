package com.example.lesson_2.gridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lesson_2.R;

public class MyGridAdapter extends BaseAdapter {

    private Context mcontext;
    private LayoutInflater mLayoutInflater;

    public MyGridAdapter(Context context){
        this.mcontext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_grid_item, null);

            holder = new ViewHolder();

            holder.imageView = convertView.findViewById(R.id.iv_grid);
            holder.textView = convertView.findViewById(R.id.tv_title);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //Set value (optional)
        /*holder.textView.setText("Hello");
        Glide.with(mcontext).load("https://moodle.htwchur.ch/pluginfile.php/124614/mod_page/content/4/example.jpg").into(holder.imageView);*/

        return convertView;
    }
}
