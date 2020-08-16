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
<title>新增商标导航</title>
</head>
<body>
	<div style="margin: 20px;">
		<form class="layui-form editform" id="navItemForm">
			<input type="hidden" name="id" value="${item.id}">
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">顺序号</label>
					<div class="layui-input-block">
						<input type="text" name="seq" lay-verify="required" 
							class="layui-input" placeholder="请填写顺序号" value="${not empty maxSeq?maxSeq:item.seq }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">导航名</label>
					<div class="layui-input-block">
						<input type="text" name="name" lay-verify="required" 
							class="layui-input" placeholder="请填写导航名" value="${item.name }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">区域</label>
					<div class="layui-input-block">
						<input type="text" name="cityName" lay-verify="required" 
							class="layui-input" placeholder="请填写区域" value="${item.cityName }">
					</div>
				</div>
			</div>
			<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
		</form>
	</div>
	
	<script src="${cxtPath}/js/navItem/addNavItem.js"></script>
</body>
</html>
