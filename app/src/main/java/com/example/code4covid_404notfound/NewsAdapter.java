package com.example.code4covid_404notfound;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    ArrayList<News> items = new ArrayList<>();
    NewsItemClicked listener;
    public NewsAdapter(NewsItemClicked listener){
        this.listener = listener;

    }

    @Override
    public NewsViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.items,parent,false);
        NewsViewHolder viewHolder = new NewsViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(items.get(viewHolder.getAdapterPosition()));
            }
        });
        return viewHolder;
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        News title = items.get(position);
        holder.textTitle.setText(title.getmTitle());
        if(title.getmAuthor()=="null"){
            holder.author.setText(" ");
        }
        else {
            holder.author.setText(title.getmAuthor());
        }
        Glide.with(holder.itemView.getContext()).load(title.getmImageurl()).into(holder.imageView);


    }

    public void updateNews(ArrayList<News> updateNews){
        items.clear();
        items.addAll(updateNews);
        notifyDataSetChanged();//onBindViewHolder,getItemCount(),onCreateViewHolder call again
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle;
        TextView author;
        ImageView imageView;

        public NewsViewHolder(View itemView){
            super(itemView);
            textTitle =(TextView) itemView.findViewById(R.id.title);
            imageView= (ImageView) itemView.findViewById(R.id.image);
            author =(TextView) itemView.findViewById(R.id.author);
        }
    }
}
