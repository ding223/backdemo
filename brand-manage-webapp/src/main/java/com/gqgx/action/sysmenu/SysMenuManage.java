/**
 * 描述:<p></p>
 * @Title: SysMenuManage.java
 * @Package com.gqgx.action.sysmenu
 * 
 * @author weihongjun
 * @date 2016年12月27日 上午11:11:28
*/


package com.gqgx.action.sysmenu;

import com.gqgx.common.entity.SysMenu;
import com.gqgx.common.entity.SysPosition;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.entity.vo.NodeTreeVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.lang.Strings;
import com.gqgx.common.paging.Page;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.*;
import com.gqgx.domain.GridResult;
import com.gqgx.domain.RequestResult;
import com.gqgx.domain.RequestResult.CODE;
import com.gqgx.utils.SysUserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 描述:<p></p>
 * @ClassName: SysMenuManage
 * @author weihongjun
 * @date 2016年12月27日 上午11:11:28
 *
*/
@Controller
@RequestMapping("/menuManage")
public class SysMenuManage
{
    private Logger logger = LoggerFactory.getLogger(SysMenuManage.class);
    
    @Autowired
    private SysMenuService sysMenuService;
    
    
    @Autowired
    private SysPositionService sysPositionService;
    
    @Autowired
    private SysDepartmentService sysDepartmentService;
    
    @Autowired
    private SysUserService sysUserService;
    
    @Autowired
    private SysUserPositionService sysUserPositionService;
    
    @RequestMapping("/init")
    public ModelAndView index()
    {
        return new ModelAndView("/menuManage/menuManage");
    }
    
    /**
      * 描述:<p>加载菜单树</P>
      *
      * @author weihongjun
      * @return
      * @return List<Map<String,Object>>
      * @throws
    */
    @RequestMapping("/loadSysMenuTree")
    @ResponseBody
    public List<NodeTreeVo> loadSysMenuTree()
    {
        Long companyId = SysUserUtil.getCurrentCompanyId();
        return sysMenuService.findAll(companyId);
    }
    
