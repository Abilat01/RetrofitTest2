package com.abilat.layouttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onActivityTwo(View view) {
        Intent intent = new Intent(this, Play.class);
        startActivity(intent);
    }

    public void onActivityThree(View view) {
        Intent intent1 = new Intent(this, PlayTwo.class);
        startActivity(intent1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.http_1:
                Intent intent = new Intent(this, Play.class);
                startActivity(intent);
                break;
            case R.id.http_2:
                Intent intent1 = new Intent(this, PlayTwo.class);
                startActivity(intent1);
                break;
            case R.id.sponsors:
                Intent intent2 = new Intent(this, sponsor.class);
                startActivity(intent2);
                break;
            case R.id.exits:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}