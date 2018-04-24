package com.example.ricardo.bppmobiletest.features.timeline.model;

import android.support.annotation.NonNull;

import com.example.ricardo.bppmobiletest.common.BaseRepository;
import com.example.ricardo.bppmobiletest.features.timeline.api.TimelineEndpoint;
import com.example.ricardo.bppmobiletest.features.timeline.api.TimelinePayload;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteTimelineRepository extends BaseRepository<TimelineEndpoint> implements TimelineRepository {

    @Override
    public void fetchTimeline(OnTimelineListener listener) {
        Call<List<TimelinePayload>> call = getApi().fetchTimeline();
        call.enqueue(new Callback<List<TimelinePayload>>() {
            @Override
            public void onResponse(@NonNull Call<List<TimelinePayload>> call, @NonNull Response<List<TimelinePayload>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Timeline> timelineList = new ArrayList<>();
                    for (TimelinePayload payload : response.body()) {
                        timelineList.add(payload.toTimeline());
                    }
                    listener.onRequestSuccess(timelineList);
                } else {
                    listener.onRequestError();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<TimelinePayload>> call, @NonNull Throwable t) {
                listener.onRequestFail();
            }
        });
    }

    @Override
    protected Class<TimelineEndpoint> getEndpointClass() {
        return TimelineEndpoint.class;
    }
}
