/**
 * 描述:<p></p>
 * @Title: SysOrganizationAction.java
 * @Package com.gqgx.action.organization
 * 
 * @author weihongjun
 * @date 2016年11月16日 上午9:51:58
*/


package com.gqgx.action.organization;

import com.gqgx.common.entity.*;
import com.gqgx.common.entity.vo.NodeTreeVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.lang.Strings;
import com.gqgx.common.lang.util.MD5Utils;
import com.gqgx.common.paging.Page;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.*;
import com.gqgx.constant.Constant;
import com.gqgx.domain.GridResult;
import com.gqgx.domain.RequestResult;
import com.gqgx.domain.RequestResult.CODE;
import com.gqgx.utils.SysUserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 描述:<p>系统组织架构处理类</p>
 * @ClassName: SysOrganizationAction
 * @author weihongjun
 * @date 2016年11月16日 上午9:51:58
 *
*/
@RequestMapping("/organiza")
@Controller
public class SysOrganizationAction
{
    private Logger logger = LoggerFactory.getLogger(SysOrganizationAction.class);
    
    @Autowired
    private SysUserService sysUserService;
    
    @Autowired
    private SysPositionService sysPositionService;
    
    @Autowired
    private SysDepartmentService sysDepartmentService;
    
    @Autowired
    private SysMenuService sysMenuService;
    
    @Autowired
    private SysPositionMenuService sysPositionMenuService;
    
    @Autowired
    private SysDefaultMenuService defaultMenuService;
	
	@Autowired
	private SysPositionPermissionsService sysPositionPermissionsService;
	
	
	@Autowired
	private SysParameterService sysParameterService;
    
    /**
      * 描述:<p>组织架构页面跳转</P>
      *
      * @author weihongjun
      * @param request
      * @return
      * @return ModelAndView
      * @throws
    */
    @RequestMapping("/init")
    public ModelAndView init(HttpServletRequest request)
    {
        ModelAndView view = new ModelAndView("/companyManage/organiza");
        return view;
    }
   
    /** 交接客户，税务会计，税务员，会计等
     * type 1批量交接客户 2批量交接税务会计 3批量交接税务员 4批量交接会计
	 * @param ids
	 * @return
	 */
	@RequestMapping("/batchCustomerHandover")
	public ModelAndView batchCustomerHandover(String ids)
	{
		ModelAndView view=new ModelAndView("/companyManage/customerHandover");
		List<SysUser> users=sysUserService.findSysUserList(ids);
		view.addObject("users", users);
		return view;
	}
    
    @RequestMapping("/resetPage")
    public ModelAndView resetPage(HttpServletRequest request, Long userId)
    {
        ModelAndView view =  new ModelAndView("/companyManage/resetPwd");
        view.addObject("sysUser", sysUserService.getSysUser(userId));
        return view;
    }
    
    /**
      * 描述:<p>设置权限页面</P>
      *
      * @author weihongjun
      * @param request
      * @param postionId
      * @return
      * @return ModelAndView
      * @throws
    */
    @RequestMapping("/setPermissionsPage")
    public ModelAndView setPermissionsPage(HttpServletRequest request, Long postionId)
    {
        ModelAndView view = new ModelAndView("/companyManage/permissionsPage");
        Long companyId = SysUserUtil.getCurrentCompanyId();
        if (companyId != null)
        {
        	List<SysMenu> listAllMenus = sysMenuService.listAllMenus(companyId);
            view.addObject("allMenus", listAllMenus);
            if (postionId != null)
            {
                PostionPermissionVO permissionVO = sysPositionService.findPostionPermisstionsById(postionId, SysUserUtil.getCurrentCompanyId());
                view.addObject("permissionVO", permissionVO);
            }
        }
        return view;
    }
    
    
    
