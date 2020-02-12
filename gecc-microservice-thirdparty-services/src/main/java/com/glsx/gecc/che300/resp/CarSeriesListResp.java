package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class CarSeriesListResp extends AbstractChe300Response {

    @JSONField(name = "series_list")
    private List<CarSeriesListItem> seriesList;

}
