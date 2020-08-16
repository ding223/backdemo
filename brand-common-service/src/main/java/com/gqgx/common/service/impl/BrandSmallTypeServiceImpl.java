package com.gqgx.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.gqgx.common.criteria.Criteria;
import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.entity.BrandSmallType;
import com.gqgx.common.entity.RecordStatus;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.mapper.BrandSmallTypeMapper;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.BrandSmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class BrandSmallTypeServiceImpl implements BrandSmallTypeService {

	@Autowired
	protected BrandSmallTypeMapper mapper;

	@Override
	public BrandSmallType getBrandSmallType(String smallNo) {

		return mapper.selectByPrimaryKey(smallNo);
	}

	@Override
	public BrandSmallType getBrandSmallType(Long SmallTypeId) {
		return mapper.selectByPrimaryKey(SmallTypeId);
	}

	@Override
	public int saveBrandSmallType(BrandSmallType brandSmallType) {

		int count = 0;
		if(!Objects.isEmpty(brandSmallType.getId())){
			count = mapper.updateByPrimaryKeySelective(brandSmallType);
		}else{
			brandSmallType.setRecordStatus(RecordStatus.ACTIVE);
			brandSmallType.setUpdateCount(0);
			brandSmallType.setCreateDate(new Date());
			count = mapper.insertSelective(brandSmallType);
		}
		return count;
	}

	@Override
	public int deleteBrandSmallType(BrandSmallType brandSmallType) {

		return mapper.deleteByPrimaryKey(brandSmallType);
	}

	@Override
	public int deleteBrandSmallTypeByIds(Long[] ids) {

		return mapper.deleteByIds(ids);
	}

	@Override
	public PagingResult<BrandSmallType> findBrandSmallType(Criteria criteria) {
		return null;
	}

	@Override
	public PagingResult<BrandSmallType> findBrandSmallType(BrandSmallType brandSmallType, LayuiPage page) {
		Example example = new Example(BrandLargeType.class);
		example.setOrderByClause("create_date DESC");

		if(!Objects.isEmpty(brandSmallType.getName())) {
			example.createCriteria().andLike("name", "%"+brandSmallType.getName()+"%");
		}
		if (page != null) {
			PageHelper.startPage(page.getPage(), page.getLimit());
		}
		List<BrandSmallType> list = mapper.selectByExample(example);

		PagingResult<BrandSmallType> pageResult = new PagingResult<>(list);
		return pageResult;
	}

	@Override
	public List<BrandSmallType> findBrandSmallTypeList(BrandSmallType brandSmallType) {
		Example example = new Example(BrandLargeType.class);
		example.setOrderByClause("create_date DESC");

		if(!Objects.isEmpty(brandSmallType) && !Objects.isEmpty(brandSmallType.getNo())) {
			example.createCriteria().andEqualTo("no", brandSmallType.getNo());
		}
		List<BrandSmallType> list = mapper.selectByExample(example);
		return list;
	}
}