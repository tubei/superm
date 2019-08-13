package com.doraemon.data.enums;

/**
 * @author tubei
 */
public enum ResourceType implements Valueable {
  /**
   * 资源类型
   */
  MENU(0, "菜单"), ACTION(1, "操作");

  ResourceType(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  private int value;

  private String desc;

  @Override
  public int getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }
}
