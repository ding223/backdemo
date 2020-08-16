package com.gqgx.action.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gqgx.common.entity.vo.CookieVo;
import com.gqgx.utils.CookieUtil;

@RestController
public class CookieAction {
	
	/**
	 * 获取存储的cookie列表
	 * @param request
	 * @param name
	 * @return
	 */
	@RequestMapping("/getCookieList-{name}")
	public List<CookieVo> getCookieList(HttpServletRequest request,@PathVariable String name){
		return CookieUtil.getCookieList(request, name);
	}

}
