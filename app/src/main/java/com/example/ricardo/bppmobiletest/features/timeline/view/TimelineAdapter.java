package com.example.ricardo.bppmobiletest.features.timeline.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ricardo.bppmobiletest.R;
import com.example.ricardo.bppmobiletest.features.timeline.TimelineAdapterContract;
import com.example.ricardo.bppmobiletest.features.timeline.presenter.TimelineAdapterPresenter;
import com.example.ricardo.bppmobiletest.features.timeline.view.holder.TimelineHolder;

class TimelineAdapter extends RecyclerView.Adapter<TimelineHolder> {

    private final TimelineAdapterContract.Presenter presenter;

    public TimelineAdapter(TimelineAdapterPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public TimelineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimelineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.timeline_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TimelineHolder holder, int position) {
        presenter.onBindTimelineView(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getTimelineListSize();
    }
}
