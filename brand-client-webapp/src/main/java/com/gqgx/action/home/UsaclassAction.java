package com.gqgx.action.home;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gqgx.action.header.HeaderAction;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.entity.BrandUsaTypeItem;
import com.gqgx.common.entity.vo.BrandUsaTypeItemVo;
import com.gqgx.common.entity.vo.CookieVo;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandLargeTypeService;
import com.gqgx.common.service.BrandUsaTypeItemService;
import com.gqgx.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsaclassAction extends HeaderAction {

    @Autowired
    private BrandLargeTypeService brandLargeTypeService;

    @Autowired
    private BrandUsaTypeItemService brandUsaTypeItemService;

    /**
     * 美国商标主页
     *
     * @param page
     * @return
     */
    @RequestMapping("/usaclass")
    public ModelAndView usaclass(LayuiPage page, Long largeTypeId, String filter, HttpServletRequest request) {
        ModelAndView view = new ModelAndView("/usaclass");
        setNiceclassData(page, largeTypeId, filter, view, request);
        return view;
    }

    /**
     * 美国商标大类页
     *
     * @param page
     * @return
     */
    @RequestMapping("/usaclass/class{largeTypeId}")
    public ModelAndView niceclassByLargeType(LayuiPage page, @PathVariable Long largeTypeId, String filter, HttpServletRequest request) {
        ModelAndView view = new ModelAndView("/usaclass");
        setNiceclassData(page, largeTypeId, filter, view, request);
        return view;
    }

    /**
     * 美国设置数据
     *
     * @param page
     * @param typeId
     * @param view
     */
    private void setNiceclassData(LayuiPage page, Long largeTypeId, String filter, ModelAndView view, HttpServletRequest request) {
        page.setLimit(60);

        //加载大类及子类
        BrandLargeType type = new BrandLargeType();
        view.addObject("largeTypeList", brandLargeTypeService.findBrandLargeTypeList(type));

        //加载大类详情
        if (null != largeTypeId) {
            view.addObject("largeType", brandLargeTypeService.getBrandLargeType(largeTypeId));
        }

        //加载列表项
        BrandUsaTypeItemVo vo = new BrandUsaTypeItemVo();

        if (null != largeTypeId) {
            vo.setLargeTypeId(largeTypeId);
        }

        if (!StringUtils.isEmpty(filter)) {
            vo.setFilter(filter);
            view.addObject("filter", filter.trim());
        }

        List<CookieVo> list = new ArrayList<CookieVo>();
        String nicelist = CookieUtil.getCookieValue(request, "usaclass");
        if (!StringUtils.isEmpty(nicelist)) {
            list = JSONArray.parseArray(nicelist, CookieVo.class);
        }
        view.addObject("usaCookieList", list);

        PagingResult<BrandUsaTypeItem> itemList = brandUsaTypeItemService.findBrandUsaTypeItemList(vo, page);
        view.addObject("smallTypeItemList", itemList.getResult());
        page.setTotal(itemList.getTotalCount());
        view.addObject("total", itemList.getTotalCount());
        view.addObject("currentPage", page.getPage());
    }

    /**
     * 勾选通用商标项
     *
     * @param response
     * @param request
     * @param vo
     * @return
     */
    @SuppressWarnings("deprecation")
    @RequestMapping("/setUsaClassCookie")
    public int setUsaClassCookie(HttpServletResponse response, HttpServletRequest request, CookieVo vo) {
        try {
            List<CookieVo> list = new ArrayList<CookieVo>();
            String nicelist = CookieUtil.getCookieValue(request, "usaclass");
            if (!StringUtils.isEmpty(nicelist)) {
                list = JSONArray.parseArray(nicelist, CookieVo.class);
            }

            boolean addStatus = true;
            if (list != null && list.size() > 0) {
                for (CookieVo cookie : list) {
                    if (cookie.getId() == vo.getId()) {
                        addStatus = false;
                    }
                }

            }
            if (addStatus) {
                CookieVo cookie = new CookieVo();
                cookie.setId(vo.getId());

                cookie.setName(java.net.URLEncoder.encode(vo.getName(), "utf-8"));

                list.add(cookie);
            }
            CookieUtil.setCookie(response, "usaclass", JSON.toJSONString(list));
            return 1;
        } catch (UnsupportedEncodingException e) {
            System.out.println("设置cookie值错误" + e.getMessage());
            return 0;
        }

    }

    /**
     * 取消勾选通用商标项
     *
     * @param response
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/cancelUsaClassCookie/{id}")
    public int cancelUsaClassCookie(HttpServletResponse response, HttpServletRequest request,
                                    @PathVariable Long id) {
        List<CookieVo> list = new ArrayList<CookieVo>();
        String nicelist = CookieUtil.getCookieValue(request, "usaclass");
        if (!StringUtils.isEmpty(nicelist)) {
            list = JSONArray.parseArray(nicelist, CookieVo.class);
            int rmindex = -1;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getId().intValue() == id.intValue()) {
                        rmindex = i;
                    }
                }

            }
            if (rmindex > -1) list.remove(rmindex);
            CookieUtil.setCookie(response, "usaclass", JSON.toJSONString(list));
        }

        return 1;
    }

}
