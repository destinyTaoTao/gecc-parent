/**
 * Copyright (C), 2015-2018, 广联赛讯有限公司
 * FileName: UnifiedOrderModel
 * Author:   liuyf
 * Date:     2018/5/17 13:59
 * Description: 微信支付预订单Modle
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.glsx.vasp.weixin.modules.model;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈微信支付预订单Model〉
 *
 * @author liuyf
 * @create 2018/5/17
 * @since 1.0.0
 */
@Data
public class UnifiedOrderModel {

    private Integer type;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 购物名称
     */
    private String body;

    /**
     * 购物金额，单位分
     */
    private Integer totalFee;

    /**
     * 支付成功回调url，不由前端传，后端控制
     */
    private String notifyUrl;

}