package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.GqgxArea;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.GqgxAreaService;

import java.util.List;

@org.springframework.stereotype.Service
public class GqgxAreaServiceImpl implements GqgxAreaService {

    @Override
    public GqgxArea getGqgxArea(Long id) {
        return null;
    }

    @Override
    public int saveGqgxArea(GqgxArea gqgxArea) {
        return 0;
    }

    @Override
    public int deleteGqgxArea(GqgxArea gqgxArea) {
        return 0;
    }

    @Override
    public int deleteGqgxAreaByIds(Long[] ids) {
        return 0;
    }

    @Override
    public PagingResult<GqgxArea> findGqgxArea(Criteria criteria) {
        return null;
    }

    @Override
    public List<GqgxArea> getCityList() {
        return null;
    }

    @Override
    public List<GqgxArea> getAreaList(int level, Long parentId) {
        return null;
    }
}