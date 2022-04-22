package com.example.catsessions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolderRv> {

    private ArrayList<User> Users;


    public CustomAdapter(ArrayList<User> User) {
        this.Users = User;
    }

    @NonNull
    @Override
    public ViewHolderRv onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, parent, false);
        ViewHolderRv holder = new ViewHolderRv(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRv holder, int position) {
        User user= Users.get(position);
        holder.img.setImageResource(user.getImg());
        holder.text.setText(user.getText());
    }

    @Override
    public int getItemCount() {
        return Users.size();
    }

    public class ViewHolderRv extends RecyclerView.ViewHolder {
        ImageView img;
        TextView text;

        public ViewHolderRv(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.iv);
            text =itemView.findViewById(R.id.tv);

        }
    }
}