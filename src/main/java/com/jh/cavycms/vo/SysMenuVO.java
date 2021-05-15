package com.jh.cavycms.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
public class SysMenuVO implements Serializable {
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

    private SysMenuVO children;
}
