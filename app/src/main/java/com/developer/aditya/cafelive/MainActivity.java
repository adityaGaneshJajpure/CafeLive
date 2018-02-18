package com.developer.aditya.cafelive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.developer.aditya.cafelive.pojo.RestaurentResponse;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendRequestToNetwork();
    }
    public void sendRequestToNetwork()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://developers.zomato.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestaurentNetworkCall service = retrofit.create(RestaurentNetworkCall.class);
        Call<RestaurentResponse> response = service.getRestaurentDetails("05e82b950a6134e6f164a4b67fe480ec","22.7196","75.8577");
        response.enqueue(new Callback<RestaurentResponse>() {
            @Override
            public void onResponse(Call<RestaurentResponse> call, Response<RestaurentResponse> response) {
                if (response.isSuccessful()) {
                    ListView lv = (ListView)findViewById(R.id.list_item_mine);
                    lv.setAdapter(new RestaurantAdapter(getApplicationContext(),response.body().getNearbyRestaurants()));
                    Log.e("onResponse: ",lv.toString());
                }
                else
                {

                }
            }

            @Override
            public void onFailure(Call<RestaurentResponse> call, Throwable t) {

            }
        });
        {


        }
    }
}
