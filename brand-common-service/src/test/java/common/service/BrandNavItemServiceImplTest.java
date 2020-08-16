package common.service;

import com.gqgx.common.entity.BrandNavItem;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandNavItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Hunter on 2020-07-01.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BrandNavItemServiceImplTest {

    @Autowired
    private BrandNavItemService brandNavItemService;

    @Test
    public void test3() throws Exception {

        BrandNavItem brandNavItem = new BrandNavItem();
        LayuiPage page = new LayuiPage();

        PagingResult<BrandNavItem> result = brandNavItemService.findBrandNavItem(brandNavItem, page);

        System.out.println("总条数：" + result.getTotal());
        for (BrandNavItem item : result.getList()) {
            System.out.println(item);
        }
    }
}
