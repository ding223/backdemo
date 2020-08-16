package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysParameter;
import com.gqgx.common.paging.Page;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysParameterService;

import java.util.List;

@org.springframework.stereotype.Service
public class SysParameterServiceImpl implements SysParameterService {

    @Override
    public SysParameter getSysParameter(Long id) {
        return null;
    }

    @Override
    public int saveSysParameter(SysParameter sysParameter) {
        return 0;
    }

    @Override
    public int deleteSysParameter(SysParameter sysParameter) {
        return 0;
    }

    @Override
    public int deleteSysParameterByIds(Long[] ids) {
        return 0;
    }

    @Override
    public PagingResult<SysParameter> findSysParameter(Criteria criteria) {
        return null;
    }

    @Override
    public List<SysParameter> findParameterList(SysParameter parameter) {
        return null;
    }

    @Override
    public List<SysParameter> findParmerterListByParaCode(String paraCode) {
        return null;
    }

    @Override
    public SysParameter findParmerterByParaCode(String paraCode) {
        return null;
    }

    @Override
    public PagingResult<SysParameter> findParameterListByPage(SysParameter parameter, Page page) {
        return null;
    }
}