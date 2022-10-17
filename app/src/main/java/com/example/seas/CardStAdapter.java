package com.example.seas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seas.databinding.CardSignCellBinding;
import com.example.seas.interfaces.OnSignTextClick;

import java.util.List;

public class CardStAdapter extends RecyclerView.Adapter<CardStViewHolder>{
    List<Sign> sign;
    OnSignTextClick getMean;

    public CardStAdapter(List<Sign> sign, OnSignTextClick getMean){
        this.getMean = getMean;
        this.sign = sign;
    }

    @NonNull
    @Override
    public CardStViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        CardSignCellBinding binding = CardSignCellBinding.inflate(from, parent, false);
        return new CardStViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardStViewHolder holder, int position) {
        holder.bindBook(sign.get(position), getMean);
    }

    @Override
    public int getItemCount() {
        return sign.size();
    }
}
