package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandNavItem;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.BrandNavItemMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandNavItemService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class BrandNavItemServiceImpl implements BrandNavItemService {

    @Autowired
    protected BrandNavItemMapper mapper;


	@Override
	public BrandNavItem getBrandNavItem(Long id) {

		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int saveBrandNavItem(BrandNavItem brandNavItem) {

		int count = 0;
		if(!Objects.isEmpty(brandNavItem.getId())){
			count = mapper.updateByPrimaryKeySelective(brandNavItem);
		}else{
			brandNavItem.setRecordStatus(RecordStatus.ACTIVE);
			brandNavItem.setUpdateCount(0);
			brandNavItem.setCreateDate(new Date());
			count = mapper.insertSelective(brandNavItem);
		}
		return count;
	}

	@Override
	public int deleteBrandNavItem(BrandNavItem brandNavItem) {
		return mapper.deleteByPrimaryKey(brandNavItem);
	}

	@Override
	public int deleteBrandNavItemByIds(Long[] ids) {

		return mapper.deleteByIds(ids);
	}

	@Override
	public PagingResult<BrandNavItem> findBrandNavItem(Criteria criteria) {
		return null;
	}

	@Override
	public List<BrandNavItem> findBrandNavItemList(BrandNavItem item) {
		Example example = new Example(BrandNavItem.class);
		example.setOrderByClause("create_date DESC");

		if(!Objects.isEmpty(item.getName())){
			example.createCriteria().andLike("name", item.getName().trim());
		}
		List<BrandNavItem> list = mapper.selectByExample(example);

//		PagingResult<BrandNavItem> pageResult = new PagingResult<>(list);
		return list;
	}

	@Override
	public PagingResult<BrandNavItem> findBrandNavItem(BrandNavItem item, LayuiPage page) {
		Example example = new Example(BrandNavItem.class);
		Example.Criteria criteria = example.createCriteria();

		criteria.andEqualTo("recordStatus", RecordStatus.ACTIVE);
		example.setOrderByClause("city_name  ASC");
		if(!Objects.isEmpty(item.getName())) {
			example.createCriteria().andLike("name", "%"+item.getName().trim()+"%");
		}

		//复杂 or条件查询
		Weekend<BrandNavItem> weekend = new Weekend<>(BrandNavItem.class);
		WeekendCriteria<BrandNavItem, Object> keywordCriteria = weekend.weekendCriteria();
		if (!Objects.isEmpty(item.getId())) {
			keywordCriteria.orLike("name", "%" + item.getName().trim() + "%")
					.orLike("cityName", "%" + item.getCityName().trim() + "%");
		}
		weekend.and(criteria);

		if (page != null) {
			PageHelper.startPage(page.getPage(), page.getLimit());
		}
		List<BrandNavItem> list = mapper.selectByExample(weekend);

		PagingResult<BrandNavItem> pageResult = new PagingResult<>(list);
		return pageResult;
	}

	@Override
	public int getMaxSeq() {
		return 0;
	}
}