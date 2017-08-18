package com.perimamoglu.currencyconverter.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.perimamoglu.currencyconverter.R;
import com.perimamoglu.currencyconverter.services.NewAddBusService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyConverterFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.edtAmount)EditText edtAmount;
    @BindView(R.id.btnCurrencyType)Button btnCurrencyType;
    @BindView(R.id.imgFlag)ImageView imgFlag;
    @BindView(R.id.txtCalculated)TextView txtCalculated;
    View view;
    public Float currencyValue;
    public String currencyType;

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
        init();
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

    private void init() {
    }

    @Override
    public void onClick(View view) {
        CurrencyTypesFragment currencyTypesFragment = new CurrencyTypesFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_currency_types_container, currencyTypesFragment).commit();
    }

    @Subscribe(threadMode = ThreadMode.MAIN , sticky = true)
    public void onMessageEvent(NewAddBusService event) {
        if (event.exception == null) {
            currencyValue = event.currencyValue;
            currencyType = event.currencyType;

            if (currencyType.equals("AUD")){
                imgFlag.setImageDrawable(getResources().getDrawable(R.drawable.aud));
            }else if (currencyType.equals("BGN")) {
                imgFlag.setImageDrawable(getResources().getDrawable(R.drawable.aud));
            }

            String tl = edtAmount.getText().toString();
            float amount = Float.parseFloat(tl);
            Float converter = amount*currencyValue;

            txtCalculated.setText(converter.toString());
            Toast.makeText(getContext(),converter.toString(), Toast.LENGTH_LONG).show();

        }
    }
}
