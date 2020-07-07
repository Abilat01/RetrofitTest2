package com.abilat.layouttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Play extends AppCompatActivity {

    TextView retrofit_gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        retrofit_gson = (TextView) findViewById(R.id.retrofit_gson);


        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.boredapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serverApi serverApi = retrofit.create(serverApi.class);
        Call<pojo> messages = serverApi.messages();


        messages.enqueue(new Callback<pojo>() {
            @Override
            public void onResponse(Call<pojo> call, Response<pojo> response) {
                retrofit_gson.setText(response.body().getActivity());
            }

            @Override
            public void onFailure(Call<pojo> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_net, menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.maim_menu:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.exits_menu:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}