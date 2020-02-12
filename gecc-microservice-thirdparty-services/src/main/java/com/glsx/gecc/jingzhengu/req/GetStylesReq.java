package com.glsx.gecc.jingzhengu.req;

import lombok.Data;

@Data
public class GetStylesReq extends AbstractJingzhenguRequest {

    private Long modelId;
    private Integer year;
    private Integer vehicleClassification;
    private Integer produceStatus;
    private Integer includeElectrombile;

}
