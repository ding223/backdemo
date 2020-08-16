package com.gqgx.common.service;

import com.gqgx.common.paging.Page;
import com.gqgx.common.paging.PagingResult;

import java.util.Map;

public interface ChartService {

	
	/**
	 * 折线图{用户关注数,用户取消关注数}
	 * 
	 * @param type
	 *            统计类型
	 * @param year
	 *            统计年
	 * @param month
	 *            统计月
	 * @return
	 */
	public Map<String, Object> lineChartWeChat(String type, Integer year, Integer month, Long companyId);

	public Map<String, Object> lineChartNRC(String type, Integer year, Integer month, Long companyId);

	public Map<String, Object> pieChartCompanyType(Long companyId);

	public Map<String, Object> pieChartServiceSales(Long companyId);

	public Map<String, Object> pieChartSkuSales(Long companyId);

	public Map<String, Object> lineChartOrderCount(String type, Integer year, Integer month, Long companyId);

	public Map<String, Object> lineChartOrderMoney(String type, Integer year,
                                                   Integer month, Long companyId);

	public Map<String, Object> contrastServiceSales(String dateType,
                                                    String beginDate, String endDate, String sourceType, Long companyId);

	public PagingResult<Map<String, Object>> findSkuCount(Page page, Map<String, Object> param);
}
