package com.example.lesson_2.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lesson_2.R;

import java.text.DateFormat;
import java.util.Calendar;

public class MyListAdapter extends BaseAdapter {

    private Context mcontext;
    private LayoutInflater mlayoutInflater;

    public MyListAdapter(Context context){
        this.mcontext = context;
        mlayoutInflater = LayoutInflater.from(context);
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
        public TextView tvTitle, tvDate, tvContent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if(convertView == null){
            convertView = mlayoutInflater.inflate(R.layout.layout_list_item, null);

            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv_1);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvDate = convertView.findViewById(R.id.tv_date);
            holder.tvContent = convertView.findViewById(R.id.tv_content);

            convertView.setTag(holder);
        }else{

            holder = (ViewHolder) convertView.getTag();
        }

        //Set the text (Override the text in xml file)
        holder.tvTitle.setText("This is title");

        //Get the Calender date
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
        holder.tvDate.setText(currentDate);

        holder.tvContent.setText("Android Studio !!!");

        Glide.with(mcontext).load("https://moodle.htwchur.ch/pluginfile.php/124614/mod_page/content/4/example.jpg").into(holder.imageView);

        return convertView;
    }
}
