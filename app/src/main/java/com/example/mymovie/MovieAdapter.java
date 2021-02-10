package com.example.mymovie;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private ArrayList<MovieItem> lists = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_rank;
        private TextView tv_name;
        private TextView tv_people;
        private TextView tv_rank_updown;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_rank = (TextView)itemView.findViewById(R.id.tv_rank);
            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_people = (TextView)itemView.findViewById(R.id.tv_people);
            tv_rank_updown = (TextView)itemView.findViewById(R.id.tv_rank_updown);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.movie_item, parent,false);
        MovieAdapter.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieItem item = lists.get(position);

        holder.tv_rank.setText(item.getMoiveRank());
        holder.tv_name.setText(item.getMovieName());
        holder.tv_people.setText(item.getMoviePeople());
        holder.tv_rank_updown.setText(item.getMovieUpDown());

        switch(item.setColor()){
            case 1:
                holder.tv_rank_updown.setTextColor(Color.RED);
                break;
            case 2:
                holder.tv_rank_updown.setTextColor(Color.BLUE);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public void addItem(String movieRank, String movieName, String moviePeople, String movieUpdown){
        MovieItem movieItem = new MovieItem();

        movieItem.setMoiveRank(movieRank);
        movieItem.setMovieName(movieName);
        movieItem.setMoviePeople(moviePeople);
        movieItem.setMovieUpDown(movieUpdown);

        lists.add(movieItem);
    }
}
