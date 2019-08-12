package com.doraemon.api.config;

import com.doraemon.api.vo.ApiResult;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author tubei
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(AuthorizationException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  @ResponseBody
  public ApiResult<?> handleAuthorizationException(AuthorizationException e){
    return ApiResult.forbidden();
  }
}
