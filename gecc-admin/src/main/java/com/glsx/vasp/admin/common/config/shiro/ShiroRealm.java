package com.glsx.vasp.admin.common.config.shiro;

import com.glsx.vasp.admin.modules.user.service.UserService;
import com.glsx.vasp.enums.SysConstants;
import com.glsx.vasp.system.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 自动生成的方法存根
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        String username = upToken.getUsername();
        //String password = new String((char[]) token.getCredentials());
        SysUser user = userService.findByUsername(username);

        if (null == user)
            throw new UnknownAccountException();

        if (SysConstants.EnableStatus.enable.getCode() != user.getEnableStatus())
            throw new LockedAccountException();

        //int errCount = NumberUtils.toInt(Strings.sNull(SecurityUtils.getSubject().getSession(true).getAttribute("errCount")));

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getSalt()),//salt
                getName()  //realm name
        );
        return authenticationInfo;
    }


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        // TODO 自动生成的方法存根
        //改掉null
        //查询数据库获取角色和权限信息
        //SimpleAuthorizationInfo a = new SimpleAuthorizationInfo();
//		a.setRoles(roles);
        return null;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        String credentials = "123456";
        int hashIterations = 2;
        ByteSource credentialsSalt = ByteSource.Util.bytes("21gn");
        SimpleHash obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        System.out.println(obj.toString());
    }

}
