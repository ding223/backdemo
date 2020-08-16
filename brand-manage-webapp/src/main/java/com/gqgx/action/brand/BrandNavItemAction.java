package com.gqgx.action.brand;

import com.gqgx.common.entity.BrandNavItem;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandNavItemService;
import com.gqgx.domain.LayUiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("navItem")
public class BrandNavItemAction {
	
	/**
	 * 商标导航业务类
	 */
	@Autowired
	private BrandNavItemService brandNavItemService;
	
	/**
	 * 商标导航列表页
	 * @return
	 */
	@RequestMapping("/navItemListView")
	public ModelAndView navItemListView(){
		ModelAndView view = new ModelAndView("/navItem/navItemList");
		return view;
	}
	
	/**
	 * 商标导航列表数据
	 */
	@RequestMapping("/navItemListData")
	@ResponseBody
	public LayUiResult<BrandNavItem> navItemListData(BrandNavItem item,LayuiPage page){
		item.setUpdateStatus("0");
		PagingResult<BrandNavItem> list = brandNavItemService.findBrandNavItem(item, page);
        return new LayUiResult<BrandNavItem>(list);
	}
	
	/**
	 * 商标导航 新增、修改界面
	 */
	@RequestMapping("/addNavItemView")
	public ModelAndView addNavItemView(BrandNavItem item) {
		ModelAndView view = new ModelAndView("/navItem/addNavItem");
		if(!Objects.isEmpty(item.getId())) {
			view.addObject("item",brandNavItemService.getBrandNavItem(item.getId()));
		}else {
			view.addObject("maxSeq",brandNavItemService.getMaxSeq());
		}
		return view;
	}
	
	/**
	 * 保存商标导航
	 */
	@RequestMapping("/saveNavItem")
	public int saveNavItem(BrandNavItem item) {
		item.setUpdateStatus("0");
		item.setUrl("dycclass");
		if(Objects.isEmpty(item.getId())) item.setShowStatus("0");
		return brandNavItemService.saveBrandNavItem(item);
	}
	
	/**
	 * 删除商标导航
	 */
	@RequestMapping("/delNavItem")
	public int delNavItem(BrandNavItem largeType) {
		return brandNavItemService.deleteBrandNavItem(largeType);
	}
}
