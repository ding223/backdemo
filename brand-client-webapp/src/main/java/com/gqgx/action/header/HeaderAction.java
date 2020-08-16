package com.gqgx.action.header;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.gqgx.common.entity.BrandNavItem;
import com.gqgx.common.entity.GqgxFriendship;
import com.gqgx.common.service.BrandNavItemService;
import com.gqgx.common.service.GqgxFriendshipService;

@RestController
public class HeaderAction {
	
	@Autowired
	private BrandNavItemService brandNavItemService;
	
	@Autowired
	private GqgxFriendshipService gqgxFriendshipService;
	
	@ModelAttribute("navtionList")
	public List<BrandNavItem> getNavgationList() {
		BrandNavItem item = new BrandNavItem();
		item.setShowStatus("0");
		item.setUpdateStatus("0");
		return brandNavItemService.findBrandNavItemList(item);
	}
	
	/**
	 * 友情链接数据
	 * @return
	 */
	@ModelAttribute("friendShipList")
	public List<GqgxFriendship> friendShipList(GqgxFriendship ship){
        return gqgxFriendshipService.getGqgxFriendship(ship);
	}
}
