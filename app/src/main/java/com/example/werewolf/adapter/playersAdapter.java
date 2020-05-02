package com.example.werewolf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.werewolf.R;
import com.example.werewolf.model.Players;

import java.util.ArrayList;

public class playersAdapter extends RecyclerView.Adapter<playersAdapter.MyViewHolder> {

    private Context pContext;
    private ArrayList<Players> pData;

    public playersAdapter(Context pContext, ArrayList<Players> pData) {
        this.pContext = pContext;
        this.pData = pData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater pInflater = LayoutInflater.from(pContext);
        view = pInflater.inflate(R.layout.player_list,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.player_name.setText(pData.get(position).getPname());
        holder.player_img.setImageURI(pData.get(position).getPimg());

    }

    @Override
    public int getItemCount() {
        return pData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView player_name;
        ImageView player_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            player_name = (TextView) itemView.findViewById(R.id.player_name);
            player_img = (ImageView) itemView.findViewById(R.id.player_imgprompt);


        }
    }

}
