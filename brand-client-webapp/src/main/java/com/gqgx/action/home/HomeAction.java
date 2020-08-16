package com.gqgx.action.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gqgx.action.header.HeaderAction;

@RestController
public class HomeAction extends HeaderAction{

	@RequestMapping("/noPage")
	public ModelAndView noPage() {
		return new ModelAndView("/noPage");
	}

	@RequestMapping("/errors")
	public ModelAndView errors() {
		return new ModelAndView("/errors");
	}
}
