package com.gqgx.common.mapper;

import com.gqgx.common.entity.SysPosition;
import com.gqgx.common.entity.vo.SysPositionVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysPositionMapper extends Mapper<SysPosition> {

    List<SysPosition> findPositionByParams(@Param("params") Map<String,Object> params);

    int deleteByIds(Long[] ids);

    List<SysPositionVo> findPositionList(Long userId);
}