package com.doraemon.biz.vo;

import lombok.Data;

import java.util.List;

/**
 * @author tubei
 */
@Data
public class UserVO {

  private Integer id;

  private String name;

  private List<RoleVO> roles;

  private List<String> permissions;

}
