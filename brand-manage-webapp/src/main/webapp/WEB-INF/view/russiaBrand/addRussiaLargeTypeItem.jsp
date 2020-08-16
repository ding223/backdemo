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
<script type="text/javascript" charset="utf-8" src="${cxtPath}/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${cxtPath}/js/ueditor/ueditor.all.js"> </script>
<script type="text/javascript" charset="utf-8" src="${cxtPath}/js/ueditor/lang/zh-cn/zh-cn.js"></script>
<style type="text/css">
	.layui-anim-upbit{z-index: 999999 !important;}
</style>
<title>新增俄罗斯商标项目</title>
</head>
<body>
	<div style="margin: 20px;">
		<form class="layui-form editform" id="russiaLargeTypeItemForm">
			<input type="hidden" name="id" value="${item.id}">
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">所属类</label>
					<div class="layui-input-block">
						<select name="largeTypeId" lay-verify="required">
							<option value="">请选择所属类</option>
							<c:forEach items="${largeTypes}" var="large">
								<option value="${large.id}" <c:if test="${item.largeTypeId eq large.id}">selected</c:if>>${large.cnno}-${large.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">标题</label>
					<div class="layui-input-block">
						<input type="text" name="title" lay-verify="required" 
							class="layui-input" placeholder="请填写标题" value="${item.title }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">内容</label>
					<div class="layui-input-block">
						<script id="editor" type="text/plain" style="height:400px;"></script>
						<script type="text/javascript">
							var content = '${item.content}';
						</script>
					</div>
				</div>
			</div>
			<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
		</form>
	</div>
	
	<script src="${cxtPath}/js/russiaBrand/addRussiaLargeTypeItem.js"></script>
</body>
</html>
