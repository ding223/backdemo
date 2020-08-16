package common.service;

import com.gqgx.common.entity.BrandAuTypeItem;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.service.BrandAuTypeItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Hunter on 2020-06-23.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BrandAuTypeItemServiceImplTest {
    @Autowired
    private BrandAuTypeItemService service;


    @Test
    public void getBrandLargeType() {
        BrandAuTypeItem item = service.getBrandAuTypeItem(1L);
        System.out.println(item);
    }

    @Test
    public void saveBrandLargeType() {
        BrandAuTypeItem item = new BrandAuTypeItem();
        item.setId(1L);
        item.setUpdateDate(new Date());
        service.saveBrandAuTypeItem(item);
    }

    @Test
    public void saveBrandLargeType2() {
        BrandAuTypeItem item = new BrandAuTypeItem();
//        brandLargeType.setId(1L);
        item.setLargeTypeId(45L);
        item.setRecordStatus(RecordStatus.ACTIVE);
        item.setUpdateDate(new Date());
        item.setCreateDate(new Date());
        item.setUpdateCount(0);
        service.saveBrandAuTypeItem(item);

        System.out.println(item);
        service.deleteBrandAuTypeItem(item);
    }

}
