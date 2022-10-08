package com.example.seas;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seas.databinding.CardSignCellBinding;

public class CardViewHolder extends RecyclerView.ViewHolder {
    CardSignCellBinding cardSignCellBinding;
    public CardViewHolder(CardSignCellBinding cardSignCellBinding) {
        super(cardSignCellBinding.getRoot());
        this.cardSignCellBinding = cardSignCellBinding;
    }

    public void bindBook (Sign sign){
        cardSignCellBinding.imgSign.setImageResource(sign.sign);
        cardSignCellBinding.txtSign.setText(sign.mean+"");
    }
}
