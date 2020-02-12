package com.glsx.gecc.jingzhengu.resp;

import lombok.Data;

@Data
public class GetModelsItem {

    private Long modelId;
    private Integer heat;
    private String imgUrl;
    private String modelName;
    private String groupName;
    private String modelLevelName;

}
