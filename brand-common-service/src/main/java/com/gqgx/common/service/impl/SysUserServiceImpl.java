package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.*;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.lang.Strings;
import com.gqgx.common.mapper.SysUserMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.Page;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysPositionService;
import com.gqgx.common.service.SysUserPositionService;
import com.gqgx.common.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    protected SysUserMapper mapper;

    @Autowired
    protected SysUserPositionService sysUserPositionService;
    @Autowired
    protected SysPositionService positionService;


    @Override
    public SysUser getSysUser(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveSysUser(SysUser sysUser) {
        int count = 0;
        if (!Objects.isEmpty(sysUser.getId())) {
            sysUser.setUpdateDate(new Date());
            count = mapper.updateByPrimaryKeySelective(sysUser);
        } else {
            //添加操作记录，设置创建时间
            sysUser.setRecordStatus(RecordStatus.ACTIVE);
            sysUser.setUpdateCount(0);
            sysUser.setCreateDate(new Date());
            count = mapper.insertSelective(sysUser);
        }
        return count;
    }

    @Override
    public int deleteSysUser(SysUser sysUser) {
        return mapper.deleteByPrimaryKey(sysUser);
    }

    @Override
    public int deleteSysUserByIds(Long[] ids) {
        sysUserPositionService.delPositionByUserids(ids);
        return mapper.deleteByIds(ids);
    }

    @Override
    public PagingResult<SysUser> findSysUser(Criteria criteria) {
        return null;
    }

    @Override
    public PagingResult<SysUser> findSysUserByPage(SysUser sysUser, Page page) {
        Example example = new Example(SysUser.class);
        Example.Criteria cb = example.createCriteria();
        example.setOrderByClause("create_date DESC");

        if (!Objects.isEmpty(sysUser.getId())) {
            cb.andEqualTo("id", sysUser.getId().toString());
        }

        if (sysUser.getCompanyId() != null) {
            cb.andEqualTo("companyId", sysUser.getCompanyId());
        }
        if (Strings.isNotBlank(sysUser.getCode())) {
            cb.andLike("code", sysUser.getCode().trim());
        }
        if (Strings.isNotBlank(sysUser.getName())) {
            cb.andLike("userName", sysUser.getName().trim());
        }
        if (sysUser.getDepartmentId() != null && sysUser.getDepartmentId().longValue() != 0) {
            cb.andEqualTo("departmentId", sysUser.getDepartmentId());
        }
        if (Strings.isNotBlank(sysUser.getAccountName())) {
            cb.andEqualTo("accountName", sysUser.getAccountName());
        }
        if (Strings.isNotBlank(sysUser.getPhone())) {
            cb.andLike("phone", sysUser.getPhone().trim());
        }
//        if (sysUser.getPositionId() != null) {
//            cb.addParam("positionId", sysUser.getPositionId());
//        }
        if (Strings.isNotBlank(sysUser.getAreaName())) {
            cb.andLike("address", sysUser.getAreaName());
        }
        if (Strings.isNotBlank(sysUser.getEmail())) {
            cb.andEqualTo("email", sysUser.getEmail());
        }
        if (Strings.isNotBlank(sysUser.getPositionName())) {
            cb.andLike("positionName", sysUser.getPositionName().trim());
        }
        if (Strings.isNotEmpty(sysUser.getUserStatus())) {
            cb.andEqualTo("userStatus", sysUser.getUserStatus());
        }
//        if (Strings.isEmpty(sysUser.getSidx())) {
//            cb.orderBy("t.create_date", Order.DESC);
//        } else {
//            if (Order.DESC.toString().toLowerCase().equals(sysUser.getSord())) {
//                cb.orderBy("t.create_date", Order.DESC);
//            } else {
//                cb.orderBy("t.create_date", Order.ASC);
//            }
//        }

        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getRows());
        }
        List<SysUser> list = mapper.selectByExample(example);
        PagingResult<SysUser> pageResult = new PagingResult<>(list);
        return pageResult;
    }

    @Override
    public int addOrUpdateSysUser(SysUser sysUser) {
        int count = 0;
        if (!Objects.isEmpty(sysUser.getId())) {
            count = mapper.updateByPrimaryKeySelective(sysUser);
        } else {
            //添加操作记录，设置创建时间
            sysUser.setRecordStatus(RecordStatus.ACTIVE);
            sysUser.setUpdateCount(0);
            sysUser.setCreateDate(new Date());
            count = mapper.insertSelective(sysUser);
        }
        List<SysUserPosition> positions = sysUser.getUserPositions();
        if (!Objects.isEmpty(positions)) {
            for (int i = 0; i < positions.size(); i++) {
                SysUserPosition temp = positions.get(i);
                if (!Objects.isEmpty(temp.getId()) && Objects.isEmpty(temp.getPositionId())) {
                    temp.setRecordStatus(RecordStatus.INACTIVE);
                    temp.setCompanyId(sysUser.getCompanyId());
                    temp.setUserId(sysUser.getId());
                    sysUserPositionService.saveSysUserPosition(temp);
                } else if (!Objects.isEmpty(temp.getPositionId())) {
                    temp.setCompanyId(sysUser.getCompanyId());
                    temp.setUserId(sysUser.getId());
                    sysUserPositionService.saveSysUserPosition(temp);
                }
            }
        }
        return count;
    }

    @Override
    public boolean isExsitUser(SysUser sysUser) {
        Example example = new Example(SysUser.class);
        Example.Criteria cb = example.createCriteria();
        cb.andEqualTo("code", sysUser.getCode());
        cb.andEqualTo("companyId", sysUser.getCompanyId());
        if (sysUser.getId() != null) {
            cb.andNotEqualTo("id", sysUser.getId());
        }
        int count = mapper.selectCountByExample(example);
        return count > 0 ? true : false;
    }

    @Override
    public boolean isExsitAccountName(SysUser sysUser) {
        Example example = new Example(SysUser.class);
        Example.Criteria cb = example.createCriteria();
        cb.andEqualTo("accountName", sysUser.getAccountName());
        cb.andEqualTo("companyId", sysUser.getCompanyId());
        if (sysUser.getId() != null) {
            cb.andNotEqualTo("id", sysUser.getId());
        }
        int count = mapper.selectCountByExample(example);
        return count > 0 ? true : false;
    }

    @Override
    public SysUser findSysUserById(Long userId, Long companyId) {
        return null;
    }

    @Override
    public PagingResult<SysUser> querySysUserPage(SysUser sysuser, Page page) {
        Example example = new Example(SysUser.class);
        Example.Criteria cb = example.createCriteria();
        if (null != sysuser.getName() && !"".equals(sysuser.getName())) {
            cb.andLike("name", java.net.URLDecoder.decode(sysuser.getName().trim()));
        }
        if (null != sysuser.getPhone() && !"".equals(sysuser.getPhone())) {
            cb.andLike("phone", sysuser.getPhone());
        }
        if (!Objects.isEmpty(sysuser.getCompanyId())) {
            cb.andEqualTo("companyId", sysuser.getCompanyId());
        }
        //排序
        example.orderBy("UPDATE_DATE").desc();

        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getRows());
        }
        List<SysUser> list = mapper.selectByExample(example);
        PagingResult<SysUser> pageResult = new PagingResult<>(list);
        return pageResult;
    }

    @Override
    public SysUser findUserByAccountName(String accountName) {
        if (Strings.isBlank(accountName)) {
            return null;
        }
        //调用mapper sql查询
        SysUser sysUser = mapper.findUserByAccountName(accountName.trim());
        return sysUser;
    }

    @Override
    public SysUser findBaseUserByAccountName(String accountName) {
        if (Strings.isBlank(accountName)) {
            return null;
        }
        SysUser sysUser = new SysUser();
        sysUser.setAccountName(accountName.trim());
        return mapper.findUserByAccountName(accountName.trim());
    }

    @Override
    public boolean validPass(Long id, String oldPass) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setPassWord(oldPass);
        return mapper.selectCount(sysUser) > 0 ? true : false;
    }

    @Override
    public List<SysMenuOperation> listAllMenuAndOperationByUserId(Long userId, Long companyId) {
//        if (userId == null || companyId == null) {
//            return null;
//        }
//        return mapper.listAllMenuAndOperationByUserId(userId, companyId);
        return null;
    }

    @Override
    public SysUser validLogin(String accountName, String passWord) {
        return null;
    }

    @Override
    public List<SysUser> findSysUser(SysUser sysuser) {
        return null;
    }

    @Override
    public List<SysUser> findSysUserList(String ids) {
        return null;
    }

    @Override
    public PagingResult<SysUser> userList(SysUser sysUser, LayuiPage page) {
//        Example example = new Example(SysUser.class);
//        Example.Criteria cb = example.createCriteria();
//
//        if (Strings.isNotEmpty(sysUser.getUserType())) {
//            cb.andEqualTo("userType", sysUser.getUserType());
//        }
//        if (!Objects.isEmpty(sysUser.getDepartmentId())) {
//            cb.andEqualTo("departmentId", sysUser.getDepartmentId());
//        }
//        //复杂 or条件查询
//        //通过用户名或者电话过滤
//        Weekend<SysUser> weekend = new Weekend<>(SysUser.class);
//        WeekendCriteria<SysUser, Object> keywordCriteria = weekend.weekendCriteria();
//        if (!Objects.isEmpty(sysUser.getName())) {
//            keywordCriteria.orLike("name", "%" + sysUser.getName().trim() + "%")
//                    .orLike("phone", "%" + sysUser.getName().trim() + "%");
//        }
//        weekend.and(cb);
//        example.orderBy("createDate").desc();

        List<SysUser> list = mapper.findUserDetailList();


        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        }
//        List<SysUser> list = mapper.selectByExample(weekend);
        PagingResult<SysUser> pageResult = new PagingResult<>(list);
        return pageResult;
    }
}