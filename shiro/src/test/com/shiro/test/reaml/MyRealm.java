package com.shiro.test.reaml;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by Administrator on 2017/7/1.
 */
public class MyRealm implements Realm {

    @Override
    public String getName() {
        return "myrealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        String password = new String((char[])authenticationToken.getCredentials()); //得到密码
        if (!StringUtils.equals("zhang",username)){
            throw new UnknownAccountException("用户名错误");
        }
        if (!StringUtils.equals("123",password)){
            throw new IncorrectCredentialsException("密码错误");
        }
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
