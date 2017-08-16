package com.perimamoglu.currencyconverter.adapters;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.perimamoglu.currencyconverter.R;
import com.perimamoglu.currencyconverter.interfaces.CustomItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by perihanimamoglu on 16/08/2017.
 */

public class RvCurrencyTypesAdapter extends RecyclerView.Adapter<RvCurrencyTypesAdapter.CurrencyTypesViewHolder> {

    private ArrayList<Float> currencyValue = new ArrayList<>();
    private ArrayList<String> currencyType = new ArrayList<>();
    private ArrayList<String> flags = new ArrayList<>();
    private CustomItemClickListener listener;

    public RvCurrencyTypesAdapter(ArrayList<Float> currencyValue, ArrayList<String> currencyType, ArrayList<String> flags, CustomItemClickListener listener) {
        this.currencyValue = currencyValue;
        this.currencyType = currencyType;
        this.flags = flags;
        this.listener = listener;
    }

    @Override
    public CurrencyTypesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_currency_type, parent, false);
        final CurrencyTypesViewHolder viewHolder = new CurrencyTypesViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CurrencyTypesViewHolder holder, final int position) {

        holder.txtCountry.setText(currencyType.get(position).toString());
        holder.txtBuying.setText(currencyValue.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return currencyValue.size();
    }

    public class CurrencyTypesViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imgItemFlag)ImageView imgItemFlag;
        @BindView(R.id.txtCountry)TextView txtCountry;
        @BindView(R.id.txtBuying)TextView txtBuying;

        public CurrencyTypesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
