package common.service;

import com.gqgx.common.entity.SysMenu;
import com.gqgx.common.entity.vo.SortableVo;
import com.gqgx.common.service.SysMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Hunter on 2020-06-30.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SysMenuServiceImplTest {

    @Autowired
    private SysMenuService sysMenuService;

    @Test
    public void test() throws Exception {

        List<SysMenu> sysMenus = sysMenuService.menuLPowerist(1L);
        System.out.println("总条数：" + sysMenus.size());
        for (SysMenu item : sysMenus) {
            System.out.println(item);
        }
    }

    @Test
    public void test2() throws Exception {
        List<SortableVo> list = sysMenuService.sortableList();
        System.out.println("总条数：" + list.size());
        for (SortableVo item : list) {
            System.out.println(item);
        }
    }
}
