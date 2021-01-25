package com.kuds.demoapp.controller;

import com.kuds.demoapp.domain.Currency;
import com.kuds.demoapp.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vue-test")
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public ResponseEntity<CurrencyResponse> findAll() {
        List<Currency> currencies = currencyService.findAll();
        CurrencyResponse currencyResponse = new CurrencyResponse(currencies);
        return new ResponseEntity<>(currencyResponse, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<HttpStatus> save(@RequestBody CurrencyAddRequest request) {
        currencyService.save(request.getName(), request.getSymbol());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        currencyService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
