package com.doraemon.biz.error;

/**
 * @author tubei
 */
public enum ErrorEnum {

  /**
   * 业务异常定义
   */
  SYSTEM_ERROR(10000, "系统异常"),

  USER_NOT_EXISTS(10010, "用户不存在"),
  USER_IS_DISABLED(10011, "帐号被禁用"),
  INCORRECT_PASSWORD(10011, "密码错误");


  private int code;

  private String msg;

  ErrorEnum(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
