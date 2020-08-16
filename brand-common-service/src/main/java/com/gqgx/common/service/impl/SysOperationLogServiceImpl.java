package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.entity.SysOperationLog;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.SysOperationLogMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class SysOperationLogServiceImpl implements SysOperationLogService {

    @Autowired
    protected SysOperationLogMapper mapper;


    @Override
    public SysOperationLog getSysOperationLog(Long id) {

        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveSysOperationLog(SysOperationLog sysOperationLog) {
        int count = 0;
        if(!Objects.isEmpty(sysOperationLog.getId())){
            count = mapper.updateByPrimaryKeySelective(sysOperationLog);
        }else{
            //添加操作记录，设置创建时间
            sysOperationLog.setRecordStatus(RecordStatus.ACTIVE);
            sysOperationLog.setUpdateCount(0);
            sysOperationLog.setCreateDate(new Date());
            count = mapper.insertSelective(sysOperationLog);
        }
        return count;
    }

    @Override
    public int deleteSysOperationLog(SysOperationLog sysOperationLog) {
        return mapper.deleteByPrimaryKey(sysOperationLog);
    }

    @Override
    public int deleteSysOperationLogByIds(Long[] ids) {

        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<SysOperationLog> findSysOperationLog(Criteria criteria) {
        return null;
    }

    @Override
    public PagingResult<SysOperationLog> findOperationLogList(SysOperationLog item, LayuiPage page) {
        Example example = new Example(BrandLargeType.class);
        example.setOrderByClause("create_date DESC");

        if(!Objects.isEmpty(item.getId())) {
            example.createCriteria().andEqualTo("id", item.getId().toString());
        }
        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
        List<SysOperationLog> list = mapper.selectByExample(example);

        PagingResult<SysOperationLog> pageResult = new PagingResult<>(list);
        return pageResult;
    }
}