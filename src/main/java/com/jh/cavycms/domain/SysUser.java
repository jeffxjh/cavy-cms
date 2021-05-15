package com.jh.cavycms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 */
@ApiModel(value = "com-jh-cavycms-domain-SysUser")
@Data
public class SysUser {
    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "")
    private String account;

    @ApiModelProperty(value = "")
    private String name;

    @ApiModelProperty(value = "")
    private String passWord;

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
    private String updateBy;

    @ApiModelProperty(value = "")
    private Date updateDate;
}