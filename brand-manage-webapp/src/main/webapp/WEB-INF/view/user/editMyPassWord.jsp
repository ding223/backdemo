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
<title>修改密码</title>
</head>
<body >
	<form class="layui-form editform" id="userForm" style="margin: 20px;margin-top: 0px;">
	    <input value="${sysUser.id}" name="id" type="hidden" />
		<div class="layui-row">
			<label class="layui-form-label">新密码</label>
			<div class="layui-input-block">
				<input type="password" name="passWord" id="passWord"
				lay-verify="required" class="layui-input" placeholder="请填写新密码">
			</div>
		</div>
		<div class="layui-row">
			<label class="layui-form-label">确认密码</label>
			<div class="layui-input-block">
				<input type="password" name="conPassWord" id="confirmPassWord"
				lay-verify="required" class="layui-input" placeholder="请确认新密码">
			</div>
		</div>
		<div class="layui-row">
			<label class="layui-form-label">旧密码</label>
			<div class="layui-input-block">
				<input type="password" name="oldPassWord" 
				lay-verify="required" class="layui-input" placeholder="请填写旧密码">
			</div>
		</div>
		<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
	</form>
	<script type="text/javascript">
		$(function() {
		    layui.use(['element', 'tree', 'layer', 'form', 'upload'], function () {
		        var $ = layui.jquery, tree = layui.tree , form = layui.form;		        
		
		      	//监听提交
				form.on('submit', function(data){
					savePassWord();
				});
		    });
		});
		
		//修改密码
		var savePassWord = function(){
			var confirmPassWord = $('#confirmPassWord').val();
			var passWord = $('#passWord').val();
			if(confirmPassWord != passWord){
				layer.msg("两次密码不一致！",{icon:5, anim:6});
				return false;
			}
			saas.ajax({
		        dataType : "json",
		        type : "POST",
		        data : $("#userForm").serialize(),
		        url : "/user/savePassWord",  
		        success : function(data) {
		        	if(data == 100){
		        		layer.msg("旧密码不正确！",{icon:5, anim:6});
		        	}else{
		        		var index = parent.layer.getFrameIndex(window.name);
		    			parent.layer.close(index);
		        		parent.layer.msg("修改完成");
		        	}
		        }
		    });
		}
	</script>
</body>
</html>
