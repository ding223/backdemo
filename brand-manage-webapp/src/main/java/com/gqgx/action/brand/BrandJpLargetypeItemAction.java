package com.gqgx.action.brand;

import com.gqgx.common.collection.Collections;
import com.gqgx.common.entity.BrandJpTypeItem;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandJpTypeItemService;
import com.gqgx.common.service.BrandLargeTypeService;
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
@RequestMapping("jpLargeTypeItem")
public class BrandJpLargetypeItemAction {
	
	/**
	 * 日本商标项目业务类
	 */
	@Autowired
	private BrandJpTypeItemService brandJpTypeItemService;
	
	/**
	 * 商标大类业务接口
	 */
	@Autowired
	private BrandLargeTypeService brandLargeTypeService;
	
	/**
	 * 日本商标项目列表页
	 * @return
	 */
	@RequestMapping("/jpLargeTypeItemListView")
	public ModelAndView jpLargeTypeItemListView(){
		ModelAndView view = new ModelAndView("/jpBrand/jpLargeTypeItemList");
		return view;
	}
	
	/**
	 * 日本商标项目列表数据
	 */
	@RequestMapping("/jpLargeTypeItemListData")
	@ResponseBody
	public LayUiResult<BrandJpTypeItem> jpLargeTypeItemListData(BrandJpTypeItem item,LayuiPage page){
		PagingResult<BrandJpTypeItem> list = brandJpTypeItemService.findBrandJpTypeItem(item, page);
        return new LayUiResult<BrandJpTypeItem>(list);
	}
	
	/**
	 * 日本商标项目 新增、修改界面
	 */
	@RequestMapping("/addJpLargeTypeItemView")
	public ModelAndView addJpLargeTypeItemView(BrandJpTypeItem item) {
		ModelAndView view = new ModelAndView("/jpBrand/addJpLargeTypeItem");
		if(!Objects.isEmpty(item.getId())) {
			view.addObject("item",brandJpTypeItemService.getBrandJpTypeItem(item.getId()));
		}
		view.addObject("largeTypes",brandLargeTypeService.findBrandLargeTypeList(null));
		return view;
	}
	
	/**
	 * 保存日本商标项目
	 */
	@RequestMapping("/saveEuroLargeTypeItem")
	public int saveEuroLargeTypeItem(BrandJpTypeItem item) {
		return brandJpTypeItemService.saveBrandJpTypeItem(item);
	}
	
	/**
	 * 删除日本商标项目
	 */
	@RequestMapping("/delEuroLargeTypeItem")
	public int delEuroLargeTypeItem(BrandJpTypeItem largeType) {
		return brandJpTypeItemService.deleteBrandJpTypeItem(largeType);
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
					//查找商标子类
					BrandLargeType type = new BrandLargeType();
					type.setName(data.get(i).get(0));
					List<BrandLargeType> typeList = brandLargeTypeService.findBrandLargeTypeList(type);
					if(Collections.isNotEmpty(typeList) && typeList.size() > 0) {
						type = typeList.get(0);
					}else {
						failNum++;
						failData.add("行号："+(i+2)+"，项目名称："+data.get(i).get(3)+"，失败原因：无法找到相关的商标大类！");
						continue;
					}
					
					//新增商标
					BrandJpTypeItem item = new BrandJpTypeItem();
					item.setLargeTypeId(type.getId());
					item.setTypeNo(data.get(i).get(1));
					item.setProjectName(data.get(i).get(2));
					item.setProjectCoor(data.get(i).get(3));
					item.setProjectHarm(data.get(i).get(4));
					item.setProjectNice(data.get(i).get(5));
					item.setProjectIdli(data.get(i).get(6));
					item.setProjectMgs(data.get(i).get(7));
					brandJpTypeItemService.saveBrandJpTypeItem(item);
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
