package com.gqgx.action.brand;

import com.gqgx.common.collection.Collections;
import com.gqgx.common.entity.BrandDycTypeItem;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.entity.BrandNavItem;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandDycTypeItemService;
import com.gqgx.common.service.BrandLargeTypeService;
import com.gqgx.common.service.BrandNavItemService;
import com.gqgx.domain.LayUiResult;
import com.gqgx.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("dycLargeTypeItem")
public class BrandDycLargetypeItemAction {
	
	/**
	 * 自定义商标项目业务类
	 */
	@Autowired
	private BrandDycTypeItemService brandDycTypeItemService;
	
	/**
	 * 商标大类业务接口
	 */
	@Autowired
	private BrandLargeTypeService brandLargeTypeService;
	
	/**
	 * 商标导航业务接口
	 */
	@Autowired
	private BrandNavItemService brandNavItemService;
	
	/**
	 * 自定义商标项目列表页
	 * @return
	 */
	@RequestMapping("/dycLargeTypeItemListView")
	public ModelAndView dycLargeTypeItemListView(){
		ModelAndView view = new ModelAndView("/dycBrand/dycLargeTypeItemList");
		BrandNavItem nav = new BrandNavItem();
		nav.setUpdateStatus("0");
		view.addObject("navItems",brandNavItemService.findBrandNavItemList(nav));
		return view;
	}
	
	/**
	 * 自定义商标项目列表数据
	 */
	@RequestMapping("/dycLargeTypeItemListData")
	@ResponseBody
	public LayUiResult<BrandDycTypeItem> dycLargeTypeItemListData(BrandDycTypeItem item,LayuiPage page){
		PagingResult<BrandDycTypeItem> list = brandDycTypeItemService.findBrandDycTypeItem(item, page);
        return new LayUiResult<BrandDycTypeItem>(list);
	}
	
	/**
	 * 自定义商标项目 新增、修改界面
	 */
	@RequestMapping("/addDycLargeTypeItemView")
	public ModelAndView addDycLargeTypeItemView(BrandDycTypeItem item) {
		ModelAndView view = new ModelAndView("/dycBrand/addDycLargeTypeItem");
		if(!Objects.isEmpty(item.getId())) {
			view.addObject("item",brandDycTypeItemService.getBrandDycTypeItem(item.getId()));
		}
		view.addObject("largeTypes",brandLargeTypeService.findBrandLargeTypeList(null));
		BrandNavItem nav = new BrandNavItem();
		nav.setUpdateStatus("0");
		view.addObject("navItems",brandNavItemService.findBrandNavItemList(nav));
		return view;
	}
	
	/**
	 * 保存自定义商标项目
	 */
	@RequestMapping("/saveDycLargeTypeItem")
	public int saveDycLargeTypeItem(BrandDycTypeItem item) {
		return brandDycTypeItemService.saveBrandDycTypeItem(item);
	}
	
	/**
	 * 删除自定义商标项目
	 */
	@RequestMapping("/delDycLargeTypeItem")
	public int delDycLargeTypeItem(BrandDycTypeItem item) {
		return brandDycTypeItemService.deleteBrandDycTypeItem(item);
	}
	
	/**
	 * 导入excel文件
	 */
	@RequestMapping("/uploadExcel")
	public List<String> uploadExcel(MultipartFile file) {
		//导入的excel数据
		List<ArrayList<String>> data = ExcelUtil.readXls(file);
		//失败的数据
		List<String> failData = new ArrayList<String>();
		
		//返回数据
		List<String> result = new ArrayList<String>();
		int successNum = 0;
		int failNum = 0;
		
		//处理数据
		if(Collections.isNotEmpty(data) && data.size() > 0) {
			for(int i = 0; i < data.size(); i++) {
				try {
					//查找导航
					BrandNavItem nav = new BrandNavItem();
					nav.setName(data.get(i).get(0));
					List<BrandNavItem> navList = brandNavItemService.findBrandNavItemList(nav);
					if(Collections.isNotEmpty(navList) && navList.size() > 0) {
						nav = navList.get(0);
					}else {
						failNum++;
						failData.add("行号："+(i+2)+"，失败原因：无法找到相关的导航！");
						continue;
					}
					
					//查找商标子类
					BrandLargeType type = new BrandLargeType();
					type.setName(data.get(i).get(1));
					List<BrandLargeType> typeList = brandLargeTypeService.findBrandLargeTypeList(type);
					if(Collections.isNotEmpty(typeList) && typeList.size() > 0) {
						type = typeList.get(0);
					}else {
						failNum++;
						failData.add("行号："+(i+2)+"，失败原因：无法找到相关的商标大类！");
						continue;
					}
					
					//新增商标
					BrandDycTypeItem item = new BrandDycTypeItem();
					item.setNavItemId(nav.getId());
					item.setLargeTypeId(type.getId());
					item.setTypeNo(data.get(i).get(2));
					item.setProjectName(data.get(i).get(3));
					item.setProjectTranslation(data.get(i).get(4));
					item.setProjectStatus(data.get(i).get(5));
					item.setProjectInvalidDate(data.get(i).get(6));
					item.setProjectType(data.get(i).get(7));
					item.setProjectVersion(data.get(i).get(8));
					brandDycTypeItemService.saveBrandDycTypeItem(item);
					successNum++;
				} catch (Exception e) {
					failNum++;
					failData.add("行号："+(i+2)+"，失败原因：程序异常("+e.getMessage()+")");
					continue;
				}
			}
		}else {
			failData.add("Excel中未解析到需导入的数据");
		}
		result.add("导入成功："+successNum+"条，失败："+failNum+"条。");
		result.addAll(failData);
		return result;
	}
}
