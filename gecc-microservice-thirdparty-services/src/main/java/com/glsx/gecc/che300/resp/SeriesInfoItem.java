package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class SeriesInfoItem {

    @JSONField(name = "series_id")
    private Integer seriesId;

    @JSONField(name = "series_name")
    private String seriesName;

    @JSONField(name = "maker_type")
    private String makerType;

    @JSONField(name = "series_group_name")
    private String seriesGroupName;

    @JSONField(name = "update_time")
    private String updateTime;

    @JSONField(name = "series_pic")
    private String seriesPic;

    @JSONField(name = "maker_name")
    private String makerName;

    @JSONField(name = "maker_country")
    private String makerCountry;

}
