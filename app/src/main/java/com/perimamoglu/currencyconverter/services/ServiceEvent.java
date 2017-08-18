package com.perimamoglu.currencyconverter.services;

/**
 * Created by perihanimamoglu on 17/08/2017.
 */

public class ServiceEvent {
    public final Exception exception;

    public ServiceEvent(Exception exception) {
        this.exception = exception;
    }
}
