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
<title>新增欧盟商标类项目</title>
</head>
<body>
	<div style="margin: 20px;">
		<form class="layui-form editform" id="euroLargeTypeItemForm">
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
					<label class="layui-form-label">类别</label>
					<div class="layui-input-block">
						<input type="text" name="typeNo" lay-verify="required" 
							class="layui-input" placeholder="请填写类别" value="${item.typeNo }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">项目</label>
					<div class="layui-input-block">
						<input type="text" name="projectName" lay-verify="required" 
							class="layui-input" placeholder="请填写项目" value="${item.projectName }">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">Coor(C)</label>
					<div class="layui-input-block">
						<input type="radio" name="projectCoor" value="0" title="是" <c:if test="${item.projectCoor eq '0'}">checked</c:if>>
      					<input type="radio" name="projectCoor" value="1" title="否" <c:if test="${item.projectCoor eq '1'}">checked</c:if>>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">Harm(H)</label>
					<div class="layui-input-block">
						<input type="radio" name="projectHarm" value="0" title="是" <c:if test="${item.projectHarm eq '0'}">checked</c:if>>
      					<input type="radio" name="projectHarm" value="1" title="否" <c:if test="${item.projectHarm eq '1'}">checked</c:if>>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">Nice(N)</label>
					<div class="layui-input-block">
						 <input type="radio" name="projectNice" value="0" title="是" <c:if test="${item.projectNice eq '0'}">checked</c:if>>
      					<input type="radio" name="projectNice" value="1" title="否" <c:if test="${item.projectNice eq '1'}">checked</c:if>>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">Idli(N)</label>
					<div class="layui-input-block">
						 <input type="radio" name="projectIdli" value="0" title="是" <c:if test="${item.projectIdli eq '0'}">checked</c:if>>
      					<input type="radio" name="projectIdli" value="1" title="否" <c:if test="${item.projectIdli eq '1'}">checked</c:if>>
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs11">
					<label class="layui-form-label">Mgs(M)</label>
					<div class="layui-input-block">
						 <input type="radio" name="projectMgs" value="0" title="是" <c:if test="${item.projectMgs eq '0'}">checked</c:if>>
      					<input type="radio" name="projectMgs" value="1" title="否" <c:if test="${item.projectMgs eq '1'}">checked</c:if>>
					</div>
				</div>
			</div>
			<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
		</form>
	</div>
	
	<script src="${cxtPath}/js/euroBrand/addEuroLargeTypeItem.js"></script>
</body>
</html>
