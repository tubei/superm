package com.doraemon.api.config.shiro;

import com.doraemon.api.vo.ApiResult;
import com.doraemon.common.util.JSON;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author tubei
 */
public class RestUserFilter extends UserFilter {
  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    response401(httpServletResponse);
    return false;
  }

  private void response401(HttpServletResponse response) throws IOException {
    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    try (PrintWriter writer = response.getWriter()) {
      writer.write(JSON.toJson(ApiResult.unauthorized()));
    }
  }
}
