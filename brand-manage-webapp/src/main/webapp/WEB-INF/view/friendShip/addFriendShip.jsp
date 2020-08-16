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
<title>新增友情链接</title>
</head>
<body>
	<div style="margin: 20px;">
		<form class="layui-form editform" id="shipForm">
			<input type="hidden" name="id" value="${ship.id}">
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">名称</label>
					<div class="layui-input-block">
						<input type="text" name="name" lay-verify="required" 
							class="layui-input" placeholder="请填写友情链接名称" value="${ship.name }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">地址</label>
					<div class="layui-input-block">
						<input type="text" name="url"
							class="layui-input" placeholder="请填写友情链接地址" value="${ship.url }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">图片</label>
					<div class="layui-input-block">
						<div class="layui-upload-drag" id="imgUrl" style="padding:10px;">
							<c:if test="${empty ship.imgUrl}">
								<i class="layui-icon"></i>
								<p>点击上传图片</p>
							</c:if>
							<c:if test="${not empty ship.imgUrl}">
								<img width="200px" src="${ship.imgUrl}" />
							</c:if>
						</div>
						<input type="hidden" id="shipUrlVal" name="imgUrl" value="${ship.imgUrl}">
					</div>
				</div>
			</div>
			<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
		</form>
	</div>
	
	<script src="${cxtPath}/js/friendShip/addFriendShip.js"></script>
</body>
</html>
