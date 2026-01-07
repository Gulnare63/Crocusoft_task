package com.example.crocusoft_task.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class ValuteDto {

    @XmlAttribute(name = "Code")
    private String code;

    @XmlElement(name = "Nominal")
    private Integer nominal;

    @XmlElement(name = "Value")
    private BigDecimal value;


}
