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
<title>新增通用尼斯大类</title>
</head>
<body>
	<div style="margin: 20px;">
		<form class="layui-form editform" id="smallTypeItemForm">
			<input type="hidden" name="id" value="${item.id}">
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">商标子类</label>
					<div class="layui-input-block">
						<select name="smallTypeId" lay-verify="required">
							<option value="">请选择商标子类</option>
							<c:forEach items="${smallTypes}" var="small">
								<option value="${small.id}" <c:if test="${small.id eq item.smallTypeId}">selected</c:if>>${small.no}-${small.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">组别</label>
					<div class="layui-input-block">
						<input type="text" name="groupNo" lay-verify="required" 
							class="layui-input" placeholder="请填写组别" value="${item.groupNo }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">组别</label>
					<div class="layui-input-block">
						<input type="text" name="projectNo" lay-verify="required" 
							class="layui-input" placeholder="请填写项目编号" value="${item.projectNo }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">项目名称（中文）</label>
					<div class="layui-input-block">
						<input type="text" name="projectCnname"
							class="layui-input" placeholder="请填写项目名称（中文）" value="${item.projectCnname }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">项目名称（英文）</label>
					<div class="layui-input-block">
						<input type="text" name="projectEnname"
							class="layui-input" placeholder="请填写项目名称（英文）" value="${item.projectEnname }">
					</div>
				</div>
			</div>
			<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
		</form>
	</div>
	
	<script src="${cxtPath}/js/generalNice/addGnSmallTypeItem.js"></script>
</body>
</html>
