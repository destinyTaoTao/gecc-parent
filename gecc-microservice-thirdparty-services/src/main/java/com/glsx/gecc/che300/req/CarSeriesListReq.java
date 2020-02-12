package com.glsx.gecc.che300.req;

import lombok.Data;

@Data
public class CarSeriesListReq extends AbstractChe300Request {

    /**
     * 品牌标识
     */
    private Integer brandId;

}
