package common.service;

import com.gqgx.common.entity.GqgxFriendship;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.GqgxFriendshipService;
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
public class GqgxFriendshipServiceImplTest {

    @Autowired
    private GqgxFriendshipService gqgxFriendshipService;

    @Test
    public void test() throws Exception {
        GqgxFriendship gqgxFriendship = new GqgxFriendship();
        LayuiPage page = new LayuiPage();

        PagingResult<GqgxFriendship> result = gqgxFriendshipService.findGqgxFriendship(gqgxFriendship, page);
        System.out.println("总条数：" + result.getList().size());
        for (GqgxFriendship item : result.getList()) {
            System.out.println(item);
        }
    }
}
