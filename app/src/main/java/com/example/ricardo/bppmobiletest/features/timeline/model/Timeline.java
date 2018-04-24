package com.example.ricardo.bppmobiletest.features.timeline.model;

public class Timeline {

    private String transactionId;
    private String transactionDate;
    private String transactionFormattedDate;
    private String transactionCurrency;
    private Double transactionAmount;
    private String billingCurrency;
    private Double billingAmount;
    private String transactionStatus;
    private String transactionName;
    private String merchantName;
    private String mccCode;
    private String mccDescription;

    public Timeline(String transactionId, String transactionDate, String transactionFormattedDate,
                    String transactionCurrency, Double transactionAmount, String billingCurrency,
                    Double billingAmount, String transactionStatus, String transactionName,
                    String merchantName, String mccCode, String mccDescription) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionFormattedDate = transactionFormattedDate;
        this.transactionCurrency = transactionCurrency;
        this.transactionAmount = transactionAmount;
        this.billingCurrency = billingCurrency;
        this.billingAmount = billingAmount;
        this.transactionStatus = transactionStatus;
        this.transactionName = transactionName;
        this.merchantName = merchantName;
        this.mccCode = mccCode;
        this.mccDescription = mccDescription;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionFormattedDate() {
        return transactionFormattedDate;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public String getBillingCurrency() {
        return billingCurrency;
    }

    public Double getBillingAmount() {
        return billingAmount;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getMccCode() {
        return mccCode;
    }

    public String getMccDescription() {
        return mccDescription;
    }
}
