package com.gqgx.action.friendship;

import com.gqgx.common.entity.GqgxFriendship;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.GqgxFriendshipService;
import com.gqgx.domain.LayUiResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 友情链接管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/friendShip")
public class GqgxFriendShipAction {

	@Autowired
	private GqgxFriendshipService gqgxFriendshipService;
	
	/**
	 * 友情链接管理
	 * @return
	 */
	@RequestMapping("/friendShipindex")
	public ModelAndView friendShipindex(){
		//测试权限
		//Subject subject = SecurityUtils.getSubject();
		//subject.hasRole("yqlj");

		ModelAndView view=new ModelAndView("/friendShip/friendShipindex");
		return view;
	}

	/**
	 * 友情链接数据
	 * @return
	 */
	@RequestMapping("/friendShipList")
	@ResponseBody
	public LayUiResult<GqgxFriendship> friendShipList(GqgxFriendship ship,LayuiPage page){
		PagingResult<GqgxFriendship> friendShipList = gqgxFriendshipService.findGqgxFriendship(ship, page);
        return new LayUiResult<GqgxFriendship>(friendShipList);
	}
	
	/**
	 * 编辑友情链接
	 * @return
	 */
	@RequestMapping("/addFriendShip")
	public ModelAndView addFriendShip(GqgxFriendship ship) {
		ModelAndView view = new ModelAndView("/friendShip/addFriendShip");
		if(!Objects.isEmpty(ship.getId())) {
			view.addObject("ship",gqgxFriendshipService.getGqgxFriendship(ship.getId()));
		}
		return view;
	}
	
	/**
	 * 保存友情链接
	 */
	@RequestMapping("/saveFriendShip")
	public int saveFriendShip(GqgxFriendship ship) {
		return gqgxFriendshipService.saveGqgxFriendship(ship);
	}
	
	/**
	 * 删除友情链接
	 * @return
	 */
	@RequestMapping("/delFriendShip")
	public int delFriendShip(GqgxFriendship ship) {
		return gqgxFriendshipService.deleteGqgxFriendship(ship);
	}
}
