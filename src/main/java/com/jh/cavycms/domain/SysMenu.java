package com.jh.cavycms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
    * 菜单表
    */
@ApiModel(value="com-jh-cavycms-domain-SysMenu")
@Data
public class SysMenu {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private String menuName;

    @ApiModelProperty(value="")
    private String menuCode;

    @ApiModelProperty(value="")
    private String menuUrl;

    @ApiModelProperty(value="")
    private Integer parentId;

    @ApiModelProperty(value="")
    private String menuIcon;

    @ApiModelProperty(value="")
    private Integer sort;

    @ApiModelProperty(value="")
    private Integer remark;

    @ApiModelProperty(value="")
    private String creator;

    @ApiModelProperty(value="")
    private Date createDate;

    @ApiModelProperty(value="")
    private String updateBy;

    @ApiModelProperty(value="")
    private Date updateDate;
}