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
<title>新增文章</title>
</head>
<body>
	<div style="margin: 20px;">
		<form class="layui-form editform" id="articleForm" style="margin-left: 150px;">
			<input type="hidden" name="id" value="${article.id}">
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">文章标题</label>
					<div class="layui-input-block">
						<input type="text" name="title" lay-verify="required" style=""
							class="layui-input" placeholder="请填写文章标题" value="${article.title }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">所属分类</label>
					<div class="layui-input-block">
						<select name="categoryId" lay-verify="required">
							<option value="">请选择</option>
							<c:forEach items="${categorys}" var="category">
								<option value="${category.id}" <c:if test="${article.categoryId eq category.id}">selected</c:if>>${category.categoryName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">所属城市</label>
					<div class="layui-input-block">
						<select name="cityId" lay-verify="required">
							<option value="">请选择</option>
							<c:forEach items="${citys}" var="city">
								<option value="${city.id}" <c:if test="${article.cityId eq city.id}">selected</c:if>>${city.areaName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">是否显示</label>
					<div class="layui-input-block">
						<input type="radio" ${article.isShow eq '0' ? 'checked':'' }  name="isShow" value="0" title="显示" >
 				 		<input type="radio" ${article.isShow eq '1' ? 'checked':'' }  name="isShow" value="1" title="不显示">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">文章关键词</label>
					<div class="layui-input-block">
						<input type="text" name="keyword" style=""
							class="layui-input" placeholder="请填写文章关键词" value="${article.keyword }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">文章描述</label>
					<div class="layui-input-block">
						<input type="text" name="depict" style=""
							class="layui-input" placeholder="请填写文章描述" value="${article.depict }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">文章作者</label>
					<div class="layui-input-block">
						<input type="text" name="author" lay-verify="required" style=""
							class="layui-input" placeholder="请填写文章作者" value="${article.author }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">文章来源</label>
					<div class="layui-input-block">
						<input type="text" name="source" style=""
							class="layui-input" placeholder="请填写文章来源" value="${article.source }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">文章内容</label>
					<script id="editor" type="text/plain" style="height:400px;margin-left: 110px;"></script>
					<script type="text/javascript">
						var content = '${article.content}';
					</script>
				</div>
			</div>
			<div class="layui-row" style="margin-top: 20px;">
				<div class="layui-col-xs11">
					<label class="layui-form-label">展现图片</label>
					<div class="layui-input-block">
						<div class="layui-upload-drag" id="imgUrl" style="padding:10px;">
							<c:if test="${empty article.imgUrl}">
								<i class="layui-icon"></i>
								<p>点击上传图片</p>
							</c:if>
							<c:if test="${not empty article.imgUrl}">
								<img width="250px" height="160px" src="${article.imgUrl}" />
							</c:if>
						</div>
						<input type="hidden" id="imgUrlVal" name="imgUrl" value="${article.imgUrl}">
					</div>
				</div>
			</div>
			<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
		</form>
	</div>
	
	<script src="${cxtPath}/js/article/addArticle.js"></script>
</body>
</html>
