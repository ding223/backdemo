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
		<form class="layui-form editform" id="largeTypeForm">
			<input type="hidden" name="id" value="${largeType.id}">
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">分类目录</label>
					<div class="layui-input-block">
						<input type="text" name="catalog" lay-verify="required" 
							class="layui-input" placeholder="请填写分类目录" value="${largeType.catalog }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">分类号</label>
					<div class="layui-input-block">
						<input type="text" name="no" lay-verify="required" 
							class="layui-input" placeholder="请填写分类号" value="${largeType.no }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">分类号(中文)</label>
					<div class="layui-input-block">
						<input type="text" name="cnno" lay-verify="required" 
							class="layui-input" placeholder="请填写分类号" value="${largeType.cnno }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">分类名称</label>
					<div class="layui-input-block">
						<input type="text" name="name" lay-verify="required" 
							class="layui-input" placeholder="请填写分类名称" value="${largeType.name }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">分类简介</label>
					<div class="layui-input-block">
						<textarea class="layui-textarea" placeholder="请填写分类简介" name="instruction">${largeType.instruction }</textarea>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">分类说明</label>
					<div class="layui-input-block">
						<textarea class="layui-textarea" placeholder="请填写分类说明" name="remark">${largeType.remark }</textarea>
					</div>
				</div>
			</div>
			<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
		</form>
	</div>
	
	<script src="${cxtPath}/js/generalNice/addGnLargeType.js"></script>
</body>
</html>
