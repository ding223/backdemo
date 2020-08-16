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
<title>新增自定义商标项目</title>
</head>
<body>
	<div style="margin: 20px;">
		<form class="layui-form editform" id="dycLargeTypeItemForm">
			<input type="hidden" name="id" value="${item.id}">
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">所属导航</label>
					<div class="layui-input-block">
						<select name="navItemId" lay-verify="required">
							<option value="">请选择所属导航</option>
							<c:forEach items="${navItems}" var="nav">
								<option value="${nav.id}" <c:if test="${item.navItemId eq nav.id}">selected</c:if>>${nav.cityName}-${nav.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">所属类</label>
					<div class="layui-input-block">
						<select name="largeTypeId" lay-verify="required">
							<option value="">请选择所属类</option>
							<c:forEach items="${largeTypes}" var="large">
								<option value="${large.id}" <c:if test="${item.largeTypeId eq large.id}">selected</c:if>>${large.cnno}-${large.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">类编号</label>
					<div class="layui-input-block">
						<input type="text" name="typeNo" lay-verify="required" 
							class="layui-input" placeholder="请填写类编号" value="${item.typeNo }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">项目</label>
					<div class="layui-input-block">
						<input type="text" name="projectName" lay-verify="required" 
							class="layui-input" placeholder="请填写项目" value="${item.projectName }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">参考译文</label>
					<div class="layui-input-block">
						<input type="text" name="projectTranslation" lay-verify="required" 
							class="layui-input" placeholder="请填写参考译文" value="${item.projectTranslation }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">状态</label>
					<div class="layui-input-block">
						<select name="projectStatus">
							<option value="">请选择状态</option>
							<option value="A" <c:if test="${item.projectStatus eq 'A'}">selected</c:if>>A-新增项目</option>
							<option value="M" <c:if test="${item.projectStatus eq 'M'}">selected</c:if>>M-修改后重新发布的项目</option>
							<option value="X" <c:if test="${item.projectStatus eq 'X'}">selected</c:if>>X-商品或服务描述范例</option>
							<option value="D" <c:if test="${item.projectStatus eq 'D'}">selected</c:if>>D-已删除的项目</option>
						</select>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">生效日</label>
					<div class="layui-input-block">
						<input type="text" name="projectInvalidDate" class="layui-input" placeholder="请填写生效日" value="${item.projectInvalidDate }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">类型</label>
					<div class="layui-input-block">
						<input type="text" name="projectType"
							class="layui-input" placeholder="请填写类型" value="${item.projectType }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">版本</label>
					<div class="layui-input-block">
						<input type="text" name="projectVersion"
							class="layui-input" placeholder="请填写版本" value="${item.projectVersion }">
					</div>
				</div>
			</div>
			<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
		</form>
	</div>
	
	<script src="${cxtPath}/js/dycBrand/addDycLargeTypeItem.js"></script>
</body>
</html>
