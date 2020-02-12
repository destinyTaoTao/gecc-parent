package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CarModelListItem {

    /**
     * 车型ID
     */
    @JSONField(name = "model_id")
    private Integer modelId;

    /**
     * 车型名称
     */
    @JSONField(name = "model_name")
    private String modelName;

    /**
     * 车型名称
     */
    @JSONField(name = "short_name")
    private String shortName;

    /**
     * 指导价
     */
    @JSONField(name = "model_price")
    private BigDecimal modelPrice;

    /**
     * 年款
     */
    @JSONField(name = "model_year")
    private String modelYear;

    /**
     * 最小上牌年份
     */
    @JSONField(name = "min_reg_year")
    private String minRegYear;

    /**
     * 最大上牌年份
     */
    @JSONField(name = "max_reg_year")
    private String maxRegYear;

    /**
     * 排量
     */
    @JSONField(name = "liter")
    private String liter;

    /**
     * 变速箱
     */
    @JSONField(name = "gear_type")
    private String gearType;

    /**
     * 排放标准
     */
    @JSONField(name = "discharge_standard")
    private String dischargeStandard;

    /**
     * 座位数
     */
    @JSONField(name = "seat_number")
    private Integer seatNumber;

    /**
     * 更新时间
     */
    @JSONField(name = "update_time")
    private Date updateTime;

}
