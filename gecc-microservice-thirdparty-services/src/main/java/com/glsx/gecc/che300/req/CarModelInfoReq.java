package com.glsx.gecc.che300.req;

import lombok.Data;

@Data
public class CarModelInfoReq extends AbstractChe300Request {

    /**
     * 车型标识
     */
    private Integer modelId;

}
