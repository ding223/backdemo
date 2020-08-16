<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>商标后台管理</title>
</head>
<body>
	<div class="layui-layout layui-layout-admin kit-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">
				<img alt="" src="${appCustomer.manageIndexLogo}">
			</div>
			<div class="layui-logo kit-logo-mobile">K</div>
			<ul class="layui-nav layui-layout-right kit-nav" lay-filter="kitNavbar" kit-navbar="">
				<li class="layui-nav-item">
					<a href="javascript:;"> 
						${currentLoginUser.name}
					</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:;" kit-target="" 
							data-options="{url:'${cxtPath}/user/myInfo?sysMenuId=42',icon:'',title:'我的信息',id:'16'}">基本资料</a>
						</dd>
						<dd>
							<a onclick="loginOut();">切换账号</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a onclick="loginOut();"><i class="layui-icon layui-icon-password" aria-hidden="true"></i> 注销  </a>
				</li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black kit-side">
			<div class="layui-side-scroll">
				<!-- 1、左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar"
					kit-navbar>
					<c:forEach items="${sysMenu}" var="parentMenu">
						<li class="layui-nav-item">
							<c:if test="${empty parentMenu.parentId}">
								<a href="javascript:;"><i class="layui-icon ${parentMenu.menuIcon}" aria-hidden="true"></i> <span> ${parentMenu.name }</span></a>
								<c:forEach items="${sysMenu}" var="childMenu" varStatus="index">
									<%--遍历展示子菜单--%>
									<c:if test="${childMenu.parentId == parentMenu.id}">
										<dl class="layui-nav-child">
											<dd>
												<a href="javascript:;" kit-target
													data-options="{url:'${cxtPath}${childMenu.url}?sysMenuId=${childMenu.id}',icon:'${childMenu.menuIcon}',title:'${childMenu.name}',id:'${index.index}'}"><i
													class="layui-icon ${childMenu.menuIcon}"></i> <span>
														${childMenu.name}</span></a>
											</dd>
										</dl>
									</c:if>
								</c:forEach>
							</c:if>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="layui-body" id="container">
			<!-- 2、内容主体区域 -->
			<div style="padding: 15px;">主体内容加载中,请稍等...</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$(function(){
		var message,layer;
		layui.config({
			base : '${cxtPath}/build/js/'
		}).use([ 'app', 'message','layer' ], function() {
			var app = layui.app,
				$ = layui.jquery,
				layer = layui.layer;
			//将message设置为全局以便子页面调用
			message = layui.message;
			//主入口
			app.set({type : 'iframe'}).init();
		});
	})
	
	//注销登录
	var loginOut = function(){
		layer.confirm('确定要注销登录吗?', {icon: 3, title:'提示', skin: 'layui-layer-molv'}, function(index){
	       	window.location.href = '${cxtPath}/logout.html';
		});
	}
	
	//table高度
	var tableHeight = function(){
		return $(window).height()-190;
	}
</script>