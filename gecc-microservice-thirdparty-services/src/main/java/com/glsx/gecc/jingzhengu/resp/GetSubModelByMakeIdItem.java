package com.glsx.gecc.jingzhengu.resp;

import lombok.Data;

@Data
public class GetSubModelByMakeIdItem {

    /**
     * 厂商名称
     */
    private String groupName;

    /**
     * 车系 id
     */
    private Integer value;

    /**
     * 车系名称
     */
    private String text;

}
