package com.doraemon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tubei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> {

  private int code;

  private String message;

  private T data;

  private static final String DEFAULT_SUCCESS_MSG = "success";

  @SuppressWarnings("unchecked")
  public static ApiResult ok() {
    return new ApiResult(0, DEFAULT_SUCCESS_MSG, null);
  }
}
