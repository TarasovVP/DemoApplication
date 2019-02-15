package com.gmail.tarasov1998.demoapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private  List<String> namesUsers;
    private  List<String> emailsUsers;
    private  List<String> catchPhrasesUsers;
    private  List<Integer> avatarsUsers;
    private  LayoutInflater mInflater;



    static class ViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;

        @BindView(R.id.userName)
        TextView name;
        @BindView(R.id.email)
        TextView email;
        @BindView(R.id.catchPhrases)
        TextView catchPhrase;
        @BindView(R.id.avatar)
        ImageView avatar;

        @BindView(R.id.relative)
        RelativeLayout relative;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(mContext, UserActivity.class);
                    Bundle extras = new Bundle();
                    /*UserModel userModel;
                    String name = userModel.name.get(itemPosition);

                    extras.putString("name", name);*/
                   // extras.putString("email", userModel.email.get(itemPosition));
                    //extras.putString("phone", userModel.phone.get(itemPosition));
                   // extras.putString("website", userModel.website.get(itemPosition));
                    intent.putExtras(extras);
                    mContext.startActivity(intent);
                }
            });
        }


    }


    RecycleViewAdapter(Context context, List<String> name, List<String> email, List<String> catchPhrase, List<Integer> avatars) {
        this.mInflater = LayoutInflater.from(context);
        this.namesUsers = name;
        this.emailsUsers = email;
        this.catchPhrasesUsers = catchPhrase;
        this.avatarsUsers = avatars;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.users_list, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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
        return namesUsers.size();

    }


}

