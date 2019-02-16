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
import com.gmail.tarasov1998.demoapplication.model.UserModel;
import com.gmail.tarasov1998.demoapplication.network.Network;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {


    private LayoutInflater mInflater;

    private static UserModel userModel;




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

                    extras.putString("userName", userModel.getName(itemPosition));
                    extras.putString("email", userModel.getEmail(itemPosition));
                    extras.putString("phone", userModel.getPhone(itemPosition));
                    extras.putString("website", userModel.getWebsite(itemPosition));
                    intent.putExtras(extras);
                    mContext.startActivity(intent);
                }
            });
        }


    }


    RecycleViewAdapter(Context context, UserModel userModel) {
        this.mInflater = LayoutInflater.from(context);
        RecycleViewAdapter.userModel = userModel;
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
        String name = userModel.getUsername(position);
        holder.userName.setText(name);
        String email = userModel.getEmail(position);
        holder.email.setText(email);
        String catchPhrase = userModel.getCatchPhrase(position);
        holder.catchPhrase.setText(catchPhrase);
        Picasso.with(context).load(new Network().getAvatars(position)).into(holder.avatar);

    }

    @Override
    public int getItemCount() {
        return userModel.getCount();

    }


}

