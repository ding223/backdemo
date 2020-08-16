package com.gqgx.action.organization;

import com.gqgx.common.entity.*;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysMenuService;
import com.gqgx.common.service.SysPositionMenuService;
import com.gqgx.common.service.SysPositionService;
import com.gqgx.domain.LayUiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


/**职位管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/position")
public class SysPositionAction {

	@Autowired
	private SysPositionService sysPositionService;
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@Autowired
	private SysPositionMenuService sysPositionMenuService;
	
	/**
	 * 职位列表
	 * @return
	 */
	@RequestMapping("/positionIndex")
	public ModelAndView positionIndex(){
		ModelAndView view=new ModelAndView("/user/positionIndex");
		return view;
	}

	/**
	 * 员工列表
	 * @return
	 * @author weihongjun
	 */
	@RequestMapping("/positionList")
	@ResponseBody
	public LayUiResult<SysPosition> positionList(SysPosition sysPosition,LayuiPage page){
		PagingResult<SysPosition> positionList=sysPositionService.positionList(sysPosition, page);
		LayUiResult<SysPosition> layUiResult = new LayUiResult<SysPosition>(positionList);
        return layUiResult;
	}
	
	/**
	 * 编辑职位
	 * @return
	 */
	@RequestMapping("/editPosition")
	public ModelAndView  editPosition(Long id){
		ModelAndView view=new ModelAndView("/user/addPosition");
		if(!Objects.isEmpty(id)){
			SysPosition sysPosition = sysPositionService.getSysPosition(id);
			view.addObject("sysPosition", sysPosition);
		}
		return view;
	}
	
	/**
	 * 保存职位
	 * @param sysPosition
	 * @return
	 */
	@RequestMapping("/savePosition")
	@ResponseBody
	public int savePosition(SysPosition sysPosition){
		return sysPositionService.saveSysPosition(sysPosition);
	}
	
	/**
	 * 删除职位
	 * @param sysPosition
	 * @return
	 */
	@RequestMapping("/delPosition")
	@ResponseBody
	public int delPosition(SysPosition sysPosition){
		return sysPositionService.deleteSysPosition(sysPosition);
	}
	
	/**
	 * 设置权限
	 * @return
	 */
	@RequestMapping("/setPower")
	public ModelAndView  setPower(Long id){
		ModelAndView view=new ModelAndView("/user/setPower");
		view.addObject("postionId",id);
		List<SysMenu> powerList=sysMenuService.menuLPowerist(id);
		view.addObject("powerList", powerList);
		return view;
	}
	
	/**
	 * 保存权限
	 * @param permissionVO
	 * @return
	 */
	@RequestMapping("/savePostionPermmistion")
    @ResponseBody
    public int savePostionPermmistion(PostionPermissionVO permissionVO)
    {
		try {
			Long postionId = permissionVO.getPostionId();
	        
	        //处理菜单权限
	        List<SysPositionMenu> menus = null;
	        List<SysMenu> sysMenus = permissionVO.getMenus();
	        if (!Objects.isEmpty(sysMenus)){
	            menus = new ArrayList<SysPositionMenu>();
	            for (int i = 0; i < sysMenus.size(); i++){
	                if (sysMenus.get(i).getId() == null) continue;
	                SysPositionMenu temp = new SysPositionMenu();
	                temp.setMenuId(sysMenus.get(i).getId());
	                temp.setPositionId(postionId);
	                menus.add(temp);
	            }
	        }
	        
	        //处理按钮权限
	        List<SysPositionOperation> menusOptions = null;
	        List<SysMenuOperation> sysMenusOptions = permissionVO.getOperations();
	        if (!Objects.isEmpty(sysMenusOptions)){
	            menusOptions = new ArrayList<SysPositionOperation>();
	            for (int i = 0; i < sysMenusOptions.size(); i++){
	                if (sysMenusOptions.get(i).getId() == null) continue;
	                SysPositionOperation temp = new SysPositionOperation();
	                temp.setMenuId(sysMenusOptions.get(i).getMenuId());
	                temp.setPositionId(postionId);
	                temp.setMenuOperationId(sysMenusOptions.get(i).getId());
	                menusOptions.add(temp);
	            }
	        }
	        
	        sysPositionMenuService.savePostionPermisstion(postionId,menus,menusOptions);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return 1;
    }
    
}
