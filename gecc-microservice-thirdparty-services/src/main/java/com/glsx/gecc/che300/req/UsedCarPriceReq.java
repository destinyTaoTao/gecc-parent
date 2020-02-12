package com.glsx.gecc.che300.req;

import lombok.Data;

@Data
public class UsedCarPriceReq extends AbstractChe300Request {

    /**
     * 车300车型库车型 Id*
     */
    private Integer modelId;

    /**
     * 车300城市标识
     */
    private String zone;

    /**
     * 车辆上牌日期，如2012-01
     */
    private String regDate;

    /**
     * 车辆行驶里程，单位是万公里
     */
    private Double mile;

}
