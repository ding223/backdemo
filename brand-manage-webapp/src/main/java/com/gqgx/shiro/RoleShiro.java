/**
 * 描述:<p></p>
 *
 * @Title: RoleShiro.java
 * @Package com.gqgx.domain
 * @author weihongjun
 * @date 2016年11月30日 下午3:22:28
 */


package com.gqgx.shiro;

import com.gqgx.common.entity.SysLoginLog;
import com.gqgx.common.entity.SysMenu;
import com.gqgx.common.entity.SysMenuOperation;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.lang.Strings;
import com.gqgx.common.lang.util.MD5Utils;
import com.gqgx.common.service.SysDepartmentService;
import com.gqgx.common.service.SysLoginLogService;
import com.gqgx.common.service.SysUserService;
import com.gqgx.common.springutils.Springs;
import com.gqgx.common.web.BrowserUtils;
import com.gqgx.common.web.IPAccessControler;
import com.gqgx.constant.Constant;
import com.gqgx.utils.SysUserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 描述:<p></p>
 * @ClassName: RoleShiro
 * @author weihongjun
 * @date 2016年11月30日 下午3:22:28
 *
 */
@Transactional
public class RoleShiro extends AuthorizingRealm {

    /**
     * <p>描述: 权限认证</p>
     * doGetAuthorizationInfo() 获得授权信息方法 不是主动调用的，而是去校验是否有某权限时才会去调用。
        例如，在 loginController 的方法里运行 subject.hasRole( str ) 或 subject.isPermitted( str )，
        就会进入 doGetAuthorizationInfo() ：
     * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取登录时输入的用户名
        /*String loginName = (String)principalCollection.fromRealm(getName()).iterator().next();*/
        // 到数据库查是否有此对象
        /*SysUser user = Springs.getBean(SysUserService.class).findUserByAccountName(loginName);*/
        Subject currentSession = SecurityUtils.getSubject();
        SysUser user = (SysUser) currentSession.getSession().getAttribute("subjectUser");
        if (user != null) {
            // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 用户的菜单集合
            List<SysMenu> positions = user.getSysMenus();
            if (!Objects.isEmpty(positions)) {
                Set<String> roles = new HashSet<>();
                for (int i = 0; i < positions.size(); i++) {
                    roles.add(positions.get(i).getCode());
                }
                info.setRoles(roles);
            }
            // 用户的角色对应的所有权限，如果只使用角色定义访问权限
            List<SysMenuOperation> roleList = user.getMenuOperations();
            if (!Objects.isEmpty(roleList)) {
                Set<String> permissions = new HashSet<>();
                for (SysMenuOperation role : roleList) {
                    permissions.add(role.getCode());
                }
                info.addStringPermissions(permissions);
            }
            return info;
        }
        //具体实现, 若不使用授权管理,可以返回null
        return null;
    }

    /**
     * <p>描述:登录认证 </p>
     * @param
     * @return
     * @throws AuthenticationException
     * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        // 获取基于用户名和密码的令牌
        // 实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 查出是否有此用户
        /*SysUser user = Springs.getBean(SysUserService.class).findBaseUserByAccountName(token.getUsername());*/
        // 到数据库查是否有此对象,系统菜单List<SysMenu> 添加到user
        SysUser user = Springs.getBean(SysUserService.class).findUserByAccountName(token.getUsername());
        if (user != null) {
            // 离职状态 0在职,1离职
            if (!"0".equalsIgnoreCase(user.getUserStatus())) {
                addLoginLog(user.getId(), "该用户不是在职员工", Constant.LOGIN_TYPE_FAIL);//添加登录日志
                throw new AuthenticationException("该用户不是在职员工");
            }
            if (user.getPassWord() == null || token.getPassword() == null || !user.getPassWord().equals(MD5Utils.encryptMD5(String.valueOf(token.getPassword())))) {
                addLoginLog(user.getId(), "用户登录密码不正确", Constant.LOGIN_TYPE_FAIL);//添加登录日志
                throw new AuthenticationException("用户登录密码不正确");
            }
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getAccountName(), user.getPassWord(), this.getName());

            SysUserUtil.getHttpSession().setAttribute("sysMenu", user.getSysMenus());
            SysUserUtil.getHttpSession().setAttribute("UserCompanyName", user.getCompanyName());
            SysUserUtil.getHttpSession().setAttribute(Constant.CURRENT_LOGIN_USER, user);

            SysDepartmentService sysDepartmentService = Springs.getBean(SysDepartmentService.class);
            List<Long> deparmentIds = sysDepartmentService.findSonDepartment(user.getDepartmentId());
            user.setDeparmentIds(deparmentIds);

            Subject currentSession = SecurityUtils.getSubject();
            currentSession.getSession().setAttribute("subjectUser", user);

            addLoginLog(user.getId(), "登录成功", Constant.LOGIN_TYPE_SUCCESS);//添加登录日志
            Map<String, String> map = new HashMap<String, String>();
            if (!Objects.isEmpty(user.getSysMenus())) {
                for (SysMenu menu : user.getSysMenus()) {
                    if ("#".equals(menu.getUrl()) || Strings.isBlank(menu.getUrl())) {
                        continue;
                    }
                    map.put(menu.getUrl(), menu.getName());
                }
            }
            if (!Objects.isEmpty(user.getMenuOperations())) {
                for (SysMenuOperation operation : user.getMenuOperations()) {
                    if ("#".equals(operation.getUrl()) || Strings.isBlank(operation.getUrl())) {
                        continue;
                    }
                    map.put(operation.getUrl(), operation.getName());
                }
            }
            currentSession.getSession().setAttribute(Constant.SYS_USER_OPTIONS + user.getId(), map);
            
            /*Runnable initRunnable = new InitSysMenu(user);
            Thread initThread = new Thread(initRunnable);
            initThread.start();*/
            return authcInfo;
        } else {
            throw new AuthenticationException("登录帐号不存在.");
        }
    }

    /**
     * 描述:<p>addLoginLog</P>
     *
     * @author weihongjun
     * @param userId 用户id
     * @param msg 登录信息
     * @param loginType 登录类型0成功，1失败
     * @return void
     * @throws
     */
    private void addLoginLog(Long userId, String msg, String loginType) {
        SysLoginLogService sysLoginLogService = Springs.getBean(SysLoginLogService.class);
        SysLoginLog sysLoginLog = new SysLoginLog();
        HttpServletRequest request = SysUserUtil.getHttpServletRequest();
        sysLoginLog.setLoginDate(new Date());
        sysLoginLog.setBrowerType(BrowserUtils.getBrowserName(request.getHeader("User-Agent")));
        sysLoginLog.setIp(IPAccessControler.getRequestIpAddr(request));
        sysLoginLog.setTermianlType(BrowserUtils.getTermianlType(request.getHeader("User-Agent")));
        sysLoginLog.setLoginMsg(msg);
        sysLoginLog.setLoginType(loginType);
        sysLoginLog.setSessionId(SysUserUtil.getHttpSession().getId());
        sysLoginLog.setUserId(userId);
        sysLoginLog.setUpdateCount(0);
        sysLoginLogService.saveSysLoginLog(sysLoginLog);
    }
}
