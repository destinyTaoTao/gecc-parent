package com.glsx.gecc.che300.req;

import lombok.Data;

@Data
public class ModelParametersReq extends AbstractChe300Request {

    /**
     * 车型标识
     */
    private Integer modelId;

    /**
     * 默认2
     */
    private Integer version;

    /**
     * 返回的键值类型,en:英文，zh:中文,不传默认中文
     */
    private String keyType;

}
