package com.example.seas;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seas.databinding.CardSignCellBinding;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {

    List<Sign> sign;
    public CardAdapter(List<Sign> sign){
        this.sign = sign;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        CardSignCellBinding binding = CardSignCellBinding.inflate(from, parent, false);
        return new CardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.bindBook(sign.get(position));
    }

    @Override
    public int getItemCount() {
        return sign.size();
    }
}
