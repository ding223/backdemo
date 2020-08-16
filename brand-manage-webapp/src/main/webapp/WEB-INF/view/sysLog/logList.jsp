<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
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
<script src="${cxtPath}/js/sysLog/logList.js"></script>
<title>系统访问日志</title>
</head>
<body class="page_body">
	<div class="page_tool">
		<div style="float: right;">
			<form class="layui-form" id="quickForm">
				<div class="layui-form-item">
					<div class="layui-inline page_tool_input">
						<div class="layui-input-inline input-width">
							<input type="text" id="userName" class="input layui-input"
								placeholder="用户名称">
						</div>
						<a class="button layui-btn page_tool_bt1"
							onclick="searchSysLog();">查询</a> <a class="button layui-btn gjsearch"
							style="padding: 2px; margin-left: -4px !important;" title="高级查询"> <i class="layui-icon">&#xe625;</i></a>

						<a class="button layui-btn page_tool_bt2"
							onclick="allJurisdiction();">全部操作<i class="layui-icon">&#xe625;</i></a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div>
		<table id="logTable" class="layui-table"></table>
	</div>

	<!-- 高级查询 -->
	<div class="advancedSeach" id="advancedSeach">
		<form class="layui-form" id="advancedSeachForm">
			<div class="layui-form-item">
				<label class="layui-form-label">IP地址</label>
				<div class="layui-input-block">
					<input type="text" name="ipAddress" placeholder="请填写IP地址"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">操作时段</label>
				<div class="layui-input-block">
					<input type="text" name="startDateStr" id="startTime" placeholder="yyyy-MM-dd" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<input type="text" name="endDateStr" id="endTime" placeholder="yyyy-MM-dd" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<center>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-fluid" onclick="searchSysLog();">查询</a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-primary" onclick="clearSearchSysLog();">清空</a>
				</div>
				</center>
			</div>
		</form>
	</div>
</body>
</html>
