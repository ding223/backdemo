package com.gqgx.action.brand;

import java.util.List;

import com.gqgx.common.entity.vo.BrandLargeTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.service.BrandLargeTypeService;

@RestController
@RequestMapping("/brandLargeType")
public class BrandLargeTypeAction {
	
	@Autowired
	private BrandLargeTypeService brandLargeTypeService;
	
	/**
	 * 获取商标大类列表
	 * @return
	 */
	@RequestMapping("/findBrandLargeTypeList")
	public List<BrandLargeType> findBrandLargeTypeList(BrandLargeType type){
		return brandLargeTypeService.findBrandLargeTypeList(type);
	}

}
