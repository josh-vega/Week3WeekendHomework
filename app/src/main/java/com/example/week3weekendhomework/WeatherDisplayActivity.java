package com.example.week3weekendhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WeatherDisplayActivity extends AppCompatActivity {
    TextView tvField1, tvField2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_display);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String weather = bundle.getString("weather");
        String forecast = bundle.getString("forecast");
        tvField1 = findViewById(R.id.tvField1);
        tvField2 = findViewById(R.id.tvField2);
        tvField1.setText(weather);
        tvField2.setText(forecast);
    }
}
