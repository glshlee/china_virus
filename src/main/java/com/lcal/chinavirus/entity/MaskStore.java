package com.lcal.chinavirus.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MaskStore {

    @JsonProperty(value = "addr")
    private String address;
    private String code;
    private float lat;
    private float lng;
    private String name;
    private String type;    
}