package com.example.ricardo.bppmobiletest.features.timeline.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ricardo.bppmobiletest.R;
import com.example.ricardo.bppmobiletest.features.timeline.TimelineAdapterContract;

public class TimelineHolder extends RecyclerView.ViewHolder implements TimelineAdapterContract.View {

    private TextView merchantDescriptionText;
    private TextView merchantNameText;
    private TextView transactionCurrencyText;
    private TextView transactionAmountText;
    private TextView transactionDateText;

    public TimelineHolder(View itemView) {
        super(itemView);
        merchantDescriptionText = itemView.findViewById(R.id.merchant_description);
        merchantNameText = itemView.findViewById(R.id.merchant_name);
        transactionCurrencyText = itemView.findViewById(R.id.transaction_currency);
        transactionAmountText = itemView.findViewById(R.id.transaction_amount);
        transactionDateText = itemView.findViewById(R.id.transaction_date);
    }

    @Override
    public void setMerchantDescription(String merchantDescription) {
        merchantDescriptionText.setText(merchantDescription);
    }

    @Override
    public void setMerchantName(String merchantName) {
        merchantNameText.setText(merchantName);
    }

    @Override
    public void setTransactionCurrency(String transactionCurrency) {
        transactionCurrencyText.setText(transactionCurrency);
    }

    @Override
    public void setTransactionAmount(String transactionAmount) {
        transactionAmountText.setText(transactionAmount);
    }

    @Override
    public void setTransactionDate(String transactionFormattedDate) {
        transactionDateText.setText(transactionFormattedDate);
    }
}
