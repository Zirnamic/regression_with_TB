package com.trycloud.pojo.Ergast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drivers {


    private String driverId;
    private int permanentNumber;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;


}
