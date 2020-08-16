package common.service;

import com.gqgx.common.entity.SysPosition;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysPositionService;
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
public class SysPositionServiceImplTest {

    @Autowired
    private SysPositionService sysPositionService;

    @Test
    public void test() throws Exception {

        SysPosition sysPosition = new SysPosition();
        sysPosition.setName("管理员");
        //sysPosition.setSysMenuId(3L);
        LayuiPage page = new LayuiPage();


        PagingResult<SysPosition> result = sysPositionService.positionList(sysPosition, page);
        System.out.println("总条数：" + result.getList().size());
        for (SysPosition item : result.getList()) {
            System.out.println(item);
        }
    }

    @Test
    public void test2() throws Exception {

        SysPosition sysPosition = new SysPosition();
        List<SysPosition> list = sysPositionService.findBySysPosition(sysPosition);
        System.out.println("总条数：" + list.size());
        for (SysPosition item : list) {
            System.out.println(item);
        }
    }

}
