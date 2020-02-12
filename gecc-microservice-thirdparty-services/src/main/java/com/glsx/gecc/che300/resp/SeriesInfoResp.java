package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class SeriesInfoResp extends AbstractChe300Response {

    @JSONField(name = "series_info")
    private SeriesInfoItem seriesInfo;

}
