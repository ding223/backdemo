package com.gqgx.action.brand;

import com.gqgx.common.entity.BrandSmallType;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandLargeTypeService;
import com.gqgx.common.service.BrandSmallTypeService;
import com.gqgx.domain.LayUiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("brandSmallType")
public class BrandSmallTypeAction {
	
	/**
	 * 小类业务接口
	 */
	@Autowired
	private BrandSmallTypeService brandSmallTypeService;
	
	/**
	 * 商标大类业务接口
	 */
	@Autowired
	private BrandLargeTypeService brandLargeTypeService;
	
	/**
	 * 小类列表页
	 * @return
	 */
	@RequestMapping("/gnSmallTypeListView")
	public ModelAndView gnSmallTypeListView(){
		ModelAndView view = new ModelAndView("/generalNice/gnSmallTypeList");
		return view;
	}
	
	/**
	 * 小类列表数据
	 */
	@RequestMapping("/gnSmallTypeListData")
	@ResponseBody
	public LayUiResult<BrandSmallType> gnSmallTypeListData(BrandSmallType SmallType,LayuiPage page){
		PagingResult<BrandSmallType> list = brandSmallTypeService.findBrandSmallType(SmallType, page);
        return new LayUiResult<BrandSmallType>(list);
	}
	
	/**
	 * 小类 新增、修改界面
	 */
	@RequestMapping("/addGnSmallTypeView")
	public ModelAndView addGnSmallTypeView(BrandSmallType SmallType) {
		ModelAndView view = new ModelAndView("/generalNice/addGnSmallType");
		if(!Objects.isEmpty(SmallType.getId())) {
			view.addObject("smallType",brandSmallTypeService.getBrandSmallType(SmallType.getId()));
		}
		view.addObject("largeTypes",brandLargeTypeService.findBrandLargeTypeList(null));
		return view;
	}
	
	/**
	 * 保存小类
	 */
	@RequestMapping("/saveGnSmallType")
	public int saveGnSmallType(BrandSmallType SmallType) {
		return brandSmallTypeService.saveBrandSmallType(SmallType);
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delGnSmallType")
	public int delGnSmallType(BrandSmallType SmallType) {
		return brandSmallTypeService.deleteBrandSmallType(SmallType);
	}
}
