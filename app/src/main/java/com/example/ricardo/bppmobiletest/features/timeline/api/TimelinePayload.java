package com.example.ricardo.bppmobiletest.features.timeline.api;

import com.example.ricardo.bppmobiletest.features.timeline.model.Timeline;

public class TimelinePayload {

    String transactionId;
    String transactionDate;
    String transactionFormattedDate;
    String transactionCurrency;
    Double transactionAmount;
    String billingCurrency;
    Double billingAmount;
    String transactionStatus;
    String transactionName;
    String merchantName;
    String mccCode;
    String mccDescription;

    public Timeline toTimeline() {
        return new Timeline(
                transactionId,
                transactionDate,
                transactionFormattedDate,
                transactionCurrency,
                transactionAmount,
                billingCurrency,
                billingAmount,
                transactionStatus,
                transactionName,
                merchantName,
                mccCode,
                mccDescription);
    }
}

