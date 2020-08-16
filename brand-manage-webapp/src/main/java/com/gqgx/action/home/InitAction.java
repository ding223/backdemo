package com.gqgx.action.home;

import com.gqgx.common.entity.SysDefaultMenu;
import com.gqgx.common.entity.SysMenu;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.service.SysDefaultMenuService;
import com.gqgx.common.service.SysMenuService;
import com.gqgx.utils.SysUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class InitAction {
	
	@Autowired
	private SysDefaultMenuService defaultMenuService;
	
	@Autowired
	private SysMenuService menuService;
	
	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest reuqest) {
		return this.index1(reuqest);
	}

	@RequestMapping("/index")
	public ModelAndView index1(HttpServletRequest reuqest) {
		ModelAndView view = new ModelAndView("/index");
		SysUser user = SysUserUtil.getCurrentUser();
		view.addObject("currentUser", user);
		return view;
	}
	
	@RequestMapping("/home/desk")
	public ModelAndView desk(HttpServletRequest reuqest) {
		ModelAndView view = new ModelAndView("/home/desk");
		return view;
	}

	@RequestMapping("/home/left")
	public ModelAndView left(HttpServletRequest reuqest) {
		ModelAndView view = new ModelAndView("/home/left");
		return view;
	}

	@RequestMapping("/home/top")
	public ModelAndView top(HttpServletRequest reuqest) {
		ModelAndView view = new ModelAndView("/home/top");
		return view;
	}

	@RequestMapping("/home/center")
	public ModelAndView center(HttpServletRequest reuqest) {
		ModelAndView view = new ModelAndView("/home/center");
		SysDefaultMenu def = defaultMenuService.findByUser(SysUserUtil.getCurrentUser());
		if (def == null) {
			view.addObject("defaultPath", "/workbench/myTask");
		} else {
			SysMenu menu = menuService.getSysMenu(def.getMenuId());
			view.addObject("defaultPath", menu.getUrl());
		}
		return view;
	}

	@RequestMapping("/home/bottom")
	public ModelAndView bottom(HttpServletRequest reuqest) {
		ModelAndView view = new ModelAndView("/home/bottom");
		return view;
	}

	@RequestMapping("/home/right")
	public ModelAndView right(HttpServletRequest reuqest) {
		ModelAndView view = new ModelAndView("/home/right");
		return view;
	}

	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest reuqest) {
		ModelAndView view = new ModelAndView("/home");
		return view;
	}

	@RequestMapping("/noPage")
	public ModelAndView noPage(HttpServletRequest reuqest) {
		ModelAndView view = new ModelAndView("/noPage");
		return view;
	}

	@RequestMapping("/errors")
	public ModelAndView errors(HttpServletRequest reuqest) {
		ModelAndView view = new ModelAndView("/errors");
		return view;
	}
}
