<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML>
<html style="overflow-y: hidden;">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="${cxtPath}/images/favicon.ico">
<LINK rel="Shortcut Icon" href="${cxtPath}/images/favicon.ico" />
<jsp:include page="/html/baseCommon.jsp"></jsp:include>
<script src="${cxtPath}/js/choose/chooseCustomer.js"></script>
<title>选择客户</title>
</head>
<body class="page_body">
	<div class="page_tool">		
		<div style="float: right;">
			<form class="layui-form" id="quickForm">
				<div class="layui-form-item">
					<div class="layui-inline page_tool_input">
						<div class="layui-input-inline input-width">
							<input type="text" name="customerName" class="input layui-input"
								placeholder="请输入客户名称">
						</div>
						<div class="layui-input-inline input-width">
							<input type="text" name="customerMobile" class="input layui-input"
								placeholder="请输入客户手机号码">
						</div>
						<a class="button layui-btn" onclick="searchCustomer();"><i class="layui-icon">&#xe615;</i>查询</a>
						<a class="button layui-btn" onclick="clearSearchCustomer();"><i class="layui-icon">&#x1006;</i>清空</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div>
		<table id="customerTable" lay-filter="chooseCustomer"></table>
	</div>
</body>
</html>