package com.gmail.tarasov1998.demoapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.tarasov1998.demoapplication.R;
import com.gmail.tarasov1998.demoapplication.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private static final String AVATARS = "https://avatars.io/twitter/";

    private static List<User> usersList;

    private LayoutInflater mInflater;

    static class ViewHolder extends RecyclerView.ViewHolder {

        private Context mContext;

        @BindView(R.id.userName)
        TextView userName;
        @BindView(R.id.email)
        TextView email;
        @BindView(R.id.catchPhrases)
        TextView catchPhrase;
        @BindView(R.id.avatar)
        ImageView avatar;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(mContext, UserActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Bundle extras = new Bundle();

                    extras.putString("userName", usersList.get(itemPosition).getName());
                    extras.putString("email", usersList.get(itemPosition).getEmail());
                    extras.putString("phone", usersList.get(itemPosition).getPhone());
                    extras.putString("website", usersList.get(itemPosition).getWebsite());
                    extras.putDouble("lat", usersList.get(itemPosition).getAddress().getGeo().getLat());
                    extras.putDouble("lng", usersList.get(itemPosition).getAddress().getGeo().getLng());
                    intent.putExtras(extras);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    RecycleViewAdapter(Context context, List<User> usersList) {
        this.mInflater = LayoutInflater.from(context);
        RecycleViewAdapter.usersList = usersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.users_list, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        String name = usersList.get(position).getName();
        holder.userName.setText(name);
        String email = usersList.get(position).getEmail();
        holder.email.setText(email);
        String catchPhrase = usersList.get(position).getCompany().getCatchPhrase();
        holder.catchPhrase.setText(catchPhrase);
        Picasso.with(context).load(getAvatars(position)).into(holder.avatar);

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

   private String getAvatars(Integer id) {
        return AVATARS + id;
    }

}

