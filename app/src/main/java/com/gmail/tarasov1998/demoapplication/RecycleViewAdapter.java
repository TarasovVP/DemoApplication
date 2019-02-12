/*
package com.gmail.tarasov1998.demoapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecycleViewAdapter extends Adapter<RecycleViewAdapter.ViewHolder> {

    private List<String> namesUsers;
    private List<String> emailsUsers;
    private List<String> catchPhrasesUsers;
    private List<Integer> avatarsUsers;
    private LayoutInflater mInflater;


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, catchPhrase;
        ImageView avatar;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            email = itemView.findViewById(R.id.email);
            catchPhrase = itemView.findViewById(R.id.catchPhrases);
            avatar = itemView.findViewById(R.id.avatar);

        }

    }


    RecycleViewAdapter(Context context, List<String> name, List<String> email, List<String> catchPhrase, List<Integer> avatars) {
        this.mInflater = LayoutInflater.from(context);
        this.namesUsers = name;
        this.emailsUsers = email;
        this.catchPhrasesUsers = catchPhrase;
        this.avatarsUsers = avatars;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.users_list, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = namesUsers.get(position);
        holder.name.setText(name);
        String email = emailsUsers.get(position);
        holder.email.setText(email);
        String catchPhrase = catchPhrasesUsers.get(position);
        holder.catchPhrase.setText(catchPhrase);
        Integer avatar = avatarsUsers.get(position);
        holder.avatar.setImageResource(avatar);
    }

    @Override
    public int getItemCount() {
        return 5;

    }



}

*/
