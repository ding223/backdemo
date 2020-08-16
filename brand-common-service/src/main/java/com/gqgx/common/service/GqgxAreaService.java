package com.gqgx.common.service;


import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.GqgxArea;
import com.gqgx.common.paging.PagingResult;

import java.util.List;

public interface GqgxAreaService {

    GqgxArea getGqgxArea(Long id);

    int saveGqgxArea(GqgxArea gqgxArea);

    int deleteGqgxArea(GqgxArea gqgxArea);

    int deleteGqgxAreaByIds(Long[] ids);

    PagingResult<GqgxArea> findGqgxArea(Criteria criteria);

    List<GqgxArea> getCityList();

    List<GqgxArea> getAreaList(int level,Long parentId);
}