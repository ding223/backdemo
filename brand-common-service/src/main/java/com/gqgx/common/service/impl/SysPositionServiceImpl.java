package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.*;
import com.gqgx.common.entity.vo.SysPositionVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.SysPositionMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.Page;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class SysPositionServiceImpl implements SysPositionService {

    @Autowired
    private SysPositionMapper mapper;

    @Override
    public SysPosition getSysPosition(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveSysPosition(SysPosition sysPosition) {
        int count = 0;
        if (!Objects.isEmpty(sysPosition.getId())) {
            count = mapper.updateByPrimaryKeySelective(sysPosition);
        } else {
            sysPosition.setRecordStatus(RecordStatus.ACTIVE);
            sysPosition.setUpdateCount(0);
            sysPosition.setCreateDate(new Date());
            count = mapper.insertSelective(sysPosition);
        }
        return count;
    }

    @Override
    public int deleteSysPosition(SysPosition sysPosition) {
        return mapper.deleteByPrimaryKey(sysPosition);
    }

    @Override
    public int deleteSysPositionByIds(Long[] ids) {
        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<SysPosition> findSysPosition(Criteria criteria) {
        return null;
    }

    @Override
    public boolean isExsitPosition(SysPosition sysPosition) {
        return false;
    }

    @Override
    public PagingResult<SysPosition> findPositionByPage(SysPosition sysPosition, Page page) {
        return null;
    }

    @Override
    public List<SysPosition> listAll(Long companyId) {
        return null;
    }

    @Override
    public List<SysPosition> findBySysPosition(SysPosition sysPosition) {
        Example example = new Example(SysPosition.class);
        Example.Criteria cb = example.createCriteria();
        if (!Objects.isEmpty(sysPosition) && sysPosition.getDepartmentId() != null) {
            cb.andEqualTo("departmentId", sysPosition.getDepartmentId());
        }
        return mapper.selectByExample(example);
    }

    @Override
    public SysPosition findPositionById(Long positionId, Long companyId) {
        return null;
    }

    @Override
    public PostionPermissionVO findPostionPermisstionsById(Long positionId, Long companyId) {
        return null;
    }

    @Override
    public PostionPermissionVO findPostsByUserId(Long userId) {
        return null;
    }

    @Override
    public List<SysPositionVo> findPositionList(Long userId) {
        return mapper.findPositionList(userId);
    }

    @Override
    public PagingResult<SysPosition> positionList(SysPosition item, LayuiPage page) {
//        Example example = new Example(SysPosition.class);
//        Example.Criteria criteria = example.createCriteria();
//        example.setOrderByClause("create_date DESC");


        Map<String, Object> params = new HashMap<>();
        if (!Objects.isEmpty(item.getName())) {
            params.put("name", item.getName());
        }
        //连表查询
        if (!Objects.isEmpty(item.getSysMenuId())) {
            params.put("sysMenuId", item.getSysMenuId());
        }
        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<SysPosition> list = mapper.findPositionByParams(params);

        PagingResult<SysPosition> pageResult = new PagingResult<>(list);
        return pageResult;
    }
}