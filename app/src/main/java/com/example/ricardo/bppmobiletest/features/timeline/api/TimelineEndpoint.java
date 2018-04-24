package com.example.ricardo.bppmobiletest.features.timeline.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimelineEndpoint {

    @GET("invoice")
    Call<List<TimelinePayload>> fetchTimeline();
}
