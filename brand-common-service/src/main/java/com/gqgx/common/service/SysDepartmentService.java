package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysDepartment;
import com.gqgx.common.entity.vo.LayUITreeVo;
import com.gqgx.common.entity.vo.NodeTreeVo;
import com.gqgx.common.paging.PagingResult;

import java.util.List;
import java.util.Map;


public interface SysDepartmentService {

    SysDepartment getSysDepartment(Long id);

    int saveSysDepartment(SysDepartment sysDepartment);

    int deleteSysDepartment(SysDepartment sysDepartment);

    int deleteSysDepartmentByIds(Long[] ids);

    PagingResult<SysDepartment> findSysDepartment(Criteria criteria);

    public boolean isExsitDepartment(SysDepartment sysDepartment);

    public int addOrUpdateDepartment(SysDepartment sysDepartment);

    public List<SysDepartment> listAll(Long companyId);

    public List<SysDepartment> findDepartmentStaff(Long companyId,Long parentId);

    public Map<String, Object> findByMaxLevelAndSeq(SysDepartment sysDepartment);

    public SysDepartment getSysDepartMentByParam(String paramName, String paramValue,Long companyId);

    public SysDepartment findDepartmentById(Long id);

    public List<SysDepartment> findDepartmentById(Long id, boolean needChild);

    List<LayUITreeVo> getDepartmentTree();

    List<Long> findSonDepartment(Long departmentId);

    List<NodeTreeVo> getDepartmentUserTree(Long currentCompanyId);

    SysDepartment getBranchDepartmentId(Long userId) ;

    List<SysDepartment> departmentList();
    
}