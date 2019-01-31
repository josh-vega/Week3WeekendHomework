package com.example.week3weekendhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.week3weekendhomework.model.Constants.FORECAST_URL;
import static com.example.week3weekendhomework.model.Constants.FORECAST_URL2;
import static com.example.week3weekendhomework.model.Constants.WEATHER_URL;
import static com.example.week3weekendhomework.model.Constants.WEATHER_URL2;

public class MainActivity extends AppCompatActivity {
    Button btnNext;
    EditText etZip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
        etZip = findViewById(R.id.etZip);
    }

    public void onClick(View view) {
        String zip = etZip.getText().toString();
        String weather_url = WEATHER_URL + zip + WEATHER_URL2;
        String forecast_url = FORECAST_URL + zip + FORECAST_URL2;
        Bundle bundle = new Bundle();
        bundle.putString("weather", weather_url);
        bundle.putString("forecast", forecast_url);
        Intent intent = new Intent(this, WeatherDisplayActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
