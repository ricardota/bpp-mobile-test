package com.example.ricardo.bppmobiletest.features.timeline;

import com.example.ricardo.bppmobiletest.features.timeline.view.holder.TimelineHolder;

public interface TimelineAdapterContract {

    interface View {
        void setMerchantDescription(String merchantDescription);

        void setMerchantName(String merchantName);

        void setTransactionCurrency(String transactionCurrency);

        void setTransactionAmount(String transactionAmount);

        void setTransactionDate(String transactionFormattedDate);
    }

    interface Presenter {
        void onBindTimelineView(int position, TimelineHolder holder);

        int getTimelineListSize();
    }

}
