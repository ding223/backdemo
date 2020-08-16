package com.gqgx.common.mapper;

import com.gqgx.common.entity.SysDepartment;
import com.gqgx.common.entity.vo.LayUITreeVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysDepartmentMapper extends Mapper<SysDepartment> {
    int deleteByIds(Long[] ids);

    List<LayUITreeVo> findMenuTree();
}