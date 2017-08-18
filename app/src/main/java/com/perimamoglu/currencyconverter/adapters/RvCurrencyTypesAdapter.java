package com.perimamoglu.currencyconverter.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.perimamoglu.currencyconverter.R;
import com.perimamoglu.currencyconverter.interfaces.CustomItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by perihanimamoglu on 16/08/2017.
 */

public class RvCurrencyTypesAdapter extends RecyclerView.Adapter<RvCurrencyTypesAdapter.CurrencyTypesViewHolder> {

    private ArrayList<Float> currencyValue = new ArrayList<>();
    private ArrayList<String> currencyType = new ArrayList<>();
    private CustomItemClickListener listener;
    Context context;

    public RvCurrencyTypesAdapter(Context context, ArrayList<Float> currencyValue, ArrayList<String> currencyType, CustomItemClickListener listener) {
        this.currencyValue = currencyValue;
        this.currencyType = currencyType;
        this.listener = listener;
        this.context = context;
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
        if (currencyType.get(position).toString().equals("AUD")){
            Picasso.with(context).load(R.drawable.aud).resize(120, 80).into(holder.imgItemFlag);
        }else if (currencyType.get(position).toString().equals("BGN")) {
            Picasso.with(context).load(R.drawable.bgn).resize(120, 80).into(holder.imgItemFlag);
        }
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
