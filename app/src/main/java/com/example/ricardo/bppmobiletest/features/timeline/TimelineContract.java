package com.example.ricardo.bppmobiletest.features.timeline;

import com.example.ricardo.bppmobiletest.features.timeline.model.Timeline;

import java.util.List;

public interface TimelineContract {

    interface View {
        void showProgressView();

        void hideProgressView();

        void showTimelineView(List<Timeline> timelineList);
    }

    interface Presenter {
        void setup();
    }

}
