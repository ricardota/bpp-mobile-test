package com.example.ricardo.bppmobiletest.features.timeline.presenter;

import com.example.ricardo.bppmobiletest.features.timeline.TimelineContract;
import com.example.ricardo.bppmobiletest.features.timeline.model.RemoteTimelineRepository;
import com.example.ricardo.bppmobiletest.features.timeline.model.Timeline;
import com.example.ricardo.bppmobiletest.features.timeline.model.TimelineRepository;

import java.util.List;

public class TimelinePresenter implements TimelineContract.Presenter, TimelineRepository.OnTimelineListener {

    private final TimelineContract.View view;

    public TimelinePresenter(TimelineContract.View view) {
        this.view = view;
    }

    @Override
    public void setup() {
        view.showProgressView();
        TimelineRepository repository = new RemoteTimelineRepository();
        repository.fetchTimeline(this);
    }

    @Override
    public void onRequestSuccess(List<Timeline> timelineList) {
        view.showTimelineView(timelineList);
    }

    @Override
    public void onRequestError() {
        view.hideProgressView();
    }

    @Override
    public void onRequestFail() {
        view.hideProgressView();
    }
}
