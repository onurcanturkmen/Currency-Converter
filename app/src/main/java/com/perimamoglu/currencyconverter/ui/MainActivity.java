package com.perimamoglu.currencyconverter.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.perimamoglu.currencyconverter.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.edtAmount)EditText edtAmount;
    @BindView(R.id.edtCurrencyType)EditText edtCurrencyType;
    @BindView(R.id.imgFlag)EditText imgFlag;
    @BindView(R.id.txtBuying)EditText txtBuying;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }
}
