package com.gqgx.common.service;

import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.SysMenuOperation;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.Page;
import com.gqgx.common.paging.PagingResult;

import java.util.List;


public interface SysUserService {

    SysUser getSysUser(Long id);

    int saveSysUser(SysUser sysUser);

    int deleteSysUser(SysUser sysUser);

    int deleteSysUserByIds(Long[] ids);

    PagingResult<SysUser> findSysUser(Criteria criteria);
    
    public PagingResult<SysUser> findSysUserByPage(SysUser sysUser, Page page);
    
    public int addOrUpdateSysUser(SysUser sysUser);
    
    public boolean isExsitUser(SysUser sysUser);
    
    public boolean isExsitAccountName(SysUser sysUser);
    
    public SysUser findSysUserById(Long userId, Long companyId);
    
    public PagingResult<SysUser> querySysUserPage(SysUser sysuser, Page page);
    
    public SysUser findUserByAccountName(String accountName);
    
    public SysUser findBaseUserByAccountName(String accountName);
    

	boolean validPass(Long id, String oldPass);
	
    public List<SysMenuOperation> listAllMenuAndOperationByUserId(Long userId, Long companyId);
    
    public SysUser validLogin(String accountName, String passWord);
    
    public List<SysUser> findSysUser(SysUser sysuser);

	List<SysUser> findSysUserList(String ids);

	PagingResult<SysUser> userList(SysUser sysUser, LayuiPage page);
    
}