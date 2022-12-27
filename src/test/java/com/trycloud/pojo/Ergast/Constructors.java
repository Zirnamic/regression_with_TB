package com.trycloud.pojo.Ergast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Constructors {

    private String constructorId;
    private String name;
    private String nationality;


}
