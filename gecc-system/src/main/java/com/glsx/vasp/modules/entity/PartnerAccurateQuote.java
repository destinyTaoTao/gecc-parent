package com.glsx.vasp.modules.entity;

import com.glsx.vasp.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 合作商/商户 精准报价
 */
@Accessors(chain = true)
@Data
@Entity
@Table(name = "d_partner_accurate_quote")
@ApiModel("合作商")
public class PartnerAccurateQuote extends BaseEntity {

    /**
     * 融资期限
     */
    @Column(name = "financing_period")
    private Integer financingPeriod;

    /**
     * 月供金额
     */
    @Column(name = "monthly_payment")
    private BigDecimal monthlyPayment;

    /**
     * 尾款金额
     */
    private BigDecimal balance;

    /**
     * 尾款分期期数
     */
    @Column(name = "balance_period")
    private Integer balancePeriod;

    /**
     * 尾款分期金额
     */
    @Column(name = "balance_period_money")
    private BigDecimal balancePeriodMoney;

    /**
     * 估价
     */
    private BigDecimal valuation;

    /**
     * 服务费
     */
    @Column(name = "service_fee")
    private BigDecimal serviceFee;

    /**
     * 报价时间 createTime
     */

}
