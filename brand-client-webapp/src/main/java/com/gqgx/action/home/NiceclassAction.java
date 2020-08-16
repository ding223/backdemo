package com.gqgx.action.home;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gqgx.action.header.HeaderAction;
import com.gqgx.common.entity.BrandGnSmalltypeItem;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.entity.BrandSmallType;
import com.gqgx.common.entity.vo.BrandGnSmalltypeItemVo;
import com.gqgx.common.entity.vo.CookieVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandGnSmalltypeItemService;
import com.gqgx.common.service.BrandLargeTypeService;
import com.gqgx.common.service.BrandSmallTypeService;
import com.gqgx.utils.CookieUtil;

@RestController
public class NiceclassAction extends HeaderAction{
	
	@Autowired
	private BrandLargeTypeService brandLargeTypeService;
	
	@Autowired
	private BrandGnSmalltypeItemService brandGnSmalltypeItemService;
	
	@Autowired
	private BrandSmallTypeService brandSmallTypeService;
	
	@RequestMapping("/")
	public ModelAndView index(LayuiPage page,Long largeTypeId,String smallNo,String filter,HttpServletRequest request) {
		return niceclass(page, largeTypeId, smallNo, filter, request);
	}
	
	/**
	 * 通用尼斯商标主页
	 * @param page
	 * @return
	 */
	@RequestMapping("/niceclass")
	public ModelAndView niceclass(LayuiPage page,Long largeTypeId,String smallNo,String filter,HttpServletRequest request) {
		ModelAndView view = new ModelAndView("/niceclass");		
		setNiceclassData(page, largeTypeId, smallNo, filter, view, request);
		return view;
	}
	
	/**
	 * 通用尼斯商标大类页
	 * @param page
	 * @return
	 */
	@RequestMapping("/niceclass/class{largeTypeId}")
	public ModelAndView niceclassByLargeType(LayuiPage page,@PathVariable Long largeTypeId,String smallNo,String filter
			,HttpServletRequest request) {
		ModelAndView view = new ModelAndView("/niceclass");		
		setNiceclassData(page, largeTypeId, smallNo, filter, view, request);
		return view;
	}
	
	/**
	 * 通用尼斯商标子类页
	 * @param page
	 * @return
	 */
	@RequestMapping("/niceclass/class{largeTypeId}/{smallNo}")
	public ModelAndView niceclassBySmallType(LayuiPage page,@PathVariable Long largeTypeId,@PathVariable String smallNo
			,String filter,HttpServletRequest request) {
		ModelAndView view = new ModelAndView("/niceclass");		
		setNiceclassData(page, largeTypeId, smallNo, filter, view, request);
		return view;
	}
	
	/**
	 * 通用尼斯设置数据
	 * @param page
	 * @param largeTypeId
	 * @param view
	 */
	private void setNiceclassData(LayuiPage page,Long largeTypeId,String smallNo,String filter,
			ModelAndView view,HttpServletRequest request) {
		page.setLimit(60);
		
		//加载大类及子类
		BrandLargeType type = new BrandLargeType();
		view.addObject("largeTypeList",brandLargeTypeService.findBrandLargeTypeList(type));
		
		//加载大类详情
		if(null != largeTypeId) {
			view.addObject("largeType",brandLargeTypeService.getBrandLargeType(largeTypeId));
		}
		
		//加载小类详情
		BrandSmallType smallType = null;
		if(null != smallNo) {
			smallType = brandSmallTypeService.getBrandSmallType(smallNo);
			view.addObject("smallType", smallType);
		}
		
		//加载通用尼斯列表项
		BrandGnSmalltypeItemVo vo = new BrandGnSmalltypeItemVo();
		
		if(null != largeTypeId) {
			vo.setLargeTypeId(largeTypeId);
		}
		
		if(null != smallType) {
			vo.setSmallTypeId(smallType.getId());
		}
		
		if(!StringUtils.isEmpty(filter)) {
			vo.setFilter(filter);
			view.addObject("filter",filter.trim());
		}
		
		List<CookieVo> list = new ArrayList<CookieVo>();
		String nicelist = CookieUtil.getCookieValue(request, "niceclass");
		if(!StringUtils.isEmpty(nicelist)) {
			list = JSONArray.parseArray(nicelist,CookieVo.class);
		}
		view.addObject("niceCookieList",list);
		
		PagingResult<BrandGnSmalltypeItem> itemList = brandGnSmalltypeItemService.findBrandGnSmalltypeItemList(vo,page);
		view.addObject("smallTypeItemList",itemList.getResult());
		page.setTotal(itemList.getTotalCount());
		view.addObject("total",itemList.getTotalCount());
		view.addObject("currentPage",page.getPage());
	}
	
	/**
	 * 勾选通用商标项
	 * @param response
	 * @param request
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/setNiceClassCookie")
	public int setNiceClassCookie(HttpServletResponse response,HttpServletRequest request,CookieVo vo) {
		try {
			List<CookieVo> list = new ArrayList<CookieVo>();
			String nicelist = CookieUtil.getCookieValue(request, "niceclass");
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
				cookie.setName(java.net.URLEncoder.encode(vo.getName(), "UTF-8"));
				list.add(cookie);
			}
			CookieUtil.setCookie(response, "niceclass", JSON.toJSONString(list));
			return 1;
		}catch (Exception e) {
			System.err.println("设置cookie值错误" + e.getMessage());
			return 0;
		}

	}
	
	/**
	 * 取消勾选通用商标项
	 * @param response
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/cancelNiceClassCookie/{id}")
	public int cancelNiceClassCookie(HttpServletResponse response,HttpServletRequest request,
									 @PathVariable Long id) {
		List<CookieVo> list = new ArrayList<CookieVo>();
		String nicelist = CookieUtil.getCookieValue(request, "niceclass");
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
			CookieUtil.setCookie(response, "niceclass", JSON.toJSONString(list));
		}
		
		return 1;
	}
}
