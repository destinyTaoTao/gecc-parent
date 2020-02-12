package com.glsx.gecc.jingzhengu.resp;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetStylesItem {

    private Long styleId;
    private String styleYear;
    private BigDecimal msrp;
    private String styleFullName;
    private String nextYear;
    private String displacement;
    private String styleName;
    private String gearBox;

}
