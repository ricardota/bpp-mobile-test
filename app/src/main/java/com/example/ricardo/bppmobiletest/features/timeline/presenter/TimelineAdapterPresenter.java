package com.example.ricardo.bppmobiletest.features.timeline.presenter;

import com.example.ricardo.bppmobiletest.features.timeline.TimelineAdapterContract;
import com.example.ricardo.bppmobiletest.features.timeline.model.Timeline;
import com.example.ricardo.bppmobiletest.features.timeline.view.holder.TimelineHolder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TimelineAdapterPresenter implements TimelineAdapterContract.Presenter {

    private static final String NUMBER_FORMAT = "%1.2f";
    private static final String ORIGINAL_DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss";
    private static final String TARGET_DATE_FORMAT = "dd/MM/yyyy";

    private final List<Timeline> timelineList;

    public TimelineAdapterPresenter(List<Timeline> timelineList) {
        this.timelineList = timelineList;
    }

    @Override
    public void onBindTimelineView(int position, TimelineHolder holder) {
        Timeline timeline = timelineList.get(position);

        holder.setMerchantDescription(timeline.getMccDescription());
        holder.setMerchantName(timeline.getMerchantName());
        holder.setTransactionCurrency(getSymbol(timeline));
        holder.setTransactionAmount(getTransactionAmount(timeline));
        holder.setTransactionDate(getTransactionFormattedDate(timeline));
    }

    @Override
    public int getTimelineListSize() {
        return timelineList.size();
    }

    private String getSymbol(Timeline timeline) {
        return Currency.getInstance(timeline.getTransactionCurrency()).getSymbol();
    }

    private String getTransactionAmount(Timeline timeline) {
        return String.format(Locale.getDefault(), NUMBER_FORMAT, timeline.getTransactionAmount());
    }

    private String getTransactionFormattedDate(Timeline timeline) {
        DateFormat originalFormat = new SimpleDateFormat(ORIGINAL_DATE_FORMAT, Locale.getDefault());
        DateFormat targetFormat = new SimpleDateFormat(TARGET_DATE_FORMAT, Locale.getDefault());
        Date date;
        try {
            date = originalFormat.parse(timeline.getTransactionFormattedDate());
        } catch (ParseException e) {
            date = null;
        }
        return targetFormat.format(date);
    }
}
