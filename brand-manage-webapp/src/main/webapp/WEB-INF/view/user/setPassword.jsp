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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="${cxtPath}/images/favicon.ico">
<LINK rel="Shortcut Icon" href="${cxtPath}/images/favicon.ico" />
<jsp:include page="/html/baseCommon.jsp"></jsp:include>
<title>设置密码</title>
</head>
<body>
	<form class="layui-form editform" id="userForm" style="margin: 20px;margin-top: 0px;">
	    <input value="${sysUser.id}" name="id" type="hidden" />
		<div class="layui-form-item">
			<div class="layui-col-xs12">
				<label class="layui-form-label">登录账号</label>
				<div class="layui-input-block">
					<input type="text" name="accountName" value="${sysUser.accountName}" required="true" class="layui-input" placeholder="请填写登录账号">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-col-xs12">
				<label class="layui-form-label">登录密码</label>
				<div class="layui-input-block">
					<input type="text" name="passWord" value="" required="true" class="layui-input" placeholder="请填写登录密码">
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
	var savePassword = function(){
		var count;
		if($("#userForm").valid()){
			saas.ajax({
				type: "post",
				url: "/user/savePassword",
				async:false,
				data: $("#userForm").serialize(),
				success: function(data){
					count=data;
				}
			});
		}
		return count;
	}
	
	</script>
</body>
</html>
