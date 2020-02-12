package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UsedCarPriceResp extends AbstractChe300Response {

    @JSONField(name = "eval_price")
    private BigDecimal evalPrice;

    @JSONField(name = "low_price")
    private BigDecimal lowPrice;

    @JSONField(name = "good_price")
    private BigDecimal goodPrice;

    @JSONField(name = "high_price")
    private BigDecimal highPrice;

    @JSONField(name = "dealer_buy_price")
    private BigDecimal dealerBuyPrice;

    @JSONField(name = "individual_price")
    private BigDecimal individualPrice;

    @JSONField(name = "dealer_price")
    private BigDecimal dealerPrice;

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "price")
    private BigDecimal price;

    @JSONField(name = "discharge_standard")
    private String dischargeStandard;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "car_logo_url")
    private String carLogoUrl;

}
