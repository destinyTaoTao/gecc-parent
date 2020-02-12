package com.glsx.gecc.jingzhengu.req;

import lombok.Data;

@Data
public class GetMakeByAllReq extends AbstractJingzhenguRequest {

    /**
     * 车辆类别:0 所有；1 乘用车
     */
    private Integer vehicleClassification;

    /**
     * 销售状态： 0 所有；1 在销 不传查所有
     */
    private Integer produceStatus;

    /**
     * 是否可估值：isEstimate（0 所有；1:可估值的品牌）（可选）
     */
    private Integer isEstimate;

    /**
     * 是否包含电动车：includeElectrombile(0:不包含电动车；1:包含电动车)（可选）
     */
    private Integer includeElectrombile;

}
