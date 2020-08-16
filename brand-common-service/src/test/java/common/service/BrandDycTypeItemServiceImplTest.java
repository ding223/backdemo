package common.service;

import com.gqgx.common.entity.BrandDycTypeItem;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandDycTypeItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Hunter on 2020-07-02.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BrandDycTypeItemServiceImplTest {


    @Autowired
    private BrandDycTypeItemService brandDycTypeItemService;

    @Test
    public void test() throws Exception {
        BrandDycTypeItem brandDycTypeItem = new BrandDycTypeItem();
        brandDycTypeItem.setProjectName("Active chemical");
        LayuiPage page = new LayuiPage();

        PagingResult<BrandDycTypeItem> result = brandDycTypeItemService.findBrandDycTypeItem(brandDycTypeItem, page);
        System.out.println("总条数：" + result.getList().size());
        for (BrandDycTypeItem item : result.getList()) {
            System.out.println(item);
        }
    }
}
