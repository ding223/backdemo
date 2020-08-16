package com.gqgx.action.brand;

import com.gqgx.common.collection.Collections;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.entity.BrandRussiaTypeItem;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandLargeTypeService;
import com.gqgx.common.service.BrandRussiaTypeItemService;
import com.gqgx.domain.LayUiResult;
import com.gqgx.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("russiaLargeTypeItem")
public class BrandRussiaLargetypeItemAction {
	
	/**
	 * 俄罗斯商标项目业务类
	 */
	@Autowired
	private BrandRussiaTypeItemService brandRussiaTypeItemService;
	
	/**
	 * 商标大类业务接口
	 */
	@Autowired
	private BrandLargeTypeService brandLargeTypeService;
	
	/**
	 * 俄罗斯商标项目列表页
	 * @return
	 */
	@RequestMapping("/russiaLargeTypeItemListView")
	public ModelAndView russiaLargeTypeItemListView(){
		ModelAndView view = new ModelAndView("/russiaBrand/russiaLargeTypeItemList");
		return view;
	}
	
	/**
	 * 俄罗斯商标项目列表数据
	 */
	@RequestMapping("/russiaLargeTypeItemListData")
	@ResponseBody
	public LayUiResult<BrandRussiaTypeItem> russiaLargeTypeItemListData(BrandRussiaTypeItem item,LayuiPage page){
		PagingResult<BrandRussiaTypeItem> list = brandRussiaTypeItemService.findBrandRussiaTypeItem(item, page);
        return new LayUiResult<BrandRussiaTypeItem>(list);
	}
	
	/**
	 * 俄罗斯商标项目 新增、修改界面
	 */
	@RequestMapping("/addRussiaLargeTypeItemView")
	public ModelAndView addRussiaLargeTypeItemView(BrandRussiaTypeItem item) {
		ModelAndView view = new ModelAndView("/russiaBrand/addRussiaLargeTypeItem");
		if(!Objects.isEmpty(item.getId())) {
			view.addObject("item",brandRussiaTypeItemService.getBrandRussiaTypeItem(item.getId()));
		}
		view.addObject("largeTypes",brandLargeTypeService.findBrandLargeTypeList(null));
		return view;
	}
	
	/**
	 * 保存俄罗斯商标项目
	 */
	@RequestMapping("/saveRussiaLargeTypeItem")
	public int saveRussiaLargeTypeItem(@RequestBody BrandRussiaTypeItem item) {
		return brandRussiaTypeItemService.saveBrandRussiaTypeItem(item);
	}
	
	/**
	 * 删除俄罗斯商标项目
	 */
	@RequestMapping("/delRussiaLargeTypeItem")
	public int delRussiaLargeTypeItem(BrandRussiaTypeItem item) {
		return brandRussiaTypeItemService.deleteBrandRussiaTypeItem(item);
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
					
					//新增商标
					BrandRussiaTypeItem item = new BrandRussiaTypeItem();
					item.setLargeTypeId(type.getId());
					item.setTitle(data.get(i).get(1));
					item.setContent(data.get(i).get(2));
					brandRussiaTypeItemService.saveBrandRussiaTypeItem(item);
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
