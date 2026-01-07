package com.example.crocusoft_task.dto;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ValTypeDto {

    @XmlAttribute(name = "Type")
    private String type;

    @XmlElement(name = "Valute")
    private List<ValuteDto> valutes;

    public String getType() {
        return type; }
    public List<ValuteDto> getValutes() {
        return valutes; }
}
