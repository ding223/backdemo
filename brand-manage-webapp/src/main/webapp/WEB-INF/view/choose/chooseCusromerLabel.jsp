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
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="${cxtPath}/images/favicon.ico">
<LINK rel="Shortcut Icon" href="${cxtPath}/images/favicon.ico" />
<jsp:include page="/html/baseCommon.jsp"></jsp:include>
<title>客户标签</title>
<style>
	.clicked{
		border: 1px solid #009688;
		color: white;
		background: #009688;
	}
	
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$('fieldset a').click(function(){
			$(this).toggleClass(function(){
				//获取当前点击的标签
				var labelName = $(this).text();
				var labelId = $(this).attr("id");
				var click = 'noclicked';
				//先清除标签
				parent.labels.remove(labelName);
				parent.labelIds.remove(labelId);
				if($(this).hasClass('noclicked')){
					//加入标签
					parent.labels.push(labelName);
					parent.labelIds.push(labelId);
					$(this).removeClass('noclicked');
					click = 'clicked';
				}else{
					$(this).removeClass('clicked');
				}
				//重新构建标签
				parent.buildLabelHtml();
				return click;
			})
		});
		
		var labelIds = parent.labelIds;
		if(labelIds.length > 0){
			$.each(labelIds,function(i,v){
				if($("#"+labelIds[i]).hasClass('noclicked')){
					$("#"+labelIds[i]).removeClass('noclicked');
					$("#"+labelIds[i]).addClass("clicked");
				}
			})
		}
	})
</script>
</head>
<body style="margin: 20px;">
	<div>
		<c:forEach items="${labelCategorys}" var="category">
			<fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;padding:20px;">
				<legend style="font-size:16px;">${category.labelCategoryName}</legend>
				<c:forEach items="${category.labels}" var="label">
					<a class="layui-btn layui-btn-primary layui-btn-sm noclicked" id="lab_${label.id}">
					${label.labelName}
					</a>
				</c:forEach>
			</fieldset>
		</c:forEach>
	</div>
</body>
</html>
