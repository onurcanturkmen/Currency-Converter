package com.perimamoglu.currencyconverter.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.perimamoglu.currencyconverter.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        CurrencyConverterFragment currencyConverterFragment = new CurrencyConverterFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_currency_converter_container,
                currencyConverterFragment, "").commit();
    }
}
