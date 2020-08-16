package com.gqgx.action.systemInfo;

import com.gqgx.common.entity.SysDefaultMenu;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.service.SysDefaultMenuService;
import com.gqgx.utils.SysUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/defaultMenu")
public class SysDefaultMenuAction {
	
	@Autowired
	private SysDefaultMenuService defaultMenuService;
	
	@RequestMapping("/page")
	public ModelAndView page() {
		ModelAndView view = new ModelAndView("/systemInfo/defaultMenu");
		SysUser user = SysUserUtil.getCurrentUser();
		SysDefaultMenu def = defaultMenuService.findByUser(user);
		if(def != null) {
			view.addObject("default", def);
		}
		view.addObject("user", user);
		return view;
	}
}
