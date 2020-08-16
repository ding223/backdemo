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
<script src="${cxtPath}/js/area/siteindex.js"></script>
<title>站点管理</title>
</head>
<body class="page_body">
	<div class="page_tool">
		<div style="float: right;">
			<form class="layui-form" id="quickForm">
				<div class="layui-form-item">
					<div class="layui-inline page_tool_input">
						<div class="layui-input-inline input-width">
							<input type="text" id="siteName" class="input layui-input"
								placeholder="站点名称">
						</div>
						<a class="button layui-btn page_tool_bt1"
							onclick="searchSite();">查询</a> <a class="button layui-btn gjsearch"
							style="padding: 2px; margin-left: -4px !important;" title="高级查询"> <i class="layui-icon">&#xe625;</i></a>

						<a class="button layui-btn page_tool_bt2"
							onclick="allJurisdiction();">全部操作<i class="layui-icon">&#xe625;</i></a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div>
		<table id="siteTable"></table>
	</div>

	<!-- 全部权限 -->
	<div class="allJurisdiction"
		id="allJurisdiction">
		<shiro:hasPermission name="cxzdxz">
		<dl class="layui-nav-child layui-anim layui-anim-upbit">
			<dd onclick="addSite();">
				<a href="#">新增</a>
			</dd>
		</dl>
		</shiro:hasPermission>
	</div>
	
	<script type="text/html"  id="toolbar">
	<div class="layui-btn-group">
		<shiro:hasPermission name="cxzdpx">
			<button class="layui-btn layui-btn-sm" onclick="siteSort()">排序</button>
		</shiro:hasPermission>

		<shiro:hasPermission name="cxzdxg">
			<button class="layui-btn layui-btn-sm" onclick="addSite({{d.id}})">修改</button>
		</shiro:hasPermission>

		<shiro:hasPermission name="cxzdsc">
			<button class="layui-btn layui-btn-sm" onclick="delSite({{d.id}})">删除</button>
		</shiro:hasPermission>
	</div>
	</script>
</body>
</html>
