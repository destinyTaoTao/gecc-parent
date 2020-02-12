package com.glsx.gecc.jingzhengu.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetStyleColorByStyleIdItem {

    private String neishiColor;
    private List<NeishiColorInfo> neishiColorInfo;
    private List<StyleColorInfo> styleColorInfo;
    private String[] styleColor;

}
