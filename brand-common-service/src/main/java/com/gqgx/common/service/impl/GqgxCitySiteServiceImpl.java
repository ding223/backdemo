package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.GqgxCitySite;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.GqgxCitySiteService;

import java.util.List;

@org.springframework.stereotype.Service
public class GqgxCitySiteServiceImpl implements GqgxCitySiteService {

    @Override
    public GqgxCitySite getGqgxCitySite(Long id) {
        return null;
    }

    @Override
    public int saveGqgxCitySite(GqgxCitySite gqgxCitySite) {
        return 0;
    }

    @Override
    public int deleteGqgxCitySite(GqgxCitySite gqgxCitySite) {
        return 0;
    }

    @Override
    public int deleteGqgxCitySiteByIds(Long[] ids) {
        return 0;
    }

    @Override
    public PagingResult<GqgxCitySite> findGqgxCitySite(Criteria criteria) {
        return null;
    }

    @Override
    public PagingResult<GqgxCitySite> findGqgxSite(GqgxCitySite site, LayuiPage page) {
        return null;
    }

    @Override
    public List<GqgxCitySite> findAllGqgxSite() {
        return null;
    }

    @Override
    public int sortSite() {
        return 0;
    }

    @Override
    public int reSortSite(String ids) {
        return 0;
    }
}