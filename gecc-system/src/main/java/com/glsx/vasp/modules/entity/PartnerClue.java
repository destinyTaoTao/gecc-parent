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

    @Column(name = "partner_id")
    private Long partnerId;

    @Column(name = "clue_id")
    private Long clueId;

}
