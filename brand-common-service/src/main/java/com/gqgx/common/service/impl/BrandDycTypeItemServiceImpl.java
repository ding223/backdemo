package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandDycTypeItem;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.entity.vo.BrandDycTypeItemVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.BrandDycTypeItemMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandDycTypeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Date;
import java.util.List;

@Service
public class BrandDycTypeItemServiceImpl implements BrandDycTypeItemService {

    @Autowired
    protected BrandDycTypeItemMapper mapper;


	@Override
	public BrandDycTypeItem getBrandDycTypeItem(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int saveBrandDycTypeItem(BrandDycTypeItem item) {
		int count = 0;
		if(!Objects.isEmpty(item.getId())){
			count = mapper.updateByPrimaryKeySelective(item);
		}else{
			item.setRecordStatus(RecordStatus.ACTIVE);
			item.setUpdateCount(0);
			item.setCreateDate(new Date());
			count = mapper.insertSelective(item);
		}
		return count;
	}

	@Override
	public int deleteBrandDycTypeItem(BrandDycTypeItem item) {
		return mapper.deleteByPrimaryKey(item);
	}

	@Override
	public int deleteBrandDycTypeItemByIds(Long[] ids) {
		return mapper.deleteByIds(ids);
	}

	@Override
	public PagingResult<BrandDycTypeItem> findBrandDycTypeItem(Criteria criteria) {
		return null;
	}

	@Override
	public PagingResult<BrandDycTypeItem> findBrandDycTypeItem(BrandDycTypeItem item, LayuiPage page) {
		Example example = new Example(BrandDycTypeItem.class);
		Example.Criteria cb = example.createCriteria();

		cb.andEqualTo("recordStatus", RecordStatus.ACTIVE);
		if(!Objects.isEmpty(item.getProjectName())) {
			cb.andLike("projectName", "%"+item.getProjectName().trim()+"%");
		}
		if(!Objects.isEmpty(item.getNavItemId())) {
			cb.andEqualTo("navItemId", item.getNavItemId());
		}
		example.setOrderByClause("create_date DESC");

		if (page != null) {
			PageHelper.startPage(page.getPage(), page.getLimit());
		}
		List<BrandDycTypeItem> list = mapper.selectByExample(example);

		PagingResult<BrandDycTypeItem> pageResult = new PagingResult<>(list);
		return pageResult;
	}

	@Override
	public PagingResult<BrandDycTypeItem> findBrandDycTypeItemList(BrandDycTypeItemVo item, LayuiPage page) {
		Example example = new Example(BrandDycTypeItem.class);
		Example.Criteria criteria = example.createCriteria();

		example.setOrderByClause("create_date DESC");
		criteria.andEqualTo("recordStatus", RecordStatus.ACTIVE);

		if(!Objects.isEmpty(item.getProjectName())) {
			example.createCriteria().andLike("projectName", "%"+item.getProjectName().trim()+"%");
		}
		if(!Objects.isEmpty(item.getNavItemId())) {
			criteria.andEqualTo("navItemId", item.getNavItemId());
		}

		//复杂 or条件查询
		Weekend<BrandDycTypeItem> weekend = new Weekend<>(BrandDycTypeItem.class);
		WeekendCriteria<BrandDycTypeItem, Object> keywordCriteria = weekend.weekendCriteria();
		if (!Objects.isEmpty(item.getFilter())) {
			keywordCriteria.orLike("typeNo", "%" + item.getFilter().trim() + "%")
					.orLike("projectCnname", "%" + item.getFilter().trim() + "%");
		}
		weekend.and(criteria);

		if (page != null) {
			PageHelper.startPage(page.getPage(), page.getLimit());
		}

		List<BrandDycTypeItem> list = mapper.selectByExample(weekend);
		PagingResult<BrandDycTypeItem> pageResult = new PagingResult<>(list);
		return pageResult;
	}
}