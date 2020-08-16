package com.gqgx.action.brand;

import com.gqgx.common.collection.Collections;
import com.gqgx.common.entity.BrandKorTypeItem;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandKorTypeItemService;
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
@RequestMapping("korLargeTypeItem")
public class BrandKorLargetypeItemAction {
	
	/**
	 * 韩国商标项目业务类
	 */
	@Autowired
	private BrandKorTypeItemService brandKorTypeItemService;
	
	/**
	 * 商标大类业务接口
	 */
	@Autowired
	private BrandLargeTypeService brandLargeTypeService;
	
	/**
	 * 韩国商标项目列表页
	 * @return
	 */
	@RequestMapping("/korLargeTypeItemListView")
	public ModelAndView korLargeTypeItemListView(){
		ModelAndView view = new ModelAndView("/korBrand/korLargeTypeItemList");
		return view;
	}
	
	/**
	 * 韩国商标项目列表数据
	 */
	@RequestMapping("/korLargeTypeItemListData")
	@ResponseBody
	public LayUiResult<BrandKorTypeItem> korLargeTypeItemListData(BrandKorTypeItem item,LayuiPage page){
		PagingResult<BrandKorTypeItem> list = brandKorTypeItemService.findBrandKorTypeItem(item, page);
        return new LayUiResult<BrandKorTypeItem>(list);
	}
	
	/**
	 * 韩国商标项目 新增、修改界面
	 */
	@RequestMapping("/addKorLargeTypeItemView")
	public ModelAndView addKorLargeTypeItemView(BrandKorTypeItem item) {
		ModelAndView view = new ModelAndView("/korBrand/addKorLargeTypeItem");
		if(!Objects.isEmpty(item.getId())) {
			view.addObject("item",brandKorTypeItemService.getBrandKorTypeItem(item.getId()));
		}
		view.addObject("largeTypes",brandLargeTypeService.findBrandLargeTypeList(null));
		return view;
	}
	
	/**
	 * 保存韩国商标项目
	 */
	@RequestMapping("/saveKorLargeTypeItem")
	public int saveKorLargeTypeItem(BrandKorTypeItem item) {
		return brandKorTypeItemService.saveBrandKorTypeItem(item);
	}
	
	/**
	 * 删除韩国商标项目
	 */
	@RequestMapping("/delKorLargeTypeItem")
	public int delKorLargeTypeItem(BrandKorTypeItem largeType) {
		return brandKorTypeItemService.deleteBrandKorTypeItem(largeType);
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
					BrandKorTypeItem item = new BrandKorTypeItem();
					item.setLargeTypeId(type.getId());
					item.setTypeNo(data.get(i).get(1));
					item.setProjectName(data.get(i).get(2));
					item.setProjectGroup(data.get(i).get(3));
					brandKorTypeItemService.saveBrandKorTypeItem(item);
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
