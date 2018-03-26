package cn.edu.gdin.realm;

import cn.edu.gdin.po.Role;
import cn.edu.gdin.po.User;
import cn.edu.gdin.service.RoleService;
import cn.edu.gdin.service.UserService;
import cn.edu.gdin.util.MD5;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Component
public class LoginRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息
     *     当调用权限验证时，就会调用此方法
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String  userAccount = (String) getAvailablePrincipal(principalCollection);

        User user = userService.loadUser(userAccount);
        Role role = roleService.findByUserAccount(userAccount);



        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roleSet = new HashSet<String>();
        if(role!=null){
            System.out.println(role.getRoleName());
            roleSet.add(role.getRoleName());
            info.setRoles(roleSet);
        }
        return info;
    }

    /**
     * 在这个方法中，进行身份验证
     *         login时调用
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userAccount = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        User user = userService.loadUser(userAccount);
        if (user == null) {
            //没有该用户名
            throw new UnknownAccountException();
        } else {
            try {
                if (!MD5.getMD5(password).equals(user.getPassword())) {
                    //密码错误
                    throw new IncorrectCredentialsException();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        AuthenticationInfo info = new SimpleAuthenticationInfo(userAccount,password,getName());

        return info;
    }
}
