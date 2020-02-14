package com.glsx.vasp.admin.modules.clue.model;

import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class ClueListExport extends BaseRowModel {

    /**
     * 线索编号
     */
    private String slSn;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 看车城市
     */
    private String cityName;

    /**
     * 商户名称
     */
    private String merchant;

    /**
     * 线索状态
     */
    private String status;

    /**
     * 留档时间
     */
    private String fileDate;

}
