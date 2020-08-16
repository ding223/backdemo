package com.gqgx.action.brand;

import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandLargeTypeService;
import com.gqgx.domain.LayUiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 商标大类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/brandLargeType")
public class BrandLargeTypeAction {
	
	/**
	 * 商标大类业务接口
	 */
	@Autowired
	private BrandLargeTypeService brandLargeTypeService;
	
	/**
	 * 商标大类列表页
	 * @return
	 */
	@RequestMapping("/gnLargeTypeListView")
	public ModelAndView gnLargeTypeListView(){
		ModelAndView view = new ModelAndView("/generalNice/gnLargeTypeList");
		return view;
	}
	
	/**
	 * 商标大类列表数据
	 */
	@RequestMapping("/gnLargeTypeListData")
	@ResponseBody
	public LayUiResult<BrandLargeType> gnLargeTypeListData(BrandLargeType largeType,LayuiPage page){
		PagingResult<BrandLargeType> list = brandLargeTypeService.findBrandLargeType(largeType, page);
        return new LayUiResult<BrandLargeType>(list);
	}
	
	/**
	 * 商标大类 新增、修改界面
	 */
	@RequestMapping("/addGnLargeTypeView")
	public ModelAndView addGnLargeTypeView(BrandLargeType largeType) {
		ModelAndView view = new ModelAndView("/generalNice/addGnLargeType");
		if(!Objects.isEmpty(largeType.getId())) {
			view.addObject("largeType",brandLargeTypeService.getBrandLargeType(largeType.getId()));
		}
		return view;
	}
	
	/**
	 * 保存商标类
	 */
	@RequestMapping("/saveLargeType")
	public int saveLargeType(BrandLargeType largeType) {
		return brandLargeTypeService.saveBrandLargeType(largeType);
	}
	
	/**
	 * 删除商标类
	 */
	@RequestMapping("/delLargeType")
	public int delLargeType(BrandLargeType largeType) {
		return brandLargeTypeService.deleteBrandLargeType(largeType);
	}
}
