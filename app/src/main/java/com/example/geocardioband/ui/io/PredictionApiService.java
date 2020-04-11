package com.example.geocardioband.ui.io;

import com.example.geocardioband.ui.io.response.PredictRequest;
import com.example.geocardioband.ui.io.response.PredictResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PredictionApiService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("predict")
    Call<PredictResponse> postPredict(@Body PredictRequest body);
}
