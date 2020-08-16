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
<script src="${cxtPath}/js/article/articleindex.js"></script>
<title>文章管理</title>
</head>
<body class="page_body">
	<div class="page_tool">
		<div style="float: left;" class="layui-btn-group pageTool">
			<a class="layui-btn" val="articleCategory">文章栏目</a>
			<a class="layui-btn layui-btn-primary" val="article">文章列表</a>
		</div>
		
		<div style="float: right;">
			<form class="layui-form" id="quickForm">
				<div class="layui-form-item">
					<div class="layui-inline page_tool_input">
						<div class="layui-input-inline input-width">
							<input type="text" id="categoryName" class="input layui-input"
								placeholder="分类名称">
						</div>
						<a class="button layui-btn page_tool_bt1"
							onclick="searchArticle();">查询</a> <a class="button layui-btn gjsearch"
							style="padding: 2px; margin-left: -4px !important;" title="高级查询"> <i class="layui-icon">&#xe625;</i></a>

						<a class="button layui-btn page_tool_bt2"
							onclick="allJurisdiction();">全部操作<i class="layui-icon">&#xe625;</i></a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div>
		<table id="articleTable"></table>
	</div>

	<!-- 高级查询 -->
	<div class="advancedSeach" id="advancedSeach">
		<form class="layui-form" id="advancedSeachForm">
			<div class="layui-form-item">
				<label class="layui-form-label">文章城市</label>
				<div class="layui-input-block">
					<select name="cityId">
						<option value="">请选择</option>
						<c:forEach items="${citys}" var="city">
						<option value="${city.id}">${city.areaName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<center>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-fluid" onclick="searchArticle();">查询</a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-primary" onclick="clearSearchArticle();">清空</a>
				</div>
				</center>
			</div>
		</form>
	</div>

	<!-- 全部权限 -->
	<div class="allJurisdiction"
		id="allJurisdiction">
		<dl class="layui-nav-child layui-anim layui-anim-upbit">
			<shiro:hasPermission name="cxwzflxz">
			<dd onclick="addArticleCategory();" style="padding-left: 24px;" class="addArticleCategory">
				<a href="#">新增分类</a>
			</dd>
			</shiro:hasPermission>
			<shiro:hasPermission name="cxwzxz">
			<dd onclick="addArticle();" style="padding-left: 24px;display: none;" class="addArticle">
				<a href="#">新增文章</a>
			</dd>
			</shiro:hasPermission>
		</dl>
	</div>
	
	<script type="text/html"  id="articleCategoryToolbar">
	<div class="layui-btn-group">
		<shiro:hasPermission name="cxwzflpx">
			<button class="layui-btn layui-btn-sm" onclick="articleCategorySort()">排序</button>
		</shiro:hasPermission>

		<shiro:hasPermission name="cxwzflxg">
			<button class="layui-btn layui-btn-sm" onclick="addArticleCategory({{d.id}})">修改</button>
		</shiro:hasPermission>

		<shiro:hasPermission name="cxwzflsc">
			<button class="layui-btn layui-btn-sm" onclick="delArticleCategory({{d.id}})">删除</button>
		</shiro:hasPermission>
	</div>
	</script>
	
	<script type="text/html"  id="articleToolbar">
	<div class="layui-btn-group">
		<shiro:hasPermission name="cxwzyl">
			<button class="layui-btn layui-btn-sm" onclick="preArticle({{d.id}})">预览</button>
		</shiro:hasPermission>

		<shiro:hasPermission name="cxwzxg">
			<button class="layui-btn layui-btn-sm" onclick="addArticle({{d.id}})">修改</button>
		</shiro:hasPermission>

		<shiro:hasPermission name="cxwzsc">
			<button class="layui-btn layui-btn-sm" onclick="delArticle({{d.id}})">删除</button>
		</shiro:hasPermission>
	</div>
	</script>
</body>
</html>
