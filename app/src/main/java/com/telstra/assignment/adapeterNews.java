package com.telstra.assignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

/**
 * Created by bhushanshirsath on 1/9/18.
 */

public class adapeterNews extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private LayoutInflater inflater;
    List<DataNews> lstDataNews= Collections.emptyList();
    DataNews current;
    int currentPos=0;

    adapeterNews(Context context, List<DataNews> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.lstDataNews = data;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_news_row, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        MyHolder myHolder= (MyHolder) holder;
        DataNews current=lstDataNews.get(position);
        myHolder.textTitle.setText(current.title);
        myHolder.textDescp.setText("Descrp:: " + current.strNews);


        Glide.with(context).load(current.strImageUrl)
                .placeholder(R.drawable.ic_img_error)
                .error(R.drawable.ic_img_error)
                .into(myHolder.imvNews);


    }

    @Override
    public int getItemCount() {
        return lstDataNews.size();
    }



    class MyHolder extends RecyclerView.ViewHolder{
        TextView textTitle;
        ImageView imvNews;
        TextView textDescp
                ;
        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);



            textTitle= (TextView) itemView.findViewById(R.id.textTitle);
            imvNews= (ImageView) itemView.findViewById(R.id.imvNews);
            textDescp = (TextView) itemView.findViewById(R.id.textDescp);


        }

    }

}
