package com.gqgx.common.service.impl;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.entity.SysDepartment;
import com.gqgx.common.entity.vo.LayUITreeVo;
import com.gqgx.common.entity.vo.NodeTreeVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.SysDepartmentMapper;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class SysDepartmentServiceImpl implements SysDepartmentService {

    @Autowired
    protected SysDepartmentMapper mapper;

    @Override
    public SysDepartment getSysDepartment(Long id) {

        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveSysDepartment(SysDepartment sysDepartment) {


        int count = 0;
        if(!Objects.isEmpty(sysDepartment.getId())){
            count = mapper.updateByPrimaryKeySelective(sysDepartment);
        }else{
            sysDepartment.setRecordStatus(RecordStatus.ACTIVE);
            sysDepartment.setUpdateCount(0);
            sysDepartment.setCreateDate(new Date());
            count = mapper.insertSelective(sysDepartment);
        }
        return count;
    }

    @Override
    public int deleteSysDepartment(SysDepartment sysDepartment) {

        return mapper.deleteByPrimaryKey(sysDepartment);
    }

    @Override
    public int deleteSysDepartmentByIds(Long[] ids) {

        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<SysDepartment> findSysDepartment(Criteria criteria) {

        return null;
    }

    @Override
    public boolean isExsitDepartment(SysDepartment sysDepartment) {
        return false;
    }

    @Override
    public int addOrUpdateDepartment(SysDepartment sysDepartment) {
        return 0;
    }

    @Override
    public List<SysDepartment> listAll(Long companyId) {
        return null;
    }

    @Override
    public List<SysDepartment> findDepartmentStaff(Long companyId, Long parentId) {
        return null;
    }

    @Override
    public Map<String, Object> findByMaxLevelAndSeq(SysDepartment sysDepartment) {
        return null;
    }

    @Override
    public SysDepartment getSysDepartMentByParam(String paramName, String paramValue, Long companyId) {
        return null;
    }

    @Override
    public SysDepartment findDepartmentById(Long id) {
        return null;
    }

    @Override
    public List<SysDepartment> findDepartmentById(Long id, boolean needChild) {
        return null;
    }

    @Override
    public List<LayUITreeVo> getDepartmentTree() {
        List<LayUITreeVo> menuTree = mapper.findMenuTree();
        return menuTree;
    }

    @Override
    public List<Long> findSonDepartment(Long departmentId) {
        return null;
    }

    @Override
    public List<NodeTreeVo> getDepartmentUserTree(Long currentCompanyId) {
        return null;
    }

    @Override
    public SysDepartment getBranchDepartmentId(Long userId) {
        return null;
    }

    @Override
    public List<SysDepartment> departmentList() {
        return mapper.selectAll();
    }
}