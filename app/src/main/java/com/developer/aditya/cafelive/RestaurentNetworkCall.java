package com.developer.aditya.cafelive;
import com.developer.aditya.cafelive.pojo.RestaurentResponse;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by root on 27/4/17.
 */

public interface RestaurentNetworkCall {

    @GET("/api/v2.1/geocode")
    Call<RestaurentResponse> getRestaurentDetails(@Header("user-key") String apiKey, @Query("lat") String latitude, @Query("lon") String longitude);
}
