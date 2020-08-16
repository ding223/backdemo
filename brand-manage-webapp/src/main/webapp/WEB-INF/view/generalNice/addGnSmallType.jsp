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
<title>新增通用尼斯子类</title>
</head>
<body>
	<div style="margin: 20px;">
		<form class="layui-form editform" id="smallTypeForm">
			<input type="hidden" name="id" value="${smallType.id}">
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">商标大类</label>
					<div class="layui-input-block">
						<select name="largeTypeId" lay-verify="required">
							<option value="">请选择商标大类</option>
							<c:forEach items="${largeTypes}" var="large">
								<option value="${large.id}" <c:if test="${large.id eq smallType.largeTypeId}">selected</c:if>>${large.cnno}-${large.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">子类编号</label>
					<div class="layui-input-block">
						<input type="text" name="no" lay-verify="required" 
							class="layui-input" placeholder="请填写子类编号" value="${smallType.no }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">子类名称</label>
					<div class="layui-input-block">
						<textarea class="layui-textarea" placeholder="请填写子类名称" name="name">${smallType.name }</textarea>
					</div>
				</div>
			</div>
			<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
		</form>
	</div>
	
	<script src="${cxtPath}/js/generalNice/addGnSmallType.js"></script>
</body>
</html>
