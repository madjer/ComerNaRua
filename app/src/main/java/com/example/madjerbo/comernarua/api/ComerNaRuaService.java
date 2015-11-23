package com.example.madjerbo.comernarua.api;

import com.example.madjerbo.comernarua.entities.Foodtruck;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

public interface ComerNaRuaService {
    static final String ACCEPT_APPLICATION_JSON = "Accept: application/json";
    static final String CONTENT_TYPE_APPLICATION_JSON = "Content-Type: application/json";

    @Headers({ACCEPT_APPLICATION_JSON, CONTENT_TYPE_APPLICATION_JSON})
    @GET("/foodtrucks")
    void foodtrucks(Callback<List<Foodtruck>> callback);

    @Headers({ACCEPT_APPLICATION_JSON, CONTENT_TYPE_APPLICATION_JSON})
    @GET("/foodtrucks/{id}")
    void foodtruck(@Path("id") String id, Callback<Foodtruck> callback);
}
