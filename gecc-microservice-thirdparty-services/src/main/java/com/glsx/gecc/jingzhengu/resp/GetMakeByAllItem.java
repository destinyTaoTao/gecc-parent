package com.glsx.gecc.jingzhengu.resp;

import lombok.Data;

@Data
public class GetMakeByAllItem {

    /**
     * 品牌 Id
     */
    private Long makeId;

    /**
     * 品牌图片地址
     */
    private String imgUrl;

    /**
     * 品牌首字母
     */
    private String groupName;

    /**
     * 品牌名称
     */
    private String makeName;

}
