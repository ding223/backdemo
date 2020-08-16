package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.PostionPermissionVO;
import com.gqgx.common.entity.SysPosition;
import com.gqgx.common.entity.vo.SysPositionVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.Page;
import com.gqgx.common.paging.PagingResult;

import java.util.List;


public interface SysPositionService {

    SysPosition getSysPosition(Long id);

    int saveSysPosition(SysPosition sysPosition);

    int deleteSysPosition(SysPosition sysPosition);

    int deleteSysPositionByIds(Long[] ids);

    PagingResult<SysPosition> findSysPosition(Criteria criteria);

    public boolean isExsitPosition(SysPosition sysPosition);

    public PagingResult<SysPosition> findPositionByPage(SysPosition sysPosition, Page page);

    public List<SysPosition> listAll(Long companyId);

    public List<SysPosition> findBySysPosition(SysPosition sysPosition);

    public SysPosition findPositionById(Long positionId,Long companyId);

    public PostionPermissionVO findPostionPermisstionsById(Long positionId, Long companyId);

    PostionPermissionVO findPostsByUserId(Long userId);

    List<SysPositionVo> findPositionList(Long userId);

    PagingResult<SysPosition> positionList(SysPosition sysPosition,
                                           LayuiPage page);
}