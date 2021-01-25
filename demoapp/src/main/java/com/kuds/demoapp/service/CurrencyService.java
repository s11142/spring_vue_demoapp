package com.kuds.demoapp.service;

import com.kuds.demoapp.domain.Currency;
import com.kuds.demoapp.domain.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    public Currency save(String name, String symbol) {
        return currencyRepository.save(Currency.newCurrency(name, symbol));
    }

    public void delete(Long id) {
        currencyRepository.findById(id).ifPresent(currency -> currencyRepository.delete(currency));
    }

}
