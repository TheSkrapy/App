package com.example.seas;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.seas.databinding.CardSignCellBinding;
import com.example.seas.interfaces.OnSignTextClick;

public class CardStViewHolder extends RecyclerView.ViewHolder{
    CardSignCellBinding cardSignCellBinding;

    public CardStViewHolder(CardSignCellBinding cardSignCellBinding) {
        super(cardSignCellBinding.getRoot());
        this.cardSignCellBinding = cardSignCellBinding;
    }

    public void bindBook (Sign sign, OnSignTextClick getMean){
        cardSignCellBinding.imgSign.setImageResource(sign.sign);
        cardSignCellBinding.txtSign.setText(sign.mean+"");
        cardSignCellBinding.card.setOnClickListener(view -> getMean.onClick(sign.mean+""));
    }
}
