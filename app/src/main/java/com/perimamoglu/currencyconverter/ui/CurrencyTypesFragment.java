package com.perimamoglu.currencyconverter.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.perimamoglu.currencyconverter.R;
import com.perimamoglu.currencyconverter.adapters.RvCurrencyTypesAdapter;
import com.perimamoglu.currencyconverter.interfaces.CustomItemClickListener;
import com.perimamoglu.currencyconverter.model.Currency;
import com.perimamoglu.currencyconverter.network.NetworkModule;
import com.perimamoglu.currencyconverter.services.NewAddBusService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyTypesFragment extends Fragment {

    @BindView(R.id.rvList)RecyclerView rvList;
    View view;
    private ArrayList<Float> currencyValue;
    int positionNew;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_currency_types, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvList.setLayoutManager(layoutManager);

        currencyValue = new ArrayList<>();
        NetworkModule.getInstance().getCurrency("TRY").enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                currencyValue.add(response.body().rates.AUD);
                currencyValue.add(response.body().rates.BGN);
                currencyValue.add(response.body().rates.BRL);
                currencyValue.add(response.body().rates.CAD);
                currencyValue.add(response.body().rates.CHF);
                currencyValue.add(response.body().rates.CNY);
                currencyValue.add(response.body().rates.CZK);
                currencyValue.add(response.body().rates.DKK);
                currencyValue.add(response.body().rates.EUR);
                currencyValue.add(response.body().rates.GBP);
                currencyValue.add(response.body().rates.HUF);
                currencyValue.add(response.body().rates.INR);
                currencyValue.add(response.body().rates.JPY);
                currencyValue.add(response.body().rates.KRW);
                currencyValue.add(response.body().rates.MXN);
                currencyValue.add(response.body().rates.MYR);
                currencyValue.add(response.body().rates.NOK);
                currencyValue.add(response.body().rates.NZD);
                currencyValue.add(response.body().rates.PHP);
                currencyValue.add(response.body().rates.PLN);
                currencyValue.add(response.body().rates.RON);
                currencyValue.add(response.body().rates.RUB);
                currencyValue.add(response.body().rates.SEK);
                currencyValue.add(response.body().rates.SGD);
                currencyValue.add(response.body().rates.THB);
                currencyValue.add(response.body().rates.USD);
                currencyValue.add(response.body().rates.ZAR);

                final ArrayList<String> currencyType = new ArrayList<>();
                currencyType.add("AUD");
                currencyType.add("BGN");
                currencyType.add("BRL");
                currencyType.add("CAD");
                currencyType.add("CHF");
                currencyType.add("CNY");
                currencyType.add("CZK");
                currencyType.add("DKK");
                currencyType.add("EUR");
                currencyType.add("GBP");
                currencyType.add("HUF");
                currencyType.add("INR");
                currencyType.add("JPY");
                currencyType.add("KRW");
                currencyType.add("MXN");
                currencyType.add("MYR");
                currencyType.add("NOK");
                currencyType.add("NZD");
                currencyType.add("PHP");
                currencyType.add("PLN");
                currencyType.add("RON");
                currencyType.add("RUB");
                currencyType.add("SEK");
                currencyType.add("SGD");
                currencyType.add("THB");
                currencyType.add("USD");
                currencyType.add("ZAR");

                RvCurrencyTypesAdapter rvCurrencyTypesAdapter = new RvCurrencyTypesAdapter(getContext(),currencyValue, currencyType, new CustomItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        CurrencyConverterFragment f = new CurrencyConverterFragment();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_currency_converter_container, f).commit();
                        Log.d("position", "Tıklanan pozisyon:" + position);

                        EventBus.getDefault().postSticky(new NewAddBusService(null, currencyValue.get(position), currencyType.get(position)));

                    }
                });

                rvList.setHasFixedSize(true);
                rvList.setAdapter(rvCurrencyTypesAdapter);
                rvList.setItemAnimator(new DefaultItemAnimator());


            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {

            }
        });
    }
}
