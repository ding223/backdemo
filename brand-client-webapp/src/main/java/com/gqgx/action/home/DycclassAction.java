package com.gqgx.action.home;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gqgx.action.header.HeaderAction;
import com.gqgx.common.entity.BrandDycTypeItem;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.entity.vo.BrandDycTypeItemVo;
import com.gqgx.common.entity.vo.CookieVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandDycTypeItemService;
import com.gqgx.common.service.BrandLargeTypeService;
import com.gqgx.common.service.BrandNavItemService;
import com.gqgx.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DycclassAction extends HeaderAction{
	
	@Autowired
	private BrandLargeTypeService brandLargeTypeService;
	
	@Autowired
	private BrandDycTypeItemService brandDycTypeItemService;
	
	@Autowired
	private BrandNavItemService brandNavItemService;
	
	/**
	 * 自定义商标主页
	 * @param page
	 * @return
	 */
	@RequestMapping("/dycclass{navItemId}")
	public ModelAndView dycclass(LayuiPage page,Long largeTypeId,String filter,@PathVariable Long navItemId
			,HttpServletRequest request) {
		ModelAndView view = new ModelAndView("/dycclass");		
		setNiceclassData(page, largeTypeId, filter, view, navItemId, request);
		return view;
	}
	
	/**
	 * 自定义商标大类页
	 * @param page
	 * @return
	 */
	@RequestMapping("/dycclass{navItemId}/class{largeTypeId}")
	public ModelAndView dycclassByLargeType(LayuiPage page,@PathVariable Long largeTypeId,String filter
			,@PathVariable Long navItemId,HttpServletRequest request) {
		ModelAndView view = new ModelAndView("/dycclass");		
		setNiceclassData(page, largeTypeId, filter, view, navItemId, request);
		return view;
	}
	
	/**
	 * 自定义商标设置数据
	 * @param page
	 * @param typeId
	 * @param view
	 */
	private void setNiceclassData(LayuiPage page,Long largeTypeId,String filter,ModelAndView view,Long navItemId
			,HttpServletRequest request) {
		page.setLimit(60);
		
		//加载大类及子类
		BrandLargeType type = new BrandLargeType();
		view.addObject("largeTypeList",brandLargeTypeService.findBrandLargeTypeList(type));
		
		//加载大类详情
		if(null != largeTypeId) {
			view.addObject("largeType",brandLargeTypeService.getBrandLargeType(largeTypeId));
		}
		
		//加载导航
		if(null != navItemId) {
			view.addObject("navItem",brandNavItemService.getBrandNavItem(navItemId));
		}
		
		//加载列表项
		BrandDycTypeItemVo vo = new BrandDycTypeItemVo();
		
		if(null != largeTypeId) {
			vo.setLargeTypeId(largeTypeId);
		}
		
		if(null != navItemId) {
			vo.setNavItemId(navItemId);
		}
		
		if(!StringUtils.isEmpty(filter)) {
			vo.setFilter(filter);
			view.addObject("filter",filter.trim());
		}
		
		List<CookieVo> list = new ArrayList<CookieVo>();
		String nicelist = CookieUtil.getCookieValue(request, "dycclass"+navItemId);
		if(!StringUtils.isEmpty(nicelist)) {
			list = JSONArray.parseArray(nicelist,CookieVo.class);
		}
		view.addObject("dycCookieList",list);
		
		PagingResult<BrandDycTypeItem> itemList = brandDycTypeItemService.findBrandDycTypeItemList(vo,page);
		view.addObject("smallTypeItemList",itemList.getResult());
		page.setTotal(itemList.getTotalCount());
		view.addObject("total",itemList.getTotalCount());
		view.addObject("currentPage",page.getPage());
	}
	
	/**
	 * 勾选自定义商标项
	 * @param response
	 * @param request
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/setDycClassCookie-{navItemId}")
	public int setDycClassCookie(HttpServletResponse response,HttpServletRequest request,CookieVo vo,@PathVariable Long navItemId) {
		List<CookieVo> list = new ArrayList<CookieVo>();
		String nicelist = CookieUtil.getCookieValue(request, "dycclass"+navItemId);
		if(!StringUtils.isEmpty(nicelist)) {
			list = JSONArray.parseArray(nicelist,CookieVo.class);
		}
		
		boolean addStatus = true;
		if(list != null && list.size() > 0) {
			for(CookieVo cookie : list) {
				if(cookie.getId() == vo.getId()) {
					addStatus = false;
				}
			}
			
		}
		if(addStatus) {
			CookieVo cookie = new CookieVo();
			cookie.setId(vo.getId());
			cookie.setName(java.net.URLEncoder.encode(vo.getName()));
			list.add(cookie);
		}
		CookieUtil.setCookie(response, "dycclass"+navItemId, JSON.toJSONString(list));
		return 1;
	}
	
	/**
	 * 取消勾选自定义商标项
	 * @param response
	 * @param request
	 * @param vo
	 * @return
	 */
	@RequestMapping("/cancelDycClassCookie/{id}/{navItemId}")
	public int cancelDycClassCookie(HttpServletResponse response,HttpServletRequest request,@PathVariable Long id,@PathVariable Long navItemId) {
		List<CookieVo> list = new ArrayList<CookieVo>();
		String nicelist = CookieUtil.getCookieValue(request, "dycclass"+navItemId);
		if(!StringUtils.isEmpty(nicelist)) {
			list = JSONArray.parseArray(nicelist,CookieVo.class);
			int rmindex = -1;
			if(list != null && list.size() > 0) {
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getId().intValue() == id.intValue()) {
						rmindex = i;
					}
				}
				
			}
			if(rmindex > -1) list.remove(rmindex);
			CookieUtil.setCookie(response, "dycclass"+navItemId, JSON.toJSONString(list));
		}
		
		return 1;
	}

}
