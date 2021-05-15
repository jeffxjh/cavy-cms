package com.jh.cavycms.vo;

import lombok.Data;

/**
 * 用户扩展实体
 * @author 王俊南
 * Date: 2020-12-29
 */
@Data
public class UserVO {
	private String name;
	private String passWord;
	private String vcode;
	private boolean rememberMe;
}
