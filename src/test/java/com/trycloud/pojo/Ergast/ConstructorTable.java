package com.trycloud.pojo.Ergast;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ConstructorTable {
    private  String constructorStandings;

    @JsonProperty("Constructors")
    private List<Constructors> constructors;




}
