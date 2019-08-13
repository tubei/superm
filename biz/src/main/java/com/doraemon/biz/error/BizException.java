package com.doraemon.biz.error;

/**
 * @author tubei
 */
public class BizException extends RuntimeException {

  private ErrorEnum error;

  public BizException(ErrorEnum error) {
    this.error = error;
  }

  public static BizException error(ErrorEnum error) {
    return new BizException(error);
  }

  public ErrorEnum getError() {
    return error;
  }
}
