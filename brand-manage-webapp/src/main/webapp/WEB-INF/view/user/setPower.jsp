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
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="${cxtPath}/images/favicon.ico">
<LINK rel="Shortcut Icon" href="${cxtPath}/images/favicon.ico" />
<jsp:include page="/html/baseCommon.jsp"></jsp:include>
<title>设置权限</title>
<style type="text/css">
	#permissionForm .layui-form-checkbox{
		width:180px;
		padding-bottom: 2px;
		padding-top: 2px;
	}
	
	#permissionForm .layui-form-checkbox span {
	    width:135px;
	}
</style>
</head>
<body>
	<form class="layui-form editform" id="permissionForm" style="margin: 20px; margin-top: 0px;">
		<input type="hidden" name="postionId" value="${postionId }">
		<table class="layui-table">
			<thead>
				<tr>
					<th width="120px">一级菜单</th>
					<th width="120px">二级菜单</th>
					<th>操作权限</th>
				</tr>
			</thead>
			<tbody>
				<% int menuIndex = 0;
				   int optionIndex = 0;
				%>
				<c:forEach items="${powerList}" var="menu">
				<tr>
					<td rowspan="${fn:length(menu.childs) + 1}" colspan="1">
						<input type="checkbox" name="menus[<%=menuIndex %>].id" title="${menu.name}" lay-skin="primary" 
							value="${menu.id}" <c:if test="${menu.isCheck eq 'check'}">checked</c:if>>
						<% menuIndex ++; %>
					</td>
				</tr>
				<c:forEach items="${menu.childs }" var="child">
				<tr>
					<td>
					<input type="checkbox" name="menus[<%=menuIndex %>].id" title="${child.name}" lay-skin="primary"
							value="${child.id}" <c:if test="${child.isCheck eq 'check'}">checked</c:if>>
                    <% menuIndex ++; %>
					</td>
					<td>
						<c:forEach items="${child.operations}" var="operation">
						<c:if test="${not empty operation.name}">
							<input type="hidden" name="operations[<%=optionIndex %>].menuId" value="${child.id}" />
							<input type="checkbox" name="operations[<%=optionIndex %>].id" title="${operation.name}" lay-skin="primary"
								value="${operation.id}" <c:if test="${operation.isCheck eq 'check'}">checked</c:if>>
                        	<% optionIndex ++; %>
						</c:if>
						</c:forEach>
					</td><!-- 操作 -->
				</tr>
				</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<script type="text/javascript">
		//保存权限
		function savePermission(){
			var index = layer.msg("正在保存权限，请稍等！",{icon:16});
			saas.ajax({
		        dataType : "json",
		        type : "POST",
		        data : $('#permissionForm').serialize(),
		        url : "/position/savePostionPermmistion", 
		        success : function(data) {
		        	if(data > 0){
		        		layer.msg('保存职位权限成功');
		        	}else{
		        		layer.msg('保存职位权限失败');
		        	}
		        	layer.close(index);
		        }
		    });
		}
		
		$(function(){
			layui.use(['form', 'layedit'], function() {
				var form = layui.form;
				form.render();
			})
		})
	</script>
</body>
</html>
