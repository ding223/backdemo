package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.GqgxCitySite;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;

import java.util.List;

public interface GqgxCitySiteService {

    GqgxCitySite getGqgxCitySite(Long id);

    int saveGqgxCitySite(GqgxCitySite gqgxCitySite);

    int deleteGqgxCitySite(GqgxCitySite gqgxCitySite);

    int deleteGqgxCitySiteByIds(Long[] ids);

    PagingResult<GqgxCitySite> findGqgxCitySite(Criteria criteria);

    PagingResult<GqgxCitySite> findGqgxSite(GqgxCitySite site,LayuiPage page);

    /**
     * 所有的站点
     * @return
     */
    List<GqgxCitySite> findAllGqgxSite();

    /**
     * 站点重新排序
     */
    int sortSite();

    /**
     * 拖拽站点排序
     */
    int reSortSite(String ids);
}