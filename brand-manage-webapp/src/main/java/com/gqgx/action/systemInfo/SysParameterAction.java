package com.gqgx.action.systemInfo;

import com.gqgx.common.entity.SysParameter;
import com.gqgx.common.paging.Page;
import com.gqgx.common.paging.PagingResult;
import com.gqgx.common.service.SysParameterService;
import com.gqgx.domain.GridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 系统参数
 * @author weihongjun
 *
 */
@Controller
@RequestMapping("/parameter")
public class SysParameterAction {

	@Autowired
	private SysParameterService sysParameterService;
	
	@RequestMapping("/parameterIndex")
	public ModelAndView parameterIndex()
	{
		ModelAndView veiw =new ModelAndView("/systemInfo/parameterIndex");
		return veiw;
	}
	
	@RequestMapping("/addParameter")
	public ModelAndView addParameter()
	{
		ModelAndView veiw =new ModelAndView("/systemInfo/editParameter");
		return veiw;
	}
	
	@RequestMapping("/editParameter")
	public ModelAndView editParameter(Long id)
	{
		ModelAndView veiw =new ModelAndView("/systemInfo/editParameter");
		if(id!=null){
			SysParameter sysParameter = sysParameterService.getSysParameter(id);
			veiw.addObject("sysParameter", sysParameter);
		}
		return veiw;
	}
	
	@RequestMapping("/parameterList")
    @ResponseBody
    public GridResult<SysParameter> parameterList(SysParameter sysParameter, Page page)
    {
		PagingResult<SysParameter> result = sysParameterService.findParameterListByPage(sysParameter, page);
		return new GridResult<SysParameter>(result, page.getPage(), page.getRows());
    } 
	
	@RequestMapping("/findById")
    @ResponseBody
	public SysParameter findById(Long id)
	{
		SysParameter sysParameter = sysParameterService.getSysParameter(id);
		return sysParameter;
	}
	
	@RequestMapping("/saveSysParameter")
    @ResponseBody
	public int saveSysParameter(SysParameter sysParameter)
	{
		return sysParameterService.saveSysParameter(sysParameter);
	}
	
	@RequestMapping("/deleteParameter")
    @ResponseBody
	public int deleteParameter(SysParameter sysParameter)
	{
		return sysParameterService.deleteSysParameter(sysParameter);
	}
	
	
}
