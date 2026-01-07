package com.example.crocusoft_task.controller;

import com.example.crocusoft_task.enums.CurrencyCode;
import com.example.crocusoft_task.service.CurrencyService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/{date}")
    public Map<CurrencyCode, BigDecimal> getRates(
            @PathVariable String date,
            @RequestParam List<CurrencyCode> codes
    ) {
        return currencyService.getRatesByEnum(date, codes);
    }
}
