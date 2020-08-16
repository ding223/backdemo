package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.GqgxFriendship;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.GqgxFriendshipMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.GqgxFriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@org.springframework.stereotype.Service
public class GqgxFriendshipServiceImpl implements GqgxFriendshipService {

    @Autowired
    protected GqgxFriendshipMapper mapper;


    @Override
    public GqgxFriendship getGqgxFriendship(Long id) {
        return null;
    }

    @Override
    public int saveGqgxFriendship(GqgxFriendship gqgxFriendship) {
        return 0;
    }

    @Override
    public int deleteGqgxFriendship(GqgxFriendship gqgxFriendship) {
        return 0;
    }

    @Override
    public int deleteGqgxFriendshipByIds(Long[] ids) {
        return 0;
    }

    @Override
    public PagingResult<GqgxFriendship> findGqgxFriendship(Criteria criteria) {
        return null;
    }

    @Override
    public PagingResult<GqgxFriendship> findGqgxFriendship(GqgxFriendship gqgxFriendship, LayuiPage page) {
        Example example = new Example(GqgxFriendship.class);
        Example.Criteria cb = example.createCriteria();
        if(!Objects.isEmpty(gqgxFriendship.getName())) {
            cb.andLike("name", gqgxFriendship.getName().trim());
        }
        example.orderBy("createDate").desc();

        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<GqgxFriendship> list = mapper.selectByExample(example);
        PagingResult<GqgxFriendship> pageResult = new PagingResult<>(list);
        return pageResult;
    }

    @Override
    public List<GqgxFriendship> getGqgxFriendship(GqgxFriendship gqgxFriendship) {
        return null;
    }
}