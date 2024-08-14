package com.example.project3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList courseImg, courseName;
    Context context;

    public Adapter(Context context, ArrayList courseImg, ArrayList courseName){
        this.context = context;
        this.courseName = courseName;
        this.courseImg = courseImg;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        Adapter.ViewHolder viewHolder = new Adapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int i = (int) courseImg.get(position);
        holder.images.setImageResource(i);
        holder.text.setText((String) courseName.get(position));
    }

    @Override
    public int getItemCount() {
        return courseImg.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView images;
        TextView text;
        public ViewHolder(@NonNull View view) {
            super(view);
            images =(ImageView) view.findViewById(R.id.courseImg);
            text = (TextView) view.findViewById(R.id.courseName);
        }
    }
}

