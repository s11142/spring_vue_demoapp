package com.kuds.demoapp.controller;

import com.kuds.demoapp.domain.Currency;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Builder
public class CurrencyResponse {

    private List<Currency> currencies;

    @Autowired
    public CurrencyResponse(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
