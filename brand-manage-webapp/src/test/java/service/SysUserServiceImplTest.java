package service;

import com.gqgx.common.entity.SysUser;
import com.gqgx.common.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Hunter on 2020-06-28.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:applicationContext-shiro.xml"})
public class SysUserServiceImplTest {


    @Autowired
    private SysUserService sysUserService;

    @Test
    public void test() throws Exception {
        SysUser admin = sysUserService.findUserByAccountName("admin");
        System.out.println(admin);
    }

    @Test
    public void test2() throws Exception {
        SysUser admin = sysUserService.getSysUser(1L);
        System.out.println(admin);
    }

}
