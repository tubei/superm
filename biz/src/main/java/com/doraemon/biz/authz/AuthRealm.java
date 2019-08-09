package com.doraemon.biz.authz;

import com.doraemon.dal.impl.UserDAO;
import com.doraemon.data.enums.UserState;
import com.doraemon.data.gen.tables.pojos.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author tubei
 */
@Component
public class AuthRealm extends AuthenticatingRealm {

  private final UserDAO userDAO;

  public AuthRealm(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
    User user = userDAO.fetchByUsername(usernamePasswordToken.getUsername());
    if (user == null) {
      throw new UnknownAccountException();
    }
    if (UserState.isDisable(user.getState())) {
      throw new DisabledAccountException();
    }

    return new SimpleAuthenticationInfo();
  }

  @Override
  public boolean supports(AuthenticationToken token) {
    return token instanceof UsernamePasswordToken;
  }
}
