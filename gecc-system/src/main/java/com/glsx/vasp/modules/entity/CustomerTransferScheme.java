package com.glsx.vasp.modules.entity;

import com.glsx.vasp.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "d_customer_transfer_scheme")
@ApiModel("客户换车方案表")
public class CustomerTransferScheme extends BaseEntity {

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
    @Column(name = "balance")
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

}
