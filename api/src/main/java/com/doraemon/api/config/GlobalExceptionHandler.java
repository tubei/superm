package com.doraemon.api.config;

import com.doraemon.api.vo.ApiResult;
import com.doraemon.biz.error.BizException;
import com.doraemon.biz.error.ErrorEnum;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
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
  public ApiResult<?> handleAuthorizationException(AuthorizationException e) {
    return ApiResult.forbidden();
  }

  @ExceptionHandler(AuthenticationException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ResponseBody
  public ApiResult<?> handleAuthenticationException(AuthenticationException e) {
    Throwable cause = e.getCause();
    if (cause instanceof BizException) {
      ErrorEnum error = ((BizException) cause).getError();
      return ApiResult.error(error);
    }
    if (e instanceof IncorrectCredentialsException) {
      return ApiResult.error(ErrorEnum.INCORRECT_PASSWORD);
    }
    return ApiResult.unauthorized();
  }
}
