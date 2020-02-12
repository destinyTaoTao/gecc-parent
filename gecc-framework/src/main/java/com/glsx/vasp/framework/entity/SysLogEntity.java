package com.glsx.vasp.framework.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * todo 系统日志,不采用表来存储  后面改存储在 mongodb
 */
@Data
@Entity
@Table(name = "d_log")
public class SysLogEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    // 模块功能
    @Column(name = "modul")
    private String modul;

    // 操作人
    @Column(name = "operator", length = 10)
    private Long operator;

    // 请求参数
    @Column(name = "request_data", length = 512)
    private String requestData;

    /**
     * ip地址
     */
    @Column(name = "ip", length = 46)
    private String ip;

    // 创建时间
    @Column(name = "create_time", length = 19)
    private Date createTime;

}
