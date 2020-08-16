package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysParameter;
import com.gqgx.common.paging.Page;
import com.gqgx.common.paging.PagingResult;

import java.util.List;

public interface SysParameterService {

    SysParameter getSysParameter(Long id);

    int saveSysParameter(SysParameter sysParameter);

    int deleteSysParameter(SysParameter sysParameter);

    int deleteSysParameterByIds(Long[] ids);

    PagingResult<SysParameter> findSysParameter(Criteria criteria);

    List<SysParameter> findParameterList(SysParameter parameter);

    List<SysParameter> findParmerterListByParaCode(String paraCode);

    SysParameter findParmerterByParaCode(String paraCode);

    PagingResult<SysParameter> findParameterListByPage(SysParameter parameter, Page page);
}