package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class CarSeriesListItem {

    /**
     * 车系ID
     */
    @JSONField(name = "series_id")
    private Integer seriesId;

    /**
     * 车系名称
     */
    @JSONField(name = "series_name")
    private String seriesName;

    /**
     * 车系组名
     */
    @JSONField(name = "series_group_name")
    private String seriesGroupName;

    /**
     * 更新时间
     */
    @JSONField(name = "update_time")
    private Date updateTime;

}
