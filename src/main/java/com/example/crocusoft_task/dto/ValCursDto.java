package com.example.crocusoft_task.dto;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCursDto {

    @XmlElement(name = "ValType")
    private List<ValTypeDto> valTypes;

    public List<ValTypeDto> getValTypes() {
        return valTypes; }
}
