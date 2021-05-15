package com.jh.cavycms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 用户表
 */
@ApiModel(value = "com-jh-cavycms-domain-SysUser")
@Data
@ToString
public class SysUser {
    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "")
    private String name;

    @ApiModelProperty(value = "")
    private Integer age;

    @ApiModelProperty(value = "")
    private String address;

    @ApiModelProperty(value = "")
    private String job;

    @ApiModelProperty(value = "")
    private String creator;

    @ApiModelProperty(value = "")
    private Date createDate;

    @ApiModelProperty(value = "")
    private String lastModify;

    @ApiModelProperty(value = "")
    private Date lastModifyDate;

    @ApiModelProperty(value = "")
    private String passWord;
}