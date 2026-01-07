package com.example.crocusoft_task.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;

import java.util.List;
@Getter
@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCursDto {

    @XmlElement(name = "ValType")
    private List<ValTypeDto> valTypes;


}
