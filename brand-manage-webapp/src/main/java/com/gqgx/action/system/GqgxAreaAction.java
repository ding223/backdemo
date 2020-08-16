package com.gqgx.action.system;

import com.gqgx.common.entity.GqgxArea;
import com.gqgx.common.entity.GqgxCitySite;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.GqgxAreaService;
import com.gqgx.common.service.GqgxCitySiteService;
import com.gqgx.domain.LayUiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 省份，城市，区域管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/area")
public class GqgxAreaAction {
	
	@Autowired
	private GqgxAreaService gqgxAreaService;
	
	@Autowired
	private GqgxCitySiteService gqgxCitySiteService;
	
	/**跟进层级加载 省份/城市/区域
	 * @param area
	 * @return
	 */
	@RequestMapping("/loadAreas")
	public List<GqgxArea> loadAreas(GqgxArea area){
		return gqgxAreaService.getAreaList(area.getAreaLevel(),area.getParentId());
	}
	
	/**
	 * 站点管理
	 * @return
	 */
	@RequestMapping("/siteindex")
	public ModelAndView siteindex(){
		ModelAndView view=new ModelAndView("/area/siteindex");
		return view;
	}

	/**
	 * 站点数据
	 * @param page
	 * @return
	 */
	@RequestMapping("/siteList")
	@ResponseBody
	public LayUiResult<GqgxCitySite> siteList(GqgxCitySite site,LayuiPage page){
		PagingResult<GqgxCitySite> sitelist = gqgxCitySiteService.findGqgxSite(site, page);
        return new LayUiResult<GqgxCitySite>(sitelist);
	}
	
	/**
	 * 编辑站点
	 * @return
	 */
	@RequestMapping("/addSite")
	public ModelAndView addSite(GqgxCitySite site) {
		ModelAndView view = new ModelAndView("/area/addSite");
		if(!Objects.isEmpty(site.getId())) {
			view.addObject("site",gqgxCitySiteService.getGqgxCitySite(site.getId()));
		}
		view.addObject("citys",gqgxAreaService.getCityList());
		return view;
	}
	
	/**
	 * 保存站点
	 */
	@RequestMapping("/saveSite")
	public int saveSite(GqgxCitySite site) {
		if(!Objects.isEmpty(site.getCityId())) {
			GqgxArea area = gqgxAreaService.getGqgxArea(site.getCityId());
			site.setCityName(area.getAreaName());
		}
		gqgxCitySiteService.saveGqgxCitySite(site);
		gqgxCitySiteService.sortSite();
		return 1;
	}
	
	/**
	 * 删除站点
	 * @return
	 */
	@RequestMapping("/delSite")
	public int delSite(GqgxCitySite banner) {
		gqgxCitySiteService.deleteGqgxCitySite(banner);
		gqgxCitySiteService.sortSite();
		return 1;
	}
	
	/**
	 * 站点排序
	 * @return
	 */
	@RequestMapping("/siteSort")
	public ModelAndView siteSort(){
		ModelAndView view=new ModelAndView("/area/siteSort");
		return view;
	}
	
	/**
	 * 保存站点排序
	 */
	@RequestMapping("/reSortSite")
	@ResponseBody
	public int reSortSite(String ids) {
		return gqgxCitySiteService.reSortSite(ids);
	}
	
	/**
	 * 所有站点
	 * @return
	 */
	@RequestMapping("/siteAll")
	@ResponseBody
	public List<GqgxCitySite> siteAll(){
		return gqgxCitySiteService.findAllGqgxSite();
	}
}
