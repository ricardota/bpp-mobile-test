package com.example.ricardo.bppmobiletest.features.timeline.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ricardo.bppmobiletest.R;
import com.example.ricardo.bppmobiletest.features.timeline.TimelineContract;
import com.example.ricardo.bppmobiletest.features.timeline.model.Timeline;
import com.example.ricardo.bppmobiletest.features.timeline.presenter.TimelineAdapterPresenter;
import com.example.ricardo.bppmobiletest.features.timeline.presenter.TimelinePresenter;

import java.util.List;

public class TimelineActivity extends AppCompatActivity implements TimelineContract.View {

    private RecyclerView timelineView;
    private View progressView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_timeline);

        timelineView = findViewById(R.id.timeline_view);
        progressView = findViewById(R.id.timeline_progress);

        timelineView.setLayoutManager(new LinearLayoutManager(this));

        TimelineContract.Presenter presenter = new TimelinePresenter(this);
        presenter.setup();
    }

    @Override
    public void showProgressView() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressView() {
        progressView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showTimelineView(List<Timeline> timelineList) {
        progressView.setVisibility(View.INVISIBLE);

        TimelineAdapterPresenter listPresenter = new TimelineAdapterPresenter(timelineList);
        timelineView.setAdapter(new TimelineAdapter(listPresenter));
    }
}
