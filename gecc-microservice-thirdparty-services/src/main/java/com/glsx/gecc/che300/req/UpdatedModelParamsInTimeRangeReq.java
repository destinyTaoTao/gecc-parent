package com.glsx.gecc.che300.req;

import lombok.Data;

@Data
public class UpdatedModelParamsInTimeRangeReq extends AbstractChe300Request {

    /**
     * 起始时间，格式为2019-02-02
     */
    private String fromTime;

    /**
     * 截止时间，格式为2019-02-03，如为空或未传递，则默认为当前时间。
     */
    private String toTime;

}
