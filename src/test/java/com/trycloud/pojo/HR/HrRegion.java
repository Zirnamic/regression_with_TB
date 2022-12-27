package com.trycloud.pojo.HR;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class HrRegion {

    @JsonProperty("region_id")
    private int regionID;

    @JsonProperty("region_name")
    private String regionName;
    private List<HrLink> links;


}
