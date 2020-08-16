package com.gqgx.action.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gqgx.action.header.HeaderAction;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.service.BrandLargeTypeService;
import com.gqgx.common.service.BrandRussiaTypeItemService;

@RestController
public class RussiaclassAction extends HeaderAction{
	
	@Autowired
	private BrandLargeTypeService brandLargeTypeService;
	
	@Autowired
	private BrandRussiaTypeItemService brandRussiaTypeItemService;
	
	/**
	 * 俄罗斯商标主页
	 * @param page
	 * @return
	 */
	@RequestMapping("/russiaclass")
	public ModelAndView russiaclass(Long largeTypeId) {
		ModelAndView view = new ModelAndView("/russiaclass");		
		setRussiaclassData(largeTypeId, view);
		return view;
	}
	
	/**
	 * 俄罗斯商标大类页
	 * @param page
	 * @return
	 */
	@RequestMapping("/russiaclass/class{largeTypeId}")
	public ModelAndView russiaclassByLargeType(@PathVariable Long largeTypeId) {
		ModelAndView view = new ModelAndView("/russiaclass");		
		setRussiaclassData(largeTypeId, view);
		return view;
	}
	
	/**
	 * 俄罗斯设置数据
	 * @param page
	 * @param typeId
	 * @param view
	 */
	private void setRussiaclassData(Long largeTypeId,ModelAndView view) {
		
		//加载大类及子类
		BrandLargeType type = new BrandLargeType();
		view.addObject("largeTypeList",brandLargeTypeService.findBrandLargeTypeList(type));
		
		//加载大类详情
		if(null != largeTypeId) {
			view.addObject("largeType",brandLargeTypeService.getBrandLargeType(largeTypeId));
			//加载列表项
			view.addObject("article",brandRussiaTypeItemService.findBrandRussiaTypeItemByLargeId(largeTypeId));
		}
		
	}

}
