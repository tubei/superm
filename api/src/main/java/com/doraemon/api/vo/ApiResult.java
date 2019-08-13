package com.doraemon.api.vo;

import com.doraemon.biz.error.ErrorEnum;
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

  public ApiResult(T data) {
    this.code = 0;
    this.message = DEFAULT_SUCCESS_MSG;
    this.data = data;
  }

  @SuppressWarnings("unchecked")
  public static ApiResult ok() {
    return new ApiResult(0, DEFAULT_SUCCESS_MSG, null);
  }

  public static ApiResult<?> unauthorized() {
    return new ApiResult<>(401, "UNAUTHORIZED", null);
  }

  public static ApiResult<?> forbidden() {
    return new ApiResult<>(403, "FORBIDDEN", null);
  }

  public static ApiResult<?> error(ErrorEnum error) {
    return new ApiResult<>(error.getCode(), error.getMsg(), null);
  }
}
