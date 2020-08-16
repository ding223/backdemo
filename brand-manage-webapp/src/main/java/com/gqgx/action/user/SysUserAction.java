package com.gqgx.action.user;

import com.gqgx.common.entity.SysDepartment;
import com.gqgx.common.entity.SysPosition;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.entity.vo.SysPositionVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.lang.util.MD5Utils;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysDepartmentService;
import com.gqgx.common.service.SysPositionService;
import com.gqgx.common.service.SysUserService;
import com.gqgx.domain.LayUiResult;
import com.gqgx.utils.SysUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**用户管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/user")
public class SysUserAction {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysDepartmentService sysDepartmentService;
	@Autowired
	private SysPositionService sysPositionService;
	/**
	 * 分配处理人
	 * @return
	 */
	@RequestMapping("/userIndex")
	public ModelAndView userIndex(String userType)
	{
		ModelAndView view=new ModelAndView("/user/userIndex");
		return view;
	}
	
	

	/**
	 * 员工列表
	 * @return
	 * @author weihongjun
	 */
	@RequestMapping("/userList")
	@ResponseBody
	public LayUiResult<SysUser> userList(SysUser sysUser,LayuiPage page)
	{
		PagingResult<SysUser> userList = sysUserService.userList(sysUser,page);
		LayUiResult<SysUser> layUiResult = new LayUiResult<SysUser>(userList);
        return layUiResult;
	}
	
	
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("/addUser")
	public ModelAndView addUser(Long id)
	{
		ModelAndView view=new ModelAndView("/user/addUser");
		if(!Objects.isEmpty(id)){
			SysUser sysUser = sysUserService.getSysUser(id);
			view.addObject("sysUser", sysUser);
			List<SysPositionVo> positions= sysPositionService.findPositionList(id);
			view.addObject("positions", positions);
		}else{
			List<SysPosition> positions= sysPositionService.findBySysPosition(null);
			view.addObject("positions", positions);
		}
		List<SysDepartment> departmentList=sysDepartmentService.departmentList();
		view.addObject("departmentList", departmentList);
		
		return view;
	}
	
	/**
	 * 保存用户
	 * @return
	 */
	@RequestMapping("/saveUser")
	@ResponseBody
	public int saveUser(SysUser sysUser)
	{
		return sysUserService.addOrUpdateSysUser(sysUser);
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	@RequestMapping("/delUser")
	@ResponseBody
	public int delUser(SysUser sysUser)
	{
		return sysUserService.deleteSysUser(sysUser);
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("/setPassword")
	public ModelAndView setPassword(Long id)
	{
		ModelAndView view=new ModelAndView("/user/setPassword");
		SysUser sysUser = sysUserService.getSysUser(id);
		view.addObject("sysUser", sysUser);
		return view;
	}
	
	/**
	 * 设置密码
	 * @return
	 */
	@RequestMapping("/savePassword")
	@ResponseBody
	public int savePassword(SysUser sysUser)
	{
		String passWord = sysUser.getPassWord();
		sysUser.setPassWord(MD5Utils.encryptMD5(passWord));
		return sysUserService.saveSysUser(sysUser);
	}
	
	/**
	 * 我的信息
	 * @return
	 */
	@RequestMapping("/myInfo")
	public ModelAndView myInfo(){
		SysUser user = SysUserUtil.getCurrentUser();
		ModelAndView view=new ModelAndView("/user/myInfo");
		SysUser sysUser = sysUserService.getSysUser(user.getId());
		view.addObject("sysUser", sysUser);
		List<SysPositionVo> positions= sysPositionService.findPositionList(user.getId());
		view.addObject("positions", positions);
		view.addObject("department", sysDepartmentService.getSysDepartment(sysUser.getDepartmentId()));
		return view;
	}
	
	/**
	 * 设置密码
	 * @param request
	 * @param userId
	 * @return
	 */
	@RequestMapping("/settingPassWord")
    public ModelAndView settingPassWord(HttpServletRequest request, Long userId){
        ModelAndView view =  new ModelAndView("/user/editMyPassWord");
        view.addObject("sysUser", sysUserService.getSysUser(userId));
        return view;
    }
    
    /**
     * 保存设置的新密码
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/savePassWord")
    @ResponseBody
    public int savePassWord(HttpServletRequest request, SysUser user){
    	if(sysUserService.validPass(user.getId(), MD5Utils.encryptMD5(user.getOldPassWord()))) {
    		String pass = MD5Utils.encryptMD5(user.getPassWord());
    		user.setPassWord(pass);
    		int count = sysUserService.saveSysUser(user);
            return count;
    	} else {
    		return 100;
    	}
    }
    
	
}
