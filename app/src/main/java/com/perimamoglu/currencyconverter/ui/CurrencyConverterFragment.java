package com.perimamoglu.currencyconverter.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.perimamoglu.currencyconverter.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyConverterFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.edtAmount)EditText edtAmount;
    @BindView(R.id.btnCurrencyType)Button btnCurrencyType;
    @BindView(R.id.imgFlag)ImageView imgFlag;
    @BindView(R.id.txtCalculated)TextView txtCalculated;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_currency_converter, container, false);
        ButterKnife.bind(this, view);
        btnCurrencyType.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        CurrencyTypesFragment currencyTypesFragment = new CurrencyTypesFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_currency_types_container, currencyTypesFragment).commit();
    }
}
