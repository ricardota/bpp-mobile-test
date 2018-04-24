package com.example.ricardo.bppmobiletest.common;

public abstract class BaseRepository<T> {

    protected T getApi() {
        return ApiModule.get().create(getEndpointClass());
    }

    protected abstract Class<T> getEndpointClass();
}
