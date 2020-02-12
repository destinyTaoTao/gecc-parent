package com.glsx.gecc.jingzhengu.req;

import lombok.Data;

@Data
public class GetModelsReq extends AbstractJingzhenguRequest {


    /**
     * 品牌 ID：makeId（必填）
     */
    private Long makeId;

    /**
     * 年份：year（可选）
     */
    private Integer year;

    /**
     * 车辆类别：vehicleClassification（可选）0 所有；1 乘用车
     */
    private Integer vehicleClassification;

    /**
     * 销售状态：produceStatus（可选）产销状态 0 所有；1 在销 不传查所有
     */
    private Integer produceStatus;

    /**
     * 是否可估值：isEstimate（可选）是否可估值（0 所有 1 是）
     */
    private Integer isEstimate;

    /**
     * 是否包含电动车：includeElectrombile（可选）(0:不包含电动车；1:包含电动车)，不传和传 1 都是查所有
     */
    private Integer includeElectrombile;

}
