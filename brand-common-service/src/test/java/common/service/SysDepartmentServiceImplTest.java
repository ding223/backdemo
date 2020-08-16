package common.service;

import com.gqgx.common.entity.SysDepartment;
import com.gqgx.common.entity.SysPosition;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.entity.vo.LayUITreeVo;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysDepartmentService;
import com.gqgx.common.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Hunter on 2020-07-01.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SysDepartmentServiceImplTest {

    @Autowired
    private SysDepartmentService sysDepartmentService;

    @Test
    public void test() throws Exception {
        List<LayUITreeVo> list = sysDepartmentService.getDepartmentTree();
        System.out.println("总条数：" + list.size());
        for (LayUITreeVo item : list) {
            System.out.println(item);
        }
    }
}
