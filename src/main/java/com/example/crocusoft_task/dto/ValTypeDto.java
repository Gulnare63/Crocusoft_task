package com.example.crocusoft_task.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;

import java.util.List;
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class ValTypeDto {

    @XmlAttribute(name = "Type")
    private String type;

    @XmlElement(name = "Valute")
    private List<ValuteDto> valutes;

}
