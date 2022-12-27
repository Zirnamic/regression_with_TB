package com.trycloud.pojo.Ergast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MRDatas {

    private int limit;
    private int total;


    @JsonProperty("ConstructorTable")
    private ConstructorTable constructorTable;


}