    /**
      * 描述:<p>查询职位列表</P>
      *
      * @author weihongjun
      * @param request
      * @param sysPosition
      * @param page
      * @return
      * @return GridResult<SysPosition>
      * @throws
    */
    @RequestMapping("/findSysPositionList")
    @ResponseBody
    public GridResult<SysPosition> findSysPositionList(HttpServletRequest request, SysPosition sysPosition, Page page)
    {
    	sysPosition.setCompanyId(SysUserUtil.getCurrentCompanyId());
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
      * 描述:<p>更具id删除职位</P>
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
    @RequestMapping("/deletePositionMenuByIds")
    @ResponseBody
    public RequestResult deletePositionMenuByIds(Long menuId,String positionIds)
    {
    	RequestResult result = new RequestResult();
    	try
    	{
    		if (Strings.isBlank(positionIds))
    		{
    			result.setCode(CODE.FAIL.getCode());
    			result.setMsg("删除职位失败：请选择要删除的数据!");
    			return result;
    		}
    		String[] idsStr = positionIds.split(",");
    		Long[] delIds = new Long[idsStr.length];
    		for (int i = 0; i < idsStr.length; i++)
    		{
    			delIds[i] = Long.valueOf(idsStr[i]);
    		}
    		//int count =positionMenuService.deletePositionMenuByIds(menuId, delIds);
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
    
    
    /**
      * 描述:<p>根据id删除</P>
      *
      * @author weihongjun
      * @param ids
      * @return
      * @return RequestResult
      * @throws
    */
    @RequestMapping("/deleteSysMenuById")
    @ResponseBody
    public RequestResult deleteSysMenuById(String ids)
    {
        RequestResult result = new RequestResult();
        try
        {
            if (Strings.isBlank(ids))
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("删除菜单失败：请选择要删除的数据!");
                return result;
            }
            String[] idsStr = ids.split(",");
            Long[] delIds = new Long[idsStr.length];
            for (int i = 0; i < idsStr.length; i++)
            {
                delIds[i] = Long.valueOf(idsStr[i]);
            }
            int count = sysMenuService.deleteSysMenuByIds(delIds);
            if (count > 0)
            {
                result.setCode(CODE.SUCCESS.getCode());
                result.setMsg("删除菜单成功");
                result.addModel("delCount", count);
            }
            else
            {
                result.setCode(CODE.FAIL.getCode());
                result.setMsg("删除菜单失败：系统异常，请稍后再试");
            }
        }
        catch (Exception e)
        {
            logger.error("[删除菜单信息异常：]", e);
            result.setCode(CODE.ERROR.getCode());
            result.setMsg("删除菜单失败：系统异常，请稍后再试");
        }
        return result;
    }
    
    
    /**
      * 描述:<p>新增职位页面</P>
      *
      * @author weihongjun
      * @param request
      * @param postionId
      * @return
      * @return ModelAndView
      * @throws
    */
    @RequestMapping("/postionPage")
    public ModelAndView postionPage(HttpServletRequest request, Long postionId)
    {
        ModelAndView view = new ModelAndView("/companyManage/postionPage");
        if (postionId != null)
        {
            view.addObject("postion", sysPositionService.findPositionById(postionId, SysUserUtil.getCurrentCompanyId()));
        }
        return view;
    }
    
    /**
      * 描述:<p>新增或修改菜单</P>
      *
      * @author weihongjun
      * @param request
      * @param postionId
      * @param menuType
      * @return
      * @return ModelAndView
      * @throws
    */
    @RequestMapping("/addMenuPage")
    public ModelAndView addMenuPage(HttpServletRequest request, Long selSysMenuId, String menuType)
    {
        ModelAndView view = new ModelAndView("/menuManage/addMenuPage");
        SysMenu sysMenu = null;
        SysMenu parent = null;
        // 1：新增，2修改
        if ("2".equals(menuType))
        {
            if (selSysMenuId != null)
            {
                sysMenu = sysMenuService.getSysMenu(selSysMenuId);
                if (sysMenu.getParentId() != null)
                {
                    parent = sysMenuService.getSysMenu(sysMenu.getParentId());
                }
            }
            view.addObject("sysMenuInfo", sysMenu);
            view.addObject("parentMenu", parent);
        }
        else
        {
            if (selSysMenuId != null)
            {
                parent = sysMenuService.getSysMenu(selSysMenuId);
            }
            view.addObject("parentMenu", parent);
        }
        return view;
    }
    

    /**
      * 描述:<p>postionUserList</P>
      *
      * @author weihongjun
      * @param request
      * @param selSysMenuId
      * @return
      * @return ModelAndView
      * @throws
    */
    @RequestMapping("/postionUserList")
    public ModelAndView postionUserList(HttpServletRequest request, Long postionId)
    {
        ModelAndView view = new ModelAndView("/menuManage/postionUser");
        view.addObject("postionId", postionId);
        return view;
    }
    
    
    @RequestMapping("/findSysUserList")
    @ResponseBody
    public GridResult<SysUser> findSysUserList(HttpServletRequest request, SysUser sysUser, Page page)
    {
        try
        {
            sysUser.setCompanyId(SysUserUtil.getCurrentCompanyId());
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
      * 描述:<p>deleteUserPostion</P>
      *
      * @author weihongjun
      * @param positionId
      * @param userIds
      * @return
      * @return RequestResult
      * @throws
    */
    @RequestMapping("/deleteUserPostion")
    @ResponseBody
    public RequestResult deleteUserPostion(Long positionId, String userIds)
    {
        RequestResult result = new RequestResult();
        try
        {
            if (Strings.isBlank(userIds) || positionId == null)
            {
                result.setMsg("删除用户职位失败");
                result.setCode(CODE.FAIL.getCode());
                return result;
            }
            String[] idArray = userIds.split(",");
            Long[] ids = new Long[idArray.length];
            for (int i = 0; i < idArray.length; i++)
            {
                ids[i] = Long.valueOf(idArray[i]);
            }
            int count = sysUserPositionService.deleteUserPosition(positionId, ids);
            if (count > 0)
            {
                result.setMsg("删除用户职位成功");
                result.setCode(CODE.SUCCESS.getCode());
            }
            else
            {
                result.setMsg("删除用户职位失败");
                result.setCode(CODE.FAIL.getCode());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("[删除用户职位失败:]", e);
            result.setMsg("删除用户职位失败");
            result.setCode(CODE.FAIL.getCode());
        }
        return result;
    }
    
    
    /**
      * 描述:<p>保存菜单</P>
      *
      * @author weihongjun
      * @param sysMenu
      * @return
      * @return RequestResult
      * @throws
    */
    @RequestMapping("/saveSysMenu")
    @ResponseBody
    public RequestResult saveSysMenu(SysMenu sysMenu)
    {
        RequestResult result = new RequestResult();
        try
        {
            sysMenu.setCompanyId(SysUserUtil.getCurrentCompanyId());
            if (Strings.isBlank(sysMenu.getName()))
            {
                result.setMsg("菜单名称不能为空");
                result.setCode(CODE.FAIL.getCode());
                return result;
            }
            if (Strings.isBlank(sysMenu.getCode()))
            {
                result.setMsg("菜单编码不能为空");
                result.setCode(CODE.FAIL.getCode());
                return result;
            }
            if (sysMenuService.isExsit(sysMenu) > 0 && Objects.isEmpty(sysMenu.getId()))
            {
                result.setMsg("菜单编码已经存在");
                result.setCode(CODE.FAIL.getCode());
                return result;
            }
            int count = sysMenuService.saveOrUpdateMenu(sysMenu);
            if (count > 0)
            {
                result.setMsg("保存成功");
                result.setCode(CODE.SUCCESS.getCode());
            }
            else
            {
                result.setMsg("保存失败");
                result.setCode(CODE.FAIL.getCode());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("[保存菜单异常：]", e);
            result.setMsg("保存失败");
            result.setCode(CODE.FAIL.getCode());
        }
        return result;
    }
}
