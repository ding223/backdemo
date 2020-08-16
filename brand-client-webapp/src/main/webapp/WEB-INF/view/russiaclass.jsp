<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML>
<html>
<head>
<head>
<meta charset="UTF-8">
<meta name="keywords" content="商标注册,商标代理,知识产权代理,美国商标,欧盟商标,日本商标,代理美国商标注册,美国商标注册,商品分类,商标分类,国际商标,国际专利,国际版权" />
<meta name="description" content="商标注册,商标代理,知识产权代理,美国商标,欧盟商标,日本商标,代理美国商标注册,美国商标注册,商品分类,商标分类,国际商标,国际专利,国际版权" />
<c:if test="${not empty largeType}">
	<title>俄罗斯 ${largeType.catalog}类 ${largeType.name}</title>
</c:if>
<c:if test="${empty largeType}">
	<title>俄罗斯商标注册用《商品与服务分类表》</title>
</c:if>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta http-equiv="Cache-Control" content="no-transform">
<LINK rel="Bookmark" href="${ctxPath}/images/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="${ctxPath}/images/favicon.ico">
<jsp:include page="/html/common.jsp"></jsp:include>
</head>
<body>
	<input type="hidden" id="currentNavId" value="russiaclass">
	<div class="t3-wrapper">
		<!-- 头部 -->
		<jsp:include page="/html/nav_header.jsp"></jsp:include>

		<!-- banner -->
		<div class="noo-slideshow" id="noo-slideshow">
			<div class="t3-module module" id="Mod174">
				<div class="module-inner">
					<div class="module-ct">
						<div class="custom"
							style="background-image: url(${ctxPath}/images/banner-portfolio.jpg)">
							<div class="container clearfix">
								<div class="mod-banner">
									<h3>
										<span style="color: #ffffff;"> <a
											href="${ctxPath}/russiaclass.html" target="_self"><span
												style="color: #ffffff;">俄罗斯商品与服务区分表</span></a>
										</span>
									</h3>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 快捷导航 -->
		<nav class="wrap noo-breadcrumbs">
			<div class="container">
				<div class="">
					<ul class="breadcrumb">
						<li class="active"><i class="fa fa-home"></i></li>
						<li><a href="${ctxPath}/" class="pathway">首页</a> <span class="divider">
						</span></li>
						<c:if test="${empty largeType}">
							<li class="active"><span>俄罗斯商品与服务项目</span></li>
						</c:if>
						<c:if test="${not empty largeType and empty smallType}">
							<li><a href="${ctxPath}/russiaclass.html" class="pathway">俄罗斯商品与服务项目</a></li>
							<li class="active"><span>${largeType.name}</span></li>
						</c:if>
						<c:if test="${not empty smallType and not empty largeType}">
							<li><a href="${ctxPath}/russiaclass.html" class="pathway">俄罗斯商品与服务项目</a></li>
							<li><a href="${ctxPath}/russiaclass/class${largeType.id}.html" class="pathway">${largeType.name}</a></li>
							<li class="active"><span>${smallType.name}</span></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>

		<!-- 描述 -->
		<div class="container t3-sl t3-sl-1">
			<!-- SPOTLIGHT -->
			<div class="t3-spotlight t3-spotlight-1  row">
				<div class="col-xs-12">
					<div class="t3-module module" id="Mod228">
						<div class="module-inner">
							<div class="module-ct">
								<div class="custom">
									<c:if test="${not empty largeType and empty smallType}">
										<blockquote>
										<b>俄罗斯《商品和服务分类表》使用说明</b><br/>
										本俄罗斯商标注册用分类表最后更新于2019年1月。<br/>
										俄罗斯商标注册用分类表使用俄、英、法三种语言，我们使用三种不同的颜色标注以便阅览。<br/>
										关健词搜索方法：同时按下“Ctrl”和“Ｆ”键，输入查询的关键词。<br/>
										</blockquote>
									</c:if>
									<c:if test="${empty largeType and empty smallType}">
										<blockquote>
										<b>俄罗斯《商品和服务分类表》使用说明</b><br/>
										本俄罗斯商标注册用分类表最后更新于2019年1月。<br/>
										俄罗斯商标注册用分类表使用俄、英、法三种语言，我们使用三种不同的颜色标注以便阅览。<br/>
										关健词搜索方法：同时按下“Ctrl”和“Ｆ”键，输入查询的关键词。<br/>
										</blockquote>
									</c:if>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

		<!-- 主体内容 -->
		<div id="t3-mainbody" class="container t3-mainbody sidebar-left">
			<div class="row">
				<!-- 右边部分 -->
				<div id="t3-content" class="t3-content col-xs-8 col-xs-push-4">
					<c:if test="${not empty largeType}">
						<div class="page-header clearfix" style="padding-bottom: 12px;margin: 0 0 26px;border-bottom: 1px solid #c2c2c2;">
							<h1 class="page-title">俄罗斯 ${largeType.catalog}类 ${largeType.name}</h1>
						</div>
						<c:if test="${not empty article and not empty article.content}">
						${article.content}
						</c:if>
					</c:if>
					<c:if test="${empty article and empty largeType}">
						<jsp:include page="/html/russia_content.jsp"></jsp:include>
					</c:if>
				</div>

				<!-- 左边部分 -->
				<div class="t3-sidebar t3-sidebar-left col-xs-4 col-xs-pull-8">
					<div class="t3-module module-niceclass" id="Mod226">
						<div class="module-inner">
							<div class="module-ct">
								<div class="custom-niceclass">
									<div id="accordion" class="panel-group">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4>
													<span style="font-size: 16pt;"><a
														href="${ctxPath}/russiaclass.html" target="_self">俄罗斯《商品与服务区分表》</a></span>
												</h4>
											</div>
											<div id="collapse1" class="panel-collapse collapse in">
												<div class="panel-body">
													<span
														style="font-family: arial black, avant garde; font-size: 12pt;"><span
														style="font-family: arial black, avant garde; font-size: 12pt;"></span></span>
													<div style="width: 100%;">
														<c:forEach items="${largeTypeList}" var="item">
															<label style="width:28px;text-align: center;">
																<span style="font-family: arial black,avant garde; font-size: 12pt;">
																	<span style="font-family: arial black,avant garde; font-size: 12pt;">
																		<a href="${ctxPath}/russiaclass/class${item.id}/">${item.catalog}</a>
																	</span>
																</span>
															</label>
														</c:forEach>
													</div>
												</div>
											</div>
										</div>
									</div>
									<c:forEach items="${largeTypeList}" var="item">
									<div id="accordion" class="panel-group">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title" style="text-align: left;">
													<span style="font-size: 12pt;"><strong>${item.cnno}：</strong></span>
													<span style="color: #21c2f8; font-size: 10pt;"> 
														<a href="${ctxPath}/russiaclass/class${item.id}/" target="_self"> 
															<span style="color: #21c2f8;">
																${item.instruction}
															</span>
														</a>
													</span>
												</h4>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 底部 -->
		<jsp:include page="/html/nav_booter.jsp"></jsp:include>
		
	</div>
</body>
</html>