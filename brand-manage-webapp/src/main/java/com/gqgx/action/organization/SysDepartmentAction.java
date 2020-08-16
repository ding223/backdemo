package com.gqgx.action.organization;

import com.gqgx.common.entity.SysDepartment;
import com.gqgx.common.entity.vo.LayUITreeVo;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**部门管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/department")
public class SysDepartmentAction {

	@Autowired
	private SysDepartmentService sysDepartmentService;
	
	@RequestMapping("/departmentList")
	@ResponseBody
	public List<LayUITreeVo> departmentList(){
		return sysDepartmentService.getDepartmentTree();
	}
	
	@RequestMapping("/addDepartment")
	public ModelAndView addDepartment(Long id)
	{
		ModelAndView view =new ModelAndView("/user/addDepartment");
		if(!Objects.isEmpty(id)){
			SysDepartment departmentObj = sysDepartmentService.getSysDepartment(id);
			view.addObject("departmentObj", departmentObj);
		}
		List<SysDepartment> departmentList=sysDepartmentService.departmentList();
		view.addObject("departmentList", departmentList);
		return view;
	}
	
	@RequestMapping("/saveDepartment")
	@ResponseBody
	public int saveDepartment(SysDepartment  sysDepartment){
		return sysDepartmentService.saveSysDepartment(sysDepartment);
	}
	
	@RequestMapping("/delDepartment")
	@ResponseBody
	public int delDepartment(SysDepartment  sysDepartment){
		return sysDepartmentService.deleteSysDepartment(sysDepartment);
	}
}
