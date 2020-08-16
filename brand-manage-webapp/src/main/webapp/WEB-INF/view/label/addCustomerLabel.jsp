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
<title>新增客户标签</title>
</head>
<body>
	<div style="margin: 20px;">
		<form class="layui-form editform" id="labelForm">
		    <input value="${label.id}" name="id" type="hidden" />
		    <input value="${labelCategoryId}" name="labelCategoryId" type="hidden" />
			<input value="${label.labelSeq}" name="labelSeq" type="hidden" />
			<div class="layui-row">
				<div class="layui-col-xs12">
					<label class="layui-form-label">标签名称</label>
					<div class="layui-input-block">
						<input type="text" name="labelName" value="${label.labelName}" class="layui-input" lay-verify="required"
						 placeholder="请填写标签名称">
					</div>
				</div>
			</div>
			<div class="layui-row">
				<div class="layui-col-xs12">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-block">
						<textarea placeholder="请输入内容" class="layui-textarea" name="remark">${label.remark}</textarea>
					</div>
				</div>
			</div>
			<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			layui.use(['form'], function() {
				form = layui.form;
	
				//监听提交
				form.on('submit', function(data){
					saas.ajax({
						type: "post",
						url: "/label/saveCustomerLabel",
						data: $("#labelForm").serialize(),
						success: function(data){
							parent.window.location.reload();
						}
					});
				});
			});
		})
	</script>
</body>
</html>
