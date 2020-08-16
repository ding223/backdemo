package common.service;

import com.gqgx.common.entity.SysMenu;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Hunter on 2020-06-29.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SysUserServiceImplTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void test() throws Exception {
        SysUser admin = sysUserService.findUserByAccountName("admin");
        System.out.println(admin);

        System.out.println(admin.getSysMenus());
    }

    @Test
    public void test2() throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setName("管理员");
        LayuiPage page = new LayuiPage();

        PagingResult<SysUser> result = sysUserService.userList(sysUser, page);
        System.out.println("总条数：" + result.getTotal());
        for (SysUser item : result.getList()) {
            System.out.println(item);
        }
    }

    @Test
    public void test3() throws Exception {
        PagingResult<SysUser> result = sysUserService.userList(null, null);
        System.out.println("总条数：" + result.getTotal());
        for (SysUser item : result.getList()) {
            System.out.println(item);
        }
    }
}
