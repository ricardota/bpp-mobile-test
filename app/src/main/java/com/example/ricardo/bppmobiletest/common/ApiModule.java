package com.example.ricardo.bppmobiletest.common;

import com.example.ricardo.bppmobiletest.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiModule {

    private static final String BASE_URL = "http://test-mobile.dev-bpp.com.br";

    private Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .client(provideHttpClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient provideHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }

        return builder.build();
    }

    public static Retrofit get() {
        ApiModule module = new ApiModule();
        return module.provideRetrofit();
    }
}
