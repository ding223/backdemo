package com.gqgx.action.system;

import com.gqgx.common.entity.SysOperationLog;
import com.gqgx.common.paging.LayuiPage;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysOperationLogService;
import com.gqgx.domain.LayUiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/log")
public class SystemLogAction {
	
	@Autowired
	private SysOperationLogService sysOperationLogService;
	
	/**
	 * 交接页面
	 * @return
	 */
	@RequestMapping("/logIndex")
	public ModelAndView logIndex(){
		ModelAndView view=new ModelAndView("/logs/logIndex");
		return view;
	}
	
	/**
	 * 系统日志页面
	 * @return
	 */
	@RequestMapping("/sysLogInit")
    public ModelAndView sysLogInit(){
        return new ModelAndView("/sysLog/logList");
    }
	
	/**
	 * 系统列表数据
	 * @param operationLog
	 * @param page
	 * @return
	 */
	@RequestMapping("/sysLogList")
    @ResponseBody
    public LayUiResult<SysOperationLog> sysLogList(SysOperationLog operationLog,LayuiPage page){
		PagingResult<SysOperationLog> pagingResult = sysOperationLogService.findOperationLogList(operationLog, page);
        return new LayUiResult<SysOperationLog>(pagingResult);
    }
}
