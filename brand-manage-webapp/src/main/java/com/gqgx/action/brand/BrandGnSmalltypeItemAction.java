package com.gqgx.action.brand;

import com.gqgx.common.collection.Collections;
import com.gqgx.common.entity.BrandGnSmalltypeItem;
import com.gqgx.common.entity.BrandSmallType;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandGnSmalltypeItemService;
import com.gqgx.common.service.BrandSmallTypeService;
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
@RequestMapping("brandGnSmalltypeItem")
public class BrandGnSmalltypeItemAction {
	
	/**
	 * 通用尼斯项目业务接口
	 */
	@Autowired
	private BrandGnSmalltypeItemService brandGnSmalltypeItemService;
	
	/**
	 * 小类业务接口
	 */
	@Autowired
	private BrandSmallTypeService brandSmallTypeService;
	
	/**
	 * 通用尼斯子类项目列表页
	 * @return
	 */
	@RequestMapping("/gnSmallTypeItemListView")
	public ModelAndView gnSmallTypeItemListView(){
		ModelAndView view = new ModelAndView("/generalNice/gnSmallTypeItemList");
		return view;
	}
	
	/**
	 * 通用尼斯子类项目列表数据
	 */
	@RequestMapping("/gnSmallTypeItemListData")
	@ResponseBody
	public LayUiResult<BrandGnSmalltypeItem> gnSmallTypeItemListData(BrandGnSmalltypeItem item,LayuiPage page){
		PagingResult<BrandGnSmalltypeItem> list = brandGnSmalltypeItemService.findBrandGnSmalltypeItem(item, page);
        return new LayUiResult<BrandGnSmalltypeItem>(list);
	}
	
	/**
	 * 通用尼斯子类项目 新增、修改界面
	 */
	@RequestMapping("/addGnSmallTypeItemView")
	public ModelAndView addGnSmallTypeItemView(BrandGnSmalltypeItem item) {
		ModelAndView view = new ModelAndView("/generalNice/addGnSmallTypeItem");
		if(!Objects.isEmpty(item.getId())) {
			view.addObject("item",brandGnSmalltypeItemService.getBrandGnSmalltypeItem(item.getId()));
		}
		view.addObject("smallTypes",brandSmallTypeService.findBrandSmallTypeList(null));
		return view;
	}
	
	/**
	 * 保存通用尼斯子类项目
	 */
	@RequestMapping("/saveGnSmallTypeItem")
	public int saveGnSmallTypeItem(BrandGnSmalltypeItem item) {
		return brandGnSmalltypeItemService.saveBrandGnSmalltypeItem(item);
	}
	
	/**
	 * 删除通用尼斯子类项目
	 */
	@RequestMapping("/delGnSmallTypeItem")
	public int delGnSmallTypeItem(BrandGnSmalltypeItem largeType) {
		return brandGnSmalltypeItemService.deleteBrandGnSmalltypeItem(largeType);
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
					BrandSmallType brandSmallType = new BrandSmallType();
					brandSmallType.setNo(data.get(i).get(0));
					List<BrandSmallType> typeList = brandSmallTypeService.findBrandSmallTypeList(brandSmallType);
					if(Collections.isNotEmpty(typeList) && typeList.size() > 0) {
						brandSmallType = typeList.get(0);
					}else {
						failNum++;
						failData.add("行号："+(i+2)+"，失败原因：无法找到相关的商标子类！");
						continue;
					}
					
					//新增通用尼斯商标
					BrandGnSmalltypeItem item = new BrandGnSmalltypeItem();
					item.setSmallTypeId(brandSmallType.getId());
					item.setGroupNo(data.get(i).get(1));
					item.setProjectNo(data.get(i).get(2));
					item.setProjectCnname(data.get(i).get(3));
					item.setProjectEnname(data.get(i).get(4));
					brandGnSmalltypeItemService.saveBrandGnSmalltypeItem(item);
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
