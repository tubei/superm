package com.doraemon.data.enums;

/**
 * @author wl
 */

public enum UserState implements Valueable {
  /**
   * 用户状态
   */
  ACTIVE(0, "正常"), DISABLE(1, "禁用");

  private int value;
  private String desc;

  UserState(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @Override
  public int getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }
}