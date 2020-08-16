package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.GqgxFriendship;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;

import java.util.List;


public interface GqgxFriendshipService {

    GqgxFriendship getGqgxFriendship(Long id);

    int saveGqgxFriendship(GqgxFriendship gqgxFriendship);

    int deleteGqgxFriendship(GqgxFriendship gqgxFriendship);

    int deleteGqgxFriendshipByIds(Long[] ids);

    PagingResult<GqgxFriendship> findGqgxFriendship(Criteria criteria);
    
    PagingResult<GqgxFriendship> findGqgxFriendship(GqgxFriendship gqgxFriendship, LayuiPage page);
    
    List<GqgxFriendship> getGqgxFriendship(GqgxFriendship gqgxFriendship);
}