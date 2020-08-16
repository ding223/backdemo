<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!-- jquery脚本 -->
<link href="${cxtPath}/js/plugins/message/message.css" rel="stylesheet">
<link href="${cxtPath}/css/login.css" rel="stylesheet">
<script src="${cxtPath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${cxtPath}/js/plugins/message/message.js"></script>
<title>商标后台管理系统</title>
</head>
<body>
	<div>
		<div class="header">
			<img class="header_logo" src="${appCustomer.manageLoginLogo}">
		</div>
		<div class="logo_content">
			<div class="content_wrapper">
				<div class="login_pic">
					<img src="images/login_pic.jpg" height="390px" width="570px">
				</div>
				<div class="login_container" id="login"
					style="width: 340px; height: 387px; visibility: visible;">
					<div class="login">
						<div id="header" class="header">
							<div class="switch" id="switch">
								<a class="switch_btn">登 录</a>
							</div>
						</div>
						<div>
							<form class="layui-form" action="" id="userLoginForm">
								<div class="layui-form-item">
									<input type="text" id="accountName" name="accountName" placeholder="请输入登录账号" class="layui-input">
								</div>
								<div class="layui-form-item">
									<input type="password" id="passWord" name="passWord" placeholder="请输入登录密码" class="layui-input">
								</div>
								<div class="layui-form-item">
									<a class="layui-btn" style="width: 100%;" onclick="user_login();">登 录</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer">
			<a href="" target="_blank">
			更新科技提供技术支持
			</a>&nbsp;|&nbsp;
			Copyright © 2018 www.guoqigengxi.com All Rights Reserved 版权所有 </span>
		</div>
	</div>
	
	<!-- 小程序二维码 -->
	<div class="weixin_nr">
		<div class="arrow"></div>
		<img src="${appCustomer.wechatSmallrtQrcode}" width="100" height="100" />
	</div>
	
	<div class="wap_nr">
		<div class="arrow"></div>
		<img src="${appCustomer.wapQrcode}" width="100" height="100" />
	</div>
	
</body>
</html>
<script type="text/javascript">
	//获取焦点
	$("#accountName").focus();

	//按下enter键登录
	document.onkeydown = function(event_e) {
		var evt = window.event ? window.event : event_e;
		if (evt.keyCode == 13) {
			user_login();
		}
	}

	//登录
	var user_login = function() {
		var accountName = $("#accountName").val().trim();
		var passWord = $("#passWord").val().trim();

		if (!accountName || !passWord) {
			$.message({
				message : '<font style="font-size:14px;font-family: \'微软雅黑\'">登录账号或者密码为空！</font>',
				type : 'warning',
				time : 3000
			});
			return false;
		}

		$.ajax({
			dataType : "json",
			type : "post",
			data : $("#userLoginForm").serialize(),
			url : "${cxtPath}/login",
			success : function(data) {
				if (data.code == '200') {
					$.message({
						message : '<font style="font-size:14px;font-family: \'微软雅黑\'">登录成功！正在跳转到后台，请稍等...！</font>',
						type : 'success',
						autoClose : false
					});
					setTimeout(function() {
						window.location.href = "${cxtPath}/index";
					}, 2000)

				} else {
					$.message({
						message : '<font style="font-size:14px;font-family: \'微软雅黑\'">'
								+ data.msg + '</font>',
						type : 'error',
						time : 3000
					});
				}
			}
		});
	}

	function getCtxPath() {
		return "${ctxPath}";
	}
</script>