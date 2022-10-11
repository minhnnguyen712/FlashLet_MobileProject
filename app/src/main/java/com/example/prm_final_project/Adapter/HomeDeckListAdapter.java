package com.example.prm_final_project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm_final_project.Controller.HomePageActivity;
import com.example.prm_final_project.Controller.ViewCardActivity;
import com.example.prm_final_project.Module.Deck;
import com.example.prm_final_project.R;

import java.util.ArrayList;
import java.util.List;

public class HomeDeckListAdapter extends RecyclerView.Adapter<HomeDeckListAdapter.AddressViewHolder>{

    Context context;
    boolean isGuest;
    ArrayList<Deck> decks;

    public HomeDeckListAdapter(Context context,ArrayList<Deck> deck){
        this.context = context;
        this.decks = deck ;

    };

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.deck_lv_item,parent,false);
        return new AddressViewHolder(view,HomeDeckListAdapter.this);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        Deck curentDeck = decks.get(position);
        holder.title.setText(curentDeck.getTitle());
        holder.totalNum.setText(curentDeck.getCards().size()+" cards");
        holder.author.setText(curentDeck.getAuthor());
        holder.layoutItem.setOnClickListener(view -> onItem(curentDeck));

    }

    private void onItem(Deck currentDeck) {
        Intent i = new Intent(context, ViewCardActivity.class);
        i.putExtra("viewDeck",currentDeck);
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return decks==null?0:decks.size();
    }


    public class AddressViewHolder extends RecyclerView.ViewHolder {
        TextView author ;
        TextView title ;
        TextView totalNum;
        HomeDeckListAdapter homeDeckListAdapter;
        private ConstraintLayout layoutItem;
        public AddressViewHolder(@NonNull View itemView, HomeDeckListAdapter homeDeckListAdapter) {
            super(itemView);
            this.homeDeckListAdapter = homeDeckListAdapter;
            layoutItem = itemView.findViewById(R.id.deckViewItem);
            author = itemView.findViewById(R.id.tvDeckAuthor);
            totalNum = itemView.findViewById(R.id.tvDeckTotal);
            title = itemView.findViewById(R.id.tvDeckName);
        }
    }
}
