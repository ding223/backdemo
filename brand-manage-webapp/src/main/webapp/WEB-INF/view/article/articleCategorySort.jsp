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
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="${cxtPath}/images/favicon.ico">
<LINK rel="Shortcut Icon" href="${cxtPath}/images/favicon.ico" />
<jsp:include page="/html/baseCommon.jsp"></jsp:include>
<style type="text/css">
.column {
	width: 400px;
}

.portlet {
	margin: 0 1em 1em 0;
	padding: 0.3em;
	background: #fff;
	font-size: 16px;
	border: 1px solid #009f95;
	border-radius: 5px;
}

.portlet-header {
	padding: 10px;
	margin-bottom: 0.5em;
	position: relative;
	background: #009f95;
	color: #fff;
	cursor: default;
}

.portlet-content {
	height: 320px;
	overflow: auto;
	padding: 0.4em;
}

.sortableItem {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

.sortableItem li {
	margin: 5px;
	padding: 10px;
	font-size: 14px;
	text-align: left;
}

.sortableItem li span {
	position: absolute;
	margin-bottom: 5px;
}

.sortableItemButton {
	margin: 5px;
	margin-top: 12px;
}

.sortableItem li:hover {
	border-color: #009f95;
	color: #009f95;
	cursor: move;
}

.sortableItem li .layui-icon {
	padding-right: 10px;
	font-size: 18px;
}

.sortableItem li .layui-icon:hover {
	cursor: pointer;
}

.ui-widget-content:hover {
	border: 1px solid #009f95;
}

.ui-widget-content {
	border: none !important;
}
</style>
<script src="${cxtPath}/js/article/articleCategorySort.js"></script>
<title>文章分类管理</title>
</head>
<body class="page_body">
	<div id="sortableDiv" align="center">
		<div class="column">
			<div class="portlet">
				<div class="portlet-content">
					<ul class="sortableItem">
					
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
