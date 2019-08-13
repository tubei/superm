package com.doraemon.biz.authz;

import com.doraemon.biz.error.BizException;
import com.doraemon.common.crypto.BCrypt;
import com.doraemon.dal.impl.UserDAO;
import com.doraemon.data.enums.UserState;
import com.doraemon.data.gen.tables.pojos.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.stereotype.Component;

import static com.doraemon.biz.error.ErrorEnum.USER_IS_DISABLED;
import static com.doraemon.biz.error.ErrorEnum.USER_NOT_EXISTS;

/**
 * @author tubei
 */
@Component
public class PasswordAuthRealm extends AuthenticatingRealm {

  private final UserDAO userDAO;

  public PasswordAuthRealm(UserDAO userDAO) {
    this.userDAO = userDAO;
    setCredentialsMatcher((token, info) -> {
      UsernamePasswordToken userToken = (UsernamePasswordToken) token;
      char[] rawPassword = userToken.getPassword();
      String encryptedPassword = info.getCredentials().toString();
      return BCrypt.checkpw(String.valueOf(rawPassword), encryptedPassword);
    });
  }

  @Override
  public CredentialsMatcher getCredentialsMatcher() {
    return super.getCredentialsMatcher();
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
    User user = userDAO.fetchByUsername(usernamePasswordToken.getUsername());
    if (user == null) {
      throw new UnknownAccountException(BizException.error(USER_NOT_EXISTS));
    }
    if (UserState.isDisable(user.getState())) {
      throw new DisabledAccountException(BizException.error(USER_IS_DISABLED));
    }
    return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
  }

  @Override
  public boolean supports(AuthenticationToken token) {
    return token instanceof UsernamePasswordToken;
  }
}
