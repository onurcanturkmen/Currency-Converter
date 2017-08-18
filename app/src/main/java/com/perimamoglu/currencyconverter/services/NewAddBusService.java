package com.perimamoglu.currencyconverter.services;

import java.util.ArrayList;

/**
 * Created by perihanimamoglu on 17/08/2017.
 */

public class NewAddBusService extends ServiceEvent {

    public Float currencyValue;
    public String currencyType;

    public NewAddBusService(Exception exception , Float currencyValue, String currencyType) {
        super(exception);
        this.currencyValue = currencyValue;
        this.currencyType = currencyType;
    }
}
