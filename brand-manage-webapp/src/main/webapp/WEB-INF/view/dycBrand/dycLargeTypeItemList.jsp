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
<script src="${cxtPath}/js/dycBrand/dycLargeTypeListItemList.js"></script>
<title>自定义商标项目列表</title>
</head>
<body class="page_body">
	<div class="page_tool">
		<div style="float: right;">
			<form class="layui-form" id="quickForm">
				<div class="layui-form-item">
					<div class="layui-inline page_tool_input">
						<div class="layui-input-inline input-width">
							<input type="text" id="projectName" class="input layui-input"
								placeholder="项目名称">
						</div>
						<a class="button layui-btn page_tool_bt1"
							onclick="searchFriendShip();">查询</a> <a class="button layui-btn gjsearch"
							style="padding: 2px; margin-left: -4px !important;" title="高级查询"> <i class="layui-icon">&#xe625;</i></a>

						<a class="button layui-btn page_tool_bt2"
							onclick="allJurisdiction();">全部操作<i class="layui-icon">&#xe625;</i></a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div>
		<table id="DycLargeTypeItemTable" lay-filter="DycLargeTypeItemTable"></table>
	</div>

	<!-- 全部权限 -->
	<div class="allJurisdiction" id="allJurisdiction">
		<dl class="layui-nav-child layui-anim layui-anim-upbit">
			<dd onclick="addFriendShip();">
				<a href="#">新增</a>
			</dd>
			<dd onclick="importExcel();">
				<a href="#">导入</a>
			</dd>
			<dd style="padding-left:20px;">
				<a href="${cxtPath}/excel/dyc_demo.xls">下载excel</a>
			</dd>
		</dl>
	</div>
	<button type="button" class="layui-btn" id="uploadExcel" style="display:none;"><i class="layui-icon"></i>上传文件</button>
	
	<script type="text/html"  id="toolbar">
	<div class="layui-btn-group">
		<button class="layui-btn layui-btn-sm" onclick="addFriendShip({{d.id}})">修改</button>
		<button class="layui-btn layui-btn-sm" onclick="delFriendShip({{d.id}})">删除</button>
	</div>
	</script>
	
	<!-- 高级查询 -->
	<div class="advancedSeach" id="advancedSeach">
		<form class="layui-form" id="advancedSeachForm">
			<div class="layui-form-item">
				<label class="layui-form-label">导航栏</label>
				<div class="layui-input-block">
					<select name="navItemId" lay-verify="required">
						<option value="">请选择所属导航</option>
						<c:forEach items="${navItems}" var="nav">
							<option value="${nav.id}">${nav.cityName}-${nav.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<center>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-fluid" onclick="searchFriendShip();">查询</a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-primary" onclick="clearSearchFriendShip();">清空</a>
				</div>
				</center>
			</div>
		</form>
	</div>
</body>
</html>
