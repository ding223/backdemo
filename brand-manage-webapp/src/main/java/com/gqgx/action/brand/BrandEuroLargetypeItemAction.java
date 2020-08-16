package com.gqgx.action.brand;

import com.gqgx.common.collection.Collections;
import com.gqgx.common.entity.BrandEuroTypeItem;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandEuroTypeItemService;
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
@RequestMapping("euroLargeTypeItem")
public class BrandEuroLargetypeItemAction {
	
	/**
	 * 欧盟商标项目业务类
	 */
	@Autowired
	private BrandEuroTypeItemService brandEuroTypeItemService;
	
	/**
	 * 商标大类业务接口
	 */
	@Autowired
	private BrandLargeTypeService brandLargeTypeService;
	
	/**
	 * 欧盟商标项目列表页
	 * @return
	 */
	@RequestMapping("/euroLargeTypeItemListView")
	public ModelAndView euroLargeTypeItemListView(){
		ModelAndView view = new ModelAndView("/euroBrand/euroLargeTypeItemList");
		return view;
	}
	
	/**
	 * 欧盟商标项目列表数据
	 */
	@RequestMapping("/euroLargeTypeItemListData")
	@ResponseBody
	public LayUiResult<BrandEuroTypeItem> euroLargeTypeItemListData(BrandEuroTypeItem item,LayuiPage page){
		PagingResult<BrandEuroTypeItem> list = brandEuroTypeItemService.findBrandEuroTypeItem(item, page);
        return new LayUiResult<BrandEuroTypeItem>(list);
	}
	
	/**
	 * 欧盟商标项目 新增、修改界面
	 */
	@RequestMapping("/addEuroLargeTypeItemView")
	public ModelAndView addEuroLargeTypeItemView(BrandEuroTypeItem item) {
		ModelAndView view = new ModelAndView("/euroBrand/addEuroLargeTypeItem");
		if(!Objects.isEmpty(item.getId())) {
			view.addObject("item",brandEuroTypeItemService.getBrandEuroTypeItem(item.getId()));
		}
		view.addObject("largeTypes",brandLargeTypeService.findBrandLargeTypeList(null));
		return view;
	}
	
	/**
	 * 保存欧盟商标项目
	 */
	@RequestMapping("/saveEuroLargeTypeItem")
	public int saveEuroLargeTypeItem(BrandEuroTypeItem item) {
		return brandEuroTypeItemService.saveBrandEuroTypeItem(item);
	}
	
	/**
	 * 删除欧盟商标项目
	 */
	@RequestMapping("/delEuroLargeTypeItem")
	public int delEuroLargeTypeItem(BrandEuroTypeItem largeType) {
		return brandEuroTypeItemService.deleteBrandEuroTypeItem(largeType);
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
						failData.add("行号："+(i+2)+"，失败原因：无法找到相关的商标大类！");
						continue;
					}
					
					//新增欧盟商标
					BrandEuroTypeItem item = new BrandEuroTypeItem();
					item.setLargeTypeId(type.getId());
					item.setTypeNo(data.get(i).get(1));
					item.setProjectName(data.get(i).get(2));
					item.setProjectCoor(data.get(i).get(3));
					item.setProjectHarm(data.get(i).get(4));
					item.setProjectNice(data.get(i).get(5));
					item.setProjectIdli(data.get(i).get(6));
					item.setProjectMgs(data.get(i).get(7));
					brandEuroTypeItemService.saveBrandEuroTypeItem(item);
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
