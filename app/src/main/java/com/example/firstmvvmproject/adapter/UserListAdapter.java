package com.example.firstmvvmproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstmvvmproject.R;
import com.example.firstmvvmproject.model.UserModel;

import java.util.List;


public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListHolder> {
    private Context context;
    private List<UserModel> userModelList;

    public UserListAdapter(Context context, List<UserModel> userModelList) {
        this.context = context;
        this.userModelList = userModelList;
    }

    public void setUserModelList(List<UserModel> userModelList){
        this.userModelList = userModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_recycler_items, parent, false);
        return new UserListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListHolder holder, int position) {
        holder.txtTitle.setText(userModelList.get(position).getTitle());
        holder.txtCompleted.setText(userModelList.get(position).isCompleted());
    }

    @Override
    public int getItemCount() {
        if (userModelList != null){
            return userModelList.size();
        }
        return 0;
    }

    public class UserListHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtCompleted;

        public UserListHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtCompleted = itemView.findViewById(R.id.txtCompleted);
        }
    }
}
