package com.example.crocusoft_task.service;

import com.example.crocusoft_task.enums.CurrencyCode;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CurrencyService {

    Map<CurrencyCode, BigDecimal> getRatesByEnum(String date, List<CurrencyCode> codes);

    BigDecimal getRateByEnum(String date, CurrencyCode code);
}
