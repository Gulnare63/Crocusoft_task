package com.example.crocusoft_task.service.impl;

import com.example.crocusoft_task.dto.ValCursDto;
import com.example.crocusoft_task.enums.CurrencyCode;
import com.example.crocusoft_task.exception.ApiException;
import com.example.crocusoft_task.service.CurrencyService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final RestTemplate restTemplate;

    public CurrencyServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Map<CurrencyCode, BigDecimal> getRatesByEnum(String date, List<CurrencyCode> codes) {
        String url = "https://www.cbar.az/currencies/" + date + ".xml";

        try {

            ValCursDto valCurs = restTemplate.getForObject(url, ValCursDto.class);
            if (valCurs == null) {
                throw new ApiException("CBAR returned null for date: " + date);
            }

            Map<CurrencyCode, BigDecimal> rates = new HashMap<>();


            valCurs.getValTypes().stream()
                    .filter(valType ->
                            valType.getType().equalsIgnoreCase("Xarici valyutalar") ||
                                    valType.getType().equalsIgnoreCase("Bank metalları"))
                    .flatMap(valType -> valType.getValutes().stream())
                    .forEach(v -> {
                        try {
                            CurrencyCode code = CurrencyCode.valueOf(v.getCode());
                            if (codes.contains(code)) {
                                BigDecimal rate = v.getValue()
                                        .divide(new BigDecimal(v.getNominal()), 6, BigDecimal.ROUND_HALF_UP);
                                rates.put(code, rate);
                            }
                        } catch (IllegalArgumentException ignored) {

                        }
                    });


            return rates;

        } catch (RestClientException e) {

            throw new ApiException("CBAR API call failed: " + e.getMessage());
        }
    }
}
