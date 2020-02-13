package com.glsx.vasp.modules.entity;

import com.glsx.vasp.system.entity.BaseSysUser;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "d_partner")
@ApiModel("合作商")
public class Partner extends BaseSysUser implements Serializable {

}
