<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="${cxtPath}/images/favicon.ico">
<LINK rel="Shortcut Icon" href="${cxtPath}/images/favicon.ico" />
<jsp:include page="/html/baseCommon.jsp"></jsp:include>
<title>新增员工</title>
<style type="text/css">
	#userForm .layui-form-checkbox {
		width: 200px;
		padding-bottom: 2px;
		padding-top: 2px;
	}
	
	#userForm .layui-form-checkbox span {
		width: 150px;
	}
	
	.downpanel .layui-select-title span {
		line-height: 38px;
	}
	
	.downpanel dl dd:hover {
		background-color: inherit;
	}
	
	.layui-form-checkbox span {
		height: 30px;
	}
	
	.layui-field-title {
		border-top: 1px solid white;
	}
</style>
</head>
<body >
	<form class="layui-form editform" id="userForm" style="margin: 20px;margin-top: 0px;">
	    <input value="${sysUser.id}" name="id" type="hidden" />
		<div class="layui-row">
			<div class="layui-col-xs6">
				<label class="layui-form-label">登录账号</label>
				<div class="layui-input-block">
					<input type="text" name="accountName" value="${sysUser.accountName}" lay-verify="required" class="layui-input" placeholder="请填写登录账号">
				</div>
			</div>
			<div class="layui-col-xs6">
				<label class="layui-form-label">所属部门</label>
		        <div class="layui-input-block">
		            <div class="layui-unselect layui-form-select downpanel">
		            	<%int count = 0;%>
		                <select name="departmentId" id="departmentId" lay-verify="required">
		                	<c:forEach items="${departmentList}" var="department">
		                		<c:if test="${sysUser.departmentId eq department.id}">
		                			<option selected value="${department.id }">${department.name}</option>
		                			<%count++;%>
		                		</c:if>
							</c:forEach>
							<%if(count == 0){%>
		                	<option value="">请选择部门</option>
		                	<%}%>
		                </select>
		                <dl class="layui-anim layui-anim-upbit">
		                    <dd>
		                        <ul id="classtree"></ul>
		                    </dd>
		                </dl>
		            </div>
		        </div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-xs6">
				<label class="layui-form-label">员工名称</label>
				<div class="layui-input-block">
					<input type="text" name="name" value="${sysUser.name}" lay-verify="required" class="layui-input" placeholder="请填写员工名称">
				</div>
			</div>
			<div class="layui-col-xs6">
				<label class="layui-form-label">联系方式</label>
				<div class="layui-input-block">
					<input type="text" name="phone" value="${sysUser.phone}" lay-verify="required|gqgx_phone"  class="layui-input" placeholder="请填写联系方式">
				</div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-xs6">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-block">
			      <input type="radio" name="sex" value="0" title="男" ${sysUser.sex eq '0'?'checked':'' } >
			      <input type="radio" name="sex" value="1" title="女" ${sysUser.sex eq '1'?'checked':'' } >
			    </div>
			</div>
			<div class="layui-col-xs6">
				<label class="layui-form-label">员工状态</label>
				<div class="layui-input-block">
					<input type="radio" name="userStatus" value="0" title="在职" ${sysUser.userStatus eq '0'?'checked':'' }>
			        <input type="radio" name="userStatus" value="1" title="离职" ${sysUser.userStatus eq '1'?'checked':'' }>
				</div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-xs12">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容"  class="layui-textarea" name="remark">${sysUser.remark}</textarea>
				</div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-xs12">
				<label class="layui-form-label">担任职位</label>
				<div class="layui-input-block"  >
			       <c:forEach items="${positions}" var="position" varStatus="i">
			       		<c:if test="${empty sysUser.id}">
							<input   type="checkbox"   value="${position.id}" lay-skin="primary" name="userPositions[${i.index }].positionId" title="${position.name }">
			       		</c:if>
			       		<c:if test="${not empty sysUser.id}">
				       		<input  type="hidden" value="${position.supId}" name="userPositions[${i.index }].id">
							<input   type="checkbox"   value="${position.id}" lay-skin="primary" ${empty position.supId ?'':'checked' } name="userPositions[${i.index }].positionId" title="${position.name }">
			       		</c:if>
					</c:forEach>
			    </div>
			</div>
		</div>
		<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
	</form>
	<script type="text/javascript">
		$(function() {
		    layui.use(['element', 'tree', 'layer', 'form', 'upload'], function () {
		        var $ = layui.jquery, tree = layui.tree , form = layui.form;
		        tree({
		            elem: "#classtree",
		            nodes: loadDepartmentTree(),
		            click: function (node) {
		                var $select = $($(this)[0].elem).parents(".layui-form-select");
		                $select.removeClass("layui-form-selected");
		                $('#departmentId').html('<option selected="selected" value="'+node.id+'">'+node.name+'</option>')
		                form.render('select'); 
		            }
		        });
		        $(".downpanel").on("click", ".layui-select-title", function (e) {
		            $(".layui-form-select").not($(this).parents(".layui-form-select")).removeClass("layui-form-selected");
		            $(this).parents(".downpanel").toggleClass("layui-form-selected");
		            layui.stope(e);
		        }).on("click", "dl i", function (e) {
		            layui.stope(e);
		        });
		        $(document).on("click", function (e) {
		            $(".layui-form-select").removeClass("layui-form-selected");
		        });
		
		      	//监听提交
				form.on('submit', function(data){
					saveUser();
				});
		    });
		});
		
		//加载部门树
	    function loadDepartmentTree(){
	    	var dataList;
	    	var url=appName+"/department/departmentList";
	    	 $.ajax({
	    	        dataType : "json",
	    	        type : "POST",
	    	        async: false,
	    	        url : url, 
	    	        success : function(data) {
	    	        	dataList=data;
	    	        }  
	    	  });
	    	 return dataList;
	    }
		
		//保存员工
		var saveUser = function(){
			saas.ajax({
				type: "post",
				url: "/user/saveUser",
				async:false,
				data: $("#userForm").serialize(),
				success: function(data){
					parent.layer.msg("保存成功！");
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
					parent.searList();
				}
			});
		}
	</script>
</body>
</html>
