package com.example.ricardo.bppmobiletest.features.timeline.model;

import java.util.List;

public interface TimelineRepository {

    interface OnTimelineListener {
        void onRequestSuccess(List<Timeline> timelineList);

        void onRequestError();

        void onRequestFail();
    }

    void fetchTimeline(OnTimelineListener listener);

}
