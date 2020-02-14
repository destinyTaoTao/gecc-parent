package com.glsx.vasp.modules.entity;

import com.glsx.vasp.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "d_partner_clue")
@ApiModel("合作商-线索关系表")
public class PartnerClue extends BaseEntity {

    @Column(name = "clue_id")
    private Long clueId;

    /**
     * 合作方id，后端系统 运营分配线索给合作商时候赋值
     */
    @Column(name = "partner_id")
    private Long partnerId;

    /**
     * 合作商/商户 用户id，合作商用户登录跟进的账号id
     */
    @Column(name = "partner_user_id")
    private Long partnerUserId;

    /**
     * 合作商精准报价，合作商用户跟进线索的精准报价
     */
    @Column(name = "partner_quote_id")
    private Long partnerQuoteId;

}
