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
<title>新增部门</title>
</head>
<body>
	<form class="layui-form editform" id="departmentForm" style="margin: 20px;margin-top: 0px;">
	    <input value="${departmentObj.id}" name="id" type="hidden" />
		<div class="layui-form-item">
			<div class="layui-col-xs12">
				<label class="layui-form-label">上级部门</label>
				<div class="layui-input-block">
					<select name="parentId"  lay-verify="required" lay-search="">
						<option value="" >请选择</option>
						<c:forEach items="${departmentList}" var="department">
							<option ${departmentObj.parentId eq department.id?'selected':'' } value="${department.id }"  >${department.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-col-xs12">
				<label class="layui-form-label">部门名称</label>
				<div class="layui-input-block">
					<input type="text" name="name" value="${departmentObj.name}" required="true" class="layui-input" placeholder="请填写菜单名称">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-col-xs12">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" rows="10" class="layui-textarea" name="departmentDesc">${departmentObj.departmentDesc}</textarea>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">

	var saveDepartment = function(){
		if($("#departmentForm").valid()){
			saas.ajax({
				type: "post",
				url: "/department/saveDepartment",
				data: $("#departmentForm").serialize(),
				success: function(data){
					parent.window.location.reload();
				}
			});
		}
	}
	$(function(){
		layui.use(['form', 'layedit'], function() {
		})
	})
	</script>
</body>
</html>