    /**
      * 描述:<p>保存职位权限</P>
      *
      * @author weihongjun
      * @param permissionVO
      * @return
      * @return RequestResult
      * @throws
    */
    @RequestMapping("/savePostionPermmistion")
    @ResponseBody
    public RequestResult savePostionPermmistion(PostionPermissionVO permissionVO)
    {
        RequestResult result = new RequestResult();
        try
        {
            Long companyId = SysUserUtil.getCurrentCompanyId();
            Long postionId = permissionVO.getPostionId();
            if (postionId == null)
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("保存职位权限失败：参数异常");
                return result;
            }
            
            List<SysPositionMenu> menus = null;
            List<SysMenu> sysMenus = permissionVO.getMenus();
            if (!Objects.isEmpty(sysMenus))
            {
                menus = new ArrayList<SysPositionMenu>();
                for (int i = 0; i < sysMenus.size(); i++)
                {
                    if (sysMenus.get(i).getId() == null)
                        continue;
                    
                    SysPositionMenu temp = new SysPositionMenu();
                    temp.setCompanyId(companyId);
                    temp.setMenuId(sysMenus.get(i).getId());
                    temp.setPositionId(postionId);
                    menus.add(temp);
                }
            }
            
            List<SysPositionOperation> menusOptions = null;
            List<SysMenuOperation> sysMenusOptions = permissionVO.getOperations();
            if (!Objects.isEmpty(sysMenusOptions))
            {
                menusOptions = new ArrayList<SysPositionOperation>();
                for (int i = 0; i < sysMenusOptions.size(); i++)
                {
                    if (sysMenusOptions.get(i).getId() == null)
                        continue;

                    SysPositionOperation temp = new SysPositionOperation();
                    temp.setCompanyId(companyId);
                    temp.setMenuId(sysMenusOptions.get(i).getMenuId());
                    temp.setPositionId(postionId);
                    temp.setMenuOperationId(sysMenusOptions.get(i).getId());
                    menusOptions.add(temp);
                }
            }
            
            sysPositionMenuService.savePostionPermisstion(postionId, menus, menusOptions);
            result.setCode(CODE.SUCCESS.getCode());
            result.setMsg("保存职位权限成功");
            return result;
        }
        catch (Exception e)
        {
            logger.error("[保存职位权限异常：]", e);
            result.setCode(CODE.ERROR.getCode());
            result.setMsg("保存职位权限失败：系统异常，请稍后再试");
        }
        return result;
    }
    
    
    @RequestMapping("/sysuser")
    public ModelAndView sysuser(HttpServletRequest request, Long userId)
    {
    	SysUser user = SysUserUtil.getCurrentUser();
        ModelAndView view = new ModelAndView("/companyManage/sysuser");
        view.addObject("curUser", user);
        return view;
    }
    
    @RequestMapping("/settingHome")
    public ModelAndView settingHome(HttpServletRequest request)
    {
    	SysUser user = SysUserUtil.getCurrentUser();
    	ModelAndView view = this.sysuser(request, user.getId());
    	view.addObject("sysUser", user);
    	view.setViewName("/companyManage/settingHome");
    	return view;
    }
    
    @RequestMapping("/postionPage")
    public ModelAndView postionPage(HttpServletRequest request, Long postionId)
    {
        ModelAndView view = new ModelAndView("/companyManage/postionPage");
        Long currentCompanyId = SysUserUtil.getCurrentCompanyId();
        if (postionId != null)
        {
            SysPosition postion = sysPositionService.findPositionById(postionId,currentCompanyId);
            view.addObject("postion", postion);
            if (postion != null)
            {
                List<SysPositionPermissions> list = sysPositionPermissionsService.findByPostions(postion.getId());
                
                List<SysPositionPermissions> areaList = new ArrayList<SysPositionPermissions>();
                SysPositionPermissions dataPerm = null;
                if (!Objects.isEmpty(list))
                {
                    for (SysPositionPermissions permission : list)
                    {
                        // 1=区域权限,2=数据层级
                        if (Constant.POSITION_PERM_1.equals(permission.getPermType()))
                        {
                            areaList.add(permission);
                        }
                        else if (Constant.POSITION_PERM_2.equals(permission.getPermType()))
                        {
                            dataPerm = permission;
                        }
                    }
                }
                view.addObject("areaList", areaList);
                view.addObject("dataPerm", dataPerm);
            }
        }
        return view;
    }
    
    /**
      * 描述:<p>组织架构用户列表</P>
      *
      * @author weihongjun
      * @param request
      * @param sysUser
      * @param page
      * @return
      * @return PagingResult<SysUser>
      * @throws
    */
    @RequestMapping("/findSysUserList")
    @ResponseBody
    public GridResult<SysUser> findSysUserList(HttpServletRequest request, SysUser sysUser, Page page)
    {
    	Long currentCompanyId = SysUserUtil.getCurrentCompanyId();
    	sysUser.setCompanyId(currentCompanyId);
        try
        {
            PagingResult<SysUser> pagingResult = sysUserService.findSysUserByPage(sysUser, page);
            return new GridResult<SysUser>(pagingResult, page.getPage(), page.getRows());
        }
        catch (Exception e)
        {
            logger.error("[查询员工列表异常：]", e);
            return null;
        }
    }
    
    /**
      * 描述:<p>分页查询职位列表</P>
      *
      * @author weihongjun
      * @param request
      * @param sysPosition
      * @param page
      * @return
      * @return PagingResult<SysPosition>
      * @throws
    */
    @RequestMapping("/findSysPositionList")
    @ResponseBody
    public GridResult<SysPosition> findSysPositionList(HttpServletRequest request, SysPosition sysPosition, Page page)
    {
    	Long currentCompanyId = SysUserUtil.getCurrentCompanyId();
    	sysPosition.setCompanyId(currentCompanyId);
        try
        {
            PagingResult<SysPosition> result = sysPositionService.findPositionByPage(sysPosition, page);
            return new GridResult<SysPosition>(result, page.getPage(), page.getRows());
        }
        catch (Exception e)
        {
            logger.error("[查询职位列表异常：]", e);
            return null;
        }
    }
    
    /**
      * 描述:<p>根据部门查询职位</P>
      *
      * @author weihongjun
      * @param departId
      * @return
      * @return List<SysPosition>
      * @throws
    */
    @RequestMapping("/findPositionByDepartId")
    @ResponseBody
    public List<SysPosition> findPositionByDepartId(Long departId)
    {
        SysPosition sysPosition = new SysPosition();
        sysPosition.setCompanyId(SysUserUtil.getCurrentCompanyId());
        sysPosition.setDepartmentId(departId);
        return sysPositionService.findBySysPosition(sysPosition);
    }
    
    /**
      * 描述:<p>保存职位信息</P>
      *
      * @author weihongjun
      * @param request
      * @param sysPosition
      * @return
      * @return RequestResult
      * @throws
    */
    @RequestMapping("/saveSysPosition")
    @ResponseBody
    public RequestResult saveSysPosition(HttpServletRequest request, SysPosition sysPosition)
    {
        RequestResult result = new RequestResult();
        try
        {
            Long companyId = SysUserUtil.getCurrentCompanyId();
            sysPosition.setCompanyId(companyId);
            boolean isExsit = sysPositionService.isExsitPosition(sysPosition);
            if (isExsit)
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("保存职位失败：该部门职位名称已经存在!");
                return result;
            }
            int count = sysPositionService.saveSysPosition(sysPosition);
            if (count > 0)
            {
                result.setCode(CODE.SUCCESS.getCode());
                result.setMsg("保存职位成功");
            }
            else
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("保存职位失败：系统异常，请稍后再试");
            }
        }
        catch (Exception e)
        {
            logger.error("[新增或者修改职位信息异常：]", e);
            result.setCode(CODE.ERROR.getCode());
            result.setMsg("保存职位失败：系统异常，请稍后再试");
        }
        return result;
    }
    
    
    
    /**
      * 描述:<p>保存部门信息</P>
      *
      * @author weihongjun
      * @param request
      * @param sysDepartment
      * @return
      * @return RequestResult
      * @throws
    */
    @RequestMapping("/saveSysDepartment")
    @ResponseBody
    public RequestResult saveSysDepartment(HttpServletRequest request, SysDepartment sysDepartment)
    {
        RequestResult result = new RequestResult();
        try
        {
            Long companyId = SysUserUtil.getCurrentCompanyId();
            sysDepartment.setCompanyId(companyId);
            if(Strings.isEmpty(sysDepartment.getName())){
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("保存部门失败：部门名称不能为空!");
                return result;
            }
            if (sysDepartment.getParentId() == null || sysDepartment.getParentId() == 0)
            {
                sysDepartment.setParentId(null);
            }
            boolean isExsit = sysDepartmentService.isExsitDepartment(sysDepartment);
            if (isExsit)
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("保存部门失败：部门名称已经存在!");
                return result;
            }
            int count = sysDepartmentService.addOrUpdateDepartment(sysDepartment);
            if (count > 0)
            {
                result.setCode(CODE.SUCCESS.getCode());
                result.setMsg("保存部门成功");
            }
            else
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("保存部门失败：系统异常，请稍后再试");
            }
        }
        catch (Exception e)
        {
            logger.error("[新增或者修改部门信息异常：]", e);
            result.setCode(CODE.ERROR.getCode());
            result.setMsg("保存部门失败：系统异常，请稍后再试");
        }
        return result;
    }
    
    
    /**
      * 描述:<p>删除部门</P>
      *
      * @author weihongjun
      * @param request
      * @param deleteId
      * @return
      * @return RequestResult
      * @throws
    */
    @RequestMapping("/deleteDepartment")
    @ResponseBody
    public RequestResult deleteDepartment(HttpServletRequest request, Long deleteId)
    {
        RequestResult result = new RequestResult();
        try
        {
            if (deleteId == null)
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("删除部门失败：请选择要删除的部门!");
                return result;
            }
            Long[] delArray = new Long[1];
            delArray[0] = deleteId;
            int count = sysDepartmentService.deleteSysDepartmentByIds(delArray);
            if (count > 0)
            {
                result.setCode(CODE.SUCCESS.getCode());
                result.setMsg("删除部门成功");
            }
            else
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("删除部门失败：系统异常，请稍后再试");
            }
        }
        catch (Exception e)
        {
            logger.error("[删除部门信息异常：]", e);
            result.setCode(CODE.ERROR.getCode());
            result.setMsg("删除部门失败：系统异常，请稍后再试");
        }
        return result;
    }
    
    
    /**
      * 描述:<p>根据id查询职位</P>
      *
      * @author weihongjun
      * @param positionId：职位id
      * @return
      * @return SysPosition
      * @throws
    */
    @RequestMapping("/findPositionById")
    @ResponseBody
    public SysPosition findPositionById(Long positionId)
    {
        return sysPositionService.getSysPosition(positionId);
    }
    
    
    /**
      * 描述:<p>根据id删除职位</P>
      *
      * @author weihongjun
      * @param ids
      * @return
      * @return RequestResult
      * @throws
    */
    @RequestMapping("/deletePositionByIds")
    @ResponseBody
    public RequestResult deletePositionByIds(String ids)
    {
        RequestResult result = new RequestResult();
        try
        {
            if (Strings.isBlank(ids))
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("删除职位失败：请选择要删除的数据!");
                return result;
            }
            String[] idsStr = ids.split(",");
            Long[] delIds = new Long[idsStr.length];
            for (int i = 0; i < idsStr.length; i++)
            {
                delIds[i] = Long.valueOf(idsStr[i]);
            }
            int count = sysPositionService.deleteSysPositionByIds(delIds);
            if (count > 0)
            {
                result.setCode(CODE.SUCCESS.getCode());
                result.setMsg("删除职位成功");
                result.addModel("delCount", count);
            }
            else
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("删除职位失败：系统异常，请稍后再试");
            }
        }
        catch (Exception e)
        {
            logger.error("[删除职位信息异常：]", e);
            result.setCode(CODE.ERROR.getCode());
            result.setMsg("删除职位失败：系统异常，请稍后再试");
        }
        return result;
    }
    
    
    
    @RequestMapping("/saveSysDefaultMenu")
    @ResponseBody
    public RequestResult saveSysDefaultMenu(HttpServletRequest request, SysUser sysUser) { 
    	RequestResult result = new RequestResult();
    	try {
    		defaultMenuService.saveSysDefaultMenu(sysUser);
    		result.setCode(CODE.SUCCESS.getCode());
            result.setMsg("保存员工成功");
    	} catch(Exception e ) {
    		result.setCode(CODE.ERROR.getCode());
    		result.setMsg("保存员工失败：系统异常，请稍后再试");
    	}
    	return result;
    }
    
    /**
      * 描述:<p>修改或者新增用户</P>
      *
      * @author weihongjun
      * @param request
      * @param sysUser
      * @return
      * @return RequestResult
      * @throws
    */
    @RequestMapping("/saveSysUser")
    @ResponseBody
    public RequestResult saveSysUser(HttpServletRequest request, SysUser sysUser)
    {
        RequestResult result = new RequestResult();
        try
        {
            Long companyId = SysUserUtil.getCurrentCompanyId();
            sysUser.setCompanyId(companyId);
            
            boolean isValidate = userValidate(sysUser, result);
            if (!isValidate)
            {
                return result;
            }
            boolean isExsitUser = sysUserService.isExsitUser(sysUser);
            if (isExsitUser)
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("保存员工失败：员工工号已经存在!");
                return result;
            }
            sysUser.setAccountName(sysUser.getAccountPrefix() + sysUser.getAccountName());
            boolean isExsitAccountName = sysUserService.isExsitAccountName(sysUser);
            if (isExsitAccountName)
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("保存员工失败：员工登录帐号已经存在!");
                return result;
            }
            
            //离职状态 0离职,1在职
            String passWord = "";
            if (Objects.isEmpty(sysUser.getId()))
            {
                sysUser.setUserStatus("1");
                passWord = this.genRandomPwd(6);
                sysUser.setPassWord(MD5Utils.encryptMD5(passWord));
                String[] param = new String[3];
	            param[0] = sysUser.getName();
	            param[1] = sysUser.getAccountName();
	            param[2] = passWord;
            }
            
            int count = sysUserService.addOrUpdateSysUser(sysUser);
            if (count > 0)
            {
                result.setCode(CODE.SUCCESS.getCode());
                result.setMsg("保存员工成功");
            } else {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("保存员工失败：系统异常，请稍后再试");
            }
        }
        catch (Exception e)
        {
            logger.error("[新增或者修改员工信息异常：]", e);
            result.setCode(CODE.ERROR.getCode());
            result.setMsg("保存员工失败：系统异常，请稍后再试");
        }
        return result;
    }
    
    /**
     * 描述:<p>修改或者新增用户</P>
     *
     * @author weihongjun
     * @param request
     * @param sysUser
     * @return
     * @return RequestResult
     * @throws
   */
   @RequestMapping("/saveMyInfo")
   @ResponseBody
   public RequestResult saveMyInfo(HttpServletRequest request, SysUser sysUser)
   {
       RequestResult result = new RequestResult();
       try
       {
           Long companyId = SysUserUtil.getCurrentCompanyId();
           sysUser.setCompanyId(companyId);
           
           int count = sysUserService.addOrUpdateSysUser(sysUser);
           if (count > 0)
           {
               result.setCode(CODE.SUCCESS.getCode());
               result.setMsg("保存员工成功");
           } else {
               result.setCode(CODE.FAIL.getCode());
               result.setMsg("保存员工失败：系统异常，请稍后再试");
           }
       }
       catch (Exception e)
       {
           logger.error("[新增或者修改员工信息异常：]", e);
           result.setCode(CODE.ERROR.getCode());
           result.setMsg("保存员工失败：系统异常，请稍后再试");
       }
       return result;
   }
    
    /**
      * 描述:<p>重置员工密码</P>
      *
      * @author weihongjun
      * @param userId：员工id
      * @param setType：0=自动，1=手动
      * @param passWord：密码
      * @param sendMsg：是否发送短信（0=是）
      * @return
      * @return RequestResult
      * @throws
    */
    @RequestMapping("/resetPassWord")
    @ResponseBody
    public RequestResult resetPassWord(Long userId, String setType, String passWord, String sendMsg)
    {
        RequestResult result = new RequestResult();
        try
        {
            if (userId == null)
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("重置密码失败：员工ID不能为空");
                return result;
            }
            if (Strings.isBlank(setType))
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("重置密码失败：请选择重置方式");
                return result;
            }
            if (Strings.isBlank(passWord) && "1".equals(setType))
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("重置密码失败：密码不能为空");
                return result;
            }
            
            SysUser updUser = new SysUser();
            updUser.setId(userId);
            if (!"1".equals(setType))
            {
                passWord = this.genRandomPwd(6);
            }
            updUser.setPassWord(MD5Utils.encryptMD5(passWord));
            int count = sysUserService.saveSysUser(updUser);
            if (count > 0)
            {
                if ("0".equals(sendMsg))
                {
                	SysUser sysUser=sysUserService.getSysUser(userId);
                	String[] param = new String[2];
		            param[0] = sysUser.getName();
		            param[1] = passWord;
                }
                result.setCode(CODE.SUCCESS.getCode());
                result.setMsg("重置密码成功");
            }
            else
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("重置密码失败：系统异常，请稍后再试");
            }
        }
        catch (Exception e)
        {
            logger.error("[重置员工密码异常：]", e);
            result.setCode(CODE.ERROR.getCode());
            result.setMsg("重置密码失败：系统异常，请稍后再试");
        }
        return result;
    }

    
    /** 
     * 生成随即密码 ：26个字母+10个数字随机生成密码
     * @param pwdLen 生成的密码的总长度 
     * @return  密码的字符串 
    */  
    private String genRandomPwd(int pwdLen)
    {
        // 35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 36;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度
        char[] str =
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2',
                '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < pwdLen)
        {
            // 生成随机数，取绝对值，防止生成负数，
            
            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1
            
            if (i >= 0 && i < str.length)
            {
                pwd.append(str[i]);
                count++;
            }
        }
        return pwd.toString();
    }
    
    
    /**
      * 描述:<p>根据员工id查询</P>
      *
      * @author weihongjun
      * @param userId
      * @return
      * @return SysUser
      * @throws
    */
    @RequestMapping("/findUserById")
    @ResponseBody
    public SysUser findUserById(Long userId)
    {
        return sysUserService.getSysUser(userId);
    }
    
    /**
      * 描述:<p>根据id删除员工信息</P>
      *
      * @author weihongjun
      * @param ids
      * @return
      * @return RequestResult
      * @throws
    */
    @RequestMapping("/deleteUserByIds")
    @ResponseBody
    public RequestResult deleteUserByIds(String ids)
    {
        RequestResult result = new RequestResult();
        try
        {
            if (Strings.isBlank(ids))
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("删除员工失败：请选择删除的数据");
                return result;
            }
            String[] idsStr = ids.split(",");
            Long[] delIds = new Long[idsStr.length];
            for (int i = 0; i < idsStr.length; i++)
            {
                delIds[i] = Long.valueOf(idsStr[i]);
            }
            int count = sysUserService.deleteSysUserByIds(delIds);
            result.setCode(CODE.SUCCESS.getCode());
            result.setMsg("删除员工成功");
            result.addModel("deleteCount", count);
        }
        catch (Exception e)
        {
            logger.error("[删除员工工信息异常：]", e);
            result.setCode(CODE.ERROR.getCode());
            result.setMsg("删除员工失败：系统异常，请稍后再试");
        }
        return result;
    }
    
    /**
      * 描述:<p>查询组织机构树</P>
      *
      * @author weihongjun
      * @return
      * @return List<TreeBean>
      * @throws
    */
    @RequestMapping("/loadCompanyTree")
    @ResponseBody
    public List<NodeTreeVo> loadCompanyTreee()
    {
       return null;
    }
    
    
    /**
      * 描述:<p>部门机构树</P>
      *
      * @author weihongjun
      * @return
      * @return List<Map<String,Object>>
      * @throws
    */
    @RequestMapping("/loadDepartTree")
    @ResponseBody
    public List<NodeTreeVo> loadDepartTree()
    {
        
        return null;
    }
    
    /**
      * 描述:<p>listAll</P>
      *
      * @author weihongjun
      * @return
      * @return List<SysDepartment>
      * @throws
    */
    @RequestMapping("/listAllDepart")
    @ResponseBody
    public List<SysDepartment> listAllDepart()
    {
        return sysDepartmentService.listAll(SysUserUtil.getCurrentCompanyId());
    }
    
    
    /**
      * 描述:<p>根据id查询部门</P>
      *
      * @author weihongjun
      * @param departId
      * @return
      * @return SysDepartment
      * @throws
    */
    @RequestMapping("/findDepartById")
    @ResponseBody
    public SysDepartment findDepartById(Long departId)
    {
        if(departId == null){
            return null;
        }
        return sysDepartmentService.findDepartmentById(departId);
    }
    
    /**
      * 描述:<p>验证员工信息</P>
      *
      * @author weihongjun
      * @param sysUser
      * @param result
      * @return void
      * @throws
    */
    private boolean userValidate(SysUser sysUser, RequestResult result)
    {
        if (Strings.isBlank(sysUser.getAccountName()))
        {
            result.setCode(CODE.FAIL.getCode());
            result.setMsg("保存员工失败：登录账号不能为空!");
            return false;
        }
        if (Strings.isBlank(sysUser.getName()))
        {
            result.setCode(CODE.FAIL.getCode());
            result.setMsg("保存员工失败：姓名不能为空!");
            return false;
        }
        if (Strings.isBlank(sysUser.getSex()))
        {
            result.setCode(CODE.FAIL.getCode());
            result.setMsg("保存员工失败：请选择性别!");
            return false;
        }
        
        if (sysUser.getEntryDate() == null)
        {
            result.setCode(CODE.FAIL.getCode());
            result.setMsg("保存员工失败：入职日期不能为空!");
            return false;
        }
        
        if (sysUser.getDepartmentId() == null)
        {
            result.setCode(CODE.FAIL.getCode());
            result.setMsg("保存员工失败：归属部门不能为空!");
            return false;
        }
        
        if (Strings.isBlank(sysUser.getCode()))
        {
            result.setCode(CODE.FAIL.getCode());
            result.setMsg("保存员工失败：工号不能为空!");
            return false;
        }
        
       
        return true;
    }
    
    
   
    
    /**
     * 描述:<p>设置list长度</P>
     *
     * @author weihongjun
     * @param binder
     * @return void
     * @throws
   */
   @InitBinder
   public void initBinder(WebDataBinder binder)
   {
       // 设置List的最大长度
       binder.setAutoGrowCollectionLimit(10000);
   }
    
}
