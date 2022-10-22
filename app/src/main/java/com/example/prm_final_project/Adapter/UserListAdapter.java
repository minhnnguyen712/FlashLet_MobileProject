package com.example.prm_final_project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm_final_project.Model.Deck;
import com.example.prm_final_project.Model.User;
import com.example.prm_final_project.R;
import com.example.prm_final_project.Ui.Activity.MyFlashcardsActivity;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_user_view, parent, false);

        return new UserViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User u = users.get(position);
        int deckSize = 0;
        if(u.getMyDeck() == null){
            deckSize = 0;
        } else{
            deckSize = u.getMyDeck().size();
        }
        holder.userNameTextView.setText(u.getUsername());
        holder.totalDeckTextView.setText(deckSize + " decks");
        holder.userItemLayout.setOnClickListener(view -> onClick(u));
    }

    private void onClick(User u) {
        Intent intent = new Intent(context, MyFlashcardsActivity.class);
//        intent.putExtra("currentUser", u);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(users == null) {
            return 0;
        } else{
            return users.size();
        }
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private UserListAdapter userListAdapter;
        private TextView userNameTextView, totalDeckTextView;
        private LinearLayout userItemLayout;
        public UserViewHolder(@NonNull View itemView, UserListAdapter userListAdapter) {
            super(itemView);
            this.userListAdapter = userListAdapter;
            userNameTextView = itemView.findViewById(R.id.tv_user_name);
            totalDeckTextView = itemView.findViewById(R.id.tv_user_no_deck);
            userItemLayout = itemView.findViewById(R.id.layout_user_item);
        }
    }
}
