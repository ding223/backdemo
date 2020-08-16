package common.service;

import com.gqgx.common.entity.BrandGnSmalltypeItem;
import com.gqgx.common.entity.vo.BrandGnSmalltypeItemVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandGnSmalltypeItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Hunter on 2020-06-23.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BrandGnSmalltypeItemServiceImplTest {

    @Autowired
    private BrandGnSmalltypeItemService brandGnSmalltypeItemService;

    @Test
    public void test() throws Exception {
        BrandGnSmalltypeItemVo vo = new BrandGnSmalltypeItemVo();
        vo.setSmallTypeId(2L);
        vo.setLargeTypeId(1L);
        vo.setFilter("醋酸");

        PagingResult<BrandGnSmalltypeItem> pagingResult =
                brandGnSmalltypeItemService.findBrandGnSmalltypeItemList(vo, new LayuiPage());

        System.out.println("总条数："+pagingResult.getTotal());
        for(BrandGnSmalltypeItem item:pagingResult.getResult()){
            System.out.println(item);
        }
    }
}
