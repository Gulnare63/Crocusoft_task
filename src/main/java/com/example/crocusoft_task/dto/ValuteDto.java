package com.example.crocusoft_task.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.math.BigDecimal;


@XmlAccessorType(XmlAccessType.FIELD)
public class ValuteDto {

    @XmlAttribute(name = "Code")
    private String code;

    @XmlElement(name = "Nominal")
    private Integer nominal;

    @XmlElement(name = "Value")
    private BigDecimal value;

    public String getCode() { return code; }
    public Integer getNominal() { return nominal; }
    public BigDecimal getValue() { return value; }
}
