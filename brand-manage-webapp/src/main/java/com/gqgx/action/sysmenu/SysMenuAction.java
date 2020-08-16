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
import com.gqgx.common.entity.vo.SortableVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**菜单管理
 * @author Administrator
 */
@Controller
@RequestMapping("/menu")
public class SysMenuAction
{
    @Autowired
    private SysMenuService sysMenuService;
    
    
    @RequestMapping("/sysMenuIndex")
    public ModelAndView index()
    {
        return new ModelAndView("/sysmenu/sysMenuIndex");
    }
    
    /**
	 * 排序列表
	 * @return
	 */
	@RequestMapping("/sortableList")
	public @ResponseBody List<SortableVo> sortableList()
	{
		return sysMenuService.sortableList();
	}
	
	
	/**
	 * @param sysUser
	 * @return
	 * @author weihongjun
	 */
	@RequestMapping("/addParmenu")
	public  ModelAndView addParmenu(Long id)
	{
		ModelAndView view=new ModelAndView("/sysmenu/addParmenu");
		if(!Objects.isEmpty(id)){
			SysMenu sysMenu = sysMenuService.getSysMenu(id);
			view.addObject("menuObj", sysMenu);
		}
		return view;
	}
	
	@RequestMapping("/saveSysMenu")
	public @ResponseBody int saveSysMenu(SysMenu sysMenu){
		if(Objects.isEmpty(sysMenu.getSort()))
		{
			int maxSort=sysMenuService.maxSort()+1;
			sysMenu.setSort( (short) maxSort);
		}
		int count= sysMenuService.saveSysMenu(sysMenu);
		return count;
	}
	
	@RequestMapping("/delSysMenu")
	public @ResponseBody int delSysMenu(SysMenu sysMenu){
		int count= sysMenuService.deleteSysMenu(sysMenu);
		return count;
	}
	
	@RequestMapping("/reSortable")
	public @ResponseBody int reSortable(String ids){
		return sysMenuService.reSortable(ids);
	}
	
	@RequestMapping("/parList")
	public   @ResponseBody List<SysMenu> parList(){
		List<SysMenu>  menuList=sysMenuService.parList();
		return menuList;
	}
	
	/**
	 * 添加二级菜单
	 * @param sysUser
	 * @return
	 * @author weihongjun
	 */
	@RequestMapping("/addChildmenu")
	public  ModelAndView addChildmenu(SysMenu sysMenu)
	{
		ModelAndView view=new ModelAndView("/sysmenu/addChildmenu");
		view.addObject("parentId", sysMenu.getParentId());
		List<SysMenu>  menuList=sysMenuService.parList();
		if(!Objects.isEmpty(sysMenu.getId())){
			SysMenu menuObj = sysMenuService.getSysMenu(sysMenu.getId());
			view.addObject("parentId", menuObj.getParentId());
			view.addObject("menuObj", menuObj);
		}
		view.addObject("menuList", menuList);
		return view;
	}
}
