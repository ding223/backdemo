package com.gqgx.action.home;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gqgx.action.header.HeaderAction;
import com.gqgx.common.entity.BrandEuroTypeItem;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.entity.vo.BrandEuroTypeItemVo;
import com.gqgx.common.entity.vo.CookieVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandEuroTypeItemService;
import com.gqgx.common.service.BrandLargeTypeService;
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
public class EuroclassAction extends HeaderAction{
	
	@Autowired
	private BrandLargeTypeService brandLargeTypeService;
	
	@Autowired
	private BrandEuroTypeItemService brandEuroTypeItemService;
	
	/**
	 * 欧盟商标主页
	 * @param page
	 * @return
	 */
	@RequestMapping("/euroclass")
	public ModelAndView euroclass(LayuiPage page,Long largeTypeId,String filter,HttpServletRequest request) {
		ModelAndView view = new ModelAndView("/euroclass");		
		setEuroclassData(page, largeTypeId, filter, view, request);
		return view;
	}
	
	/**
	 * 欧盟商标大类页
	 * @param page
	 * @return
	 */
	@RequestMapping("/euroclass/class{largeTypeId}")
	public ModelAndView euroclassByLargeType(LayuiPage page,@PathVariable Long largeTypeId,String filter,HttpServletRequest request) {
		ModelAndView view = new ModelAndView("/euroclass");		
		setEuroclassData(page, largeTypeId, filter, view, request);
		return view;
	}
	
	/**
	 * 欧盟设置数据
	 * @param page
	 * @param typeId
	 * @param view
	 */
	private void setEuroclassData(LayuiPage page,Long largeTypeId,String filter,ModelAndView view,HttpServletRequest request) {
		page.setLimit(60);
		
		//加载大类及子类
		BrandLargeType type = new BrandLargeType();
		view.addObject("largeTypeList",brandLargeTypeService.findBrandLargeTypeList(type));
		
		//加载大类详情
		if(null != largeTypeId) {
			view.addObject("largeType",brandLargeTypeService.getBrandLargeType(largeTypeId));
		}
		
		//加载列表项
		BrandEuroTypeItemVo vo = new BrandEuroTypeItemVo();
		
		if(null != largeTypeId) {
			vo.setLargeTypeId(largeTypeId);
		}
		
		if(!StringUtils.isEmpty(filter)) {
			vo.setFilter(filter);
			view.addObject("filter",filter.trim());
		}
		
		List<CookieVo> list = new ArrayList<CookieVo>();
		String nicelist = CookieUtil.getCookieValue(request, "euroclass");
		if(!StringUtils.isEmpty(nicelist)) {
			list = JSONArray.parseArray(nicelist,CookieVo.class);
		}
		view.addObject("euroCookieList",list);
		
		PagingResult<BrandEuroTypeItem> itemList = brandEuroTypeItemService.findBrandEuroTypeItemList(vo,page);
		view.addObject("smallTypeItemList",itemList.getResult());
		page.setTotal(itemList.getTotalCount());
		view.addObject("total",itemList.getTotalCount());
		view.addObject("currentPage",page.getPage());
	}

	/**
	 * 勾选欧盟商标项
	 * @param response
	 * @param request
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/setEuroClassCookie")
	public int setEuroClassCookie(HttpServletResponse response,HttpServletRequest request,CookieVo vo) {
		List<CookieVo> list = new ArrayList<CookieVo>();
		String nicelist = CookieUtil.getCookieValue(request, "euroclass");
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
		CookieUtil.setCookie(response, "euroclass", JSON.toJSONString(list));
		return 1;
	}
	
	/**
	 * 取消勾选欧盟商标项
	 * @param response
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/cancelEuroClassCookie/{id}")
	public int cancelEuroClassCookie(HttpServletResponse response,HttpServletRequest request,
									 @PathVariable Long id) {
		List<CookieVo> list = new ArrayList<CookieVo>();
		String nicelist = CookieUtil.getCookieValue(request, "euroclass");
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
			CookieUtil.setCookie(response, "euroclass", JSON.toJSONString(list));
		}
		
		return 1;
	}
}
