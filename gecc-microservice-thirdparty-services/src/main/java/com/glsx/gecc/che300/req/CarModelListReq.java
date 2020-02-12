package com.glsx.gecc.che300.req;

import lombok.Data;

@Data
public class CarModelListReq extends AbstractChe300Request {

    /**
     * 车系标识
     */
    private Integer seriesId;

}
