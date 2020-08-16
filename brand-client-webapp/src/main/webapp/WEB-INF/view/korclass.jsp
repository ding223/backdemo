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
	<title>韩国${largeType.catalog}类  ${largeType.name}</title>
</c:if>
<c:if test="${empty largeType}">
	<title>韩国商标注册用《商品与服务分类表》</title>
</c:if>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta http-equiv="Cache-Control" content="no-transform">
<LINK rel="Bookmark" href="${ctxPath}/images/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="${ctxPath}/images/favicon.ico">
<link rel="stylesheet" href="${ctxPath}/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="${ctxPath}/css/index.css" type="text/css">
<link rel="stylesheet" href="${ctxPath}/css/footer.css" type="text/css">
<link rel="stylesheet" href="${ctxPath}/css/pagination.css">
<link rel="stylesheet" href="${ctxPath}/css/font-awesome.min.css" type="text/css">
<jsp:include page="/html/common.jsp"></jsp:include>
<script type="text/javascript" src="${ctxPath}/js/jquery.pagination.js"></script>
</head>
<body>
	<input type="hidden" id="currentNavId" value="korclass">
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
											href="${ctxPath}/korclass.html" target="_self"><span
												style="color: #ffffff;">韩国商品与服务区分表</span></a>
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
							<li class="active"><span>韩国商品与服务项目</span></li>
						</c:if>
						<c:if test="${not empty largeType and empty smallType}">
							<li><a href="${ctxPath}/korclass.html" class="pathway">韩国商品与服务项目</a></li>
							<li class="active"><span>${largeType.name}</span></li>
						</c:if>
						<c:if test="${not empty smallType and not empty largeType}">
							<li><a href="${ctxPath}/korclass.html" class="pathway">韩国商品与服务项目</a></li>
							<li><a href="${ctxPath}/korclass/class${largeType.id}.html" class="pathway">${largeType.name}</a></li>
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
									<blockquote>
										<c:if test="${not empty largeType and empty smallType}">
											<b>韩国《商品和服务分类表》使用说明</b><br/>
											本韩国商标注册用分类表最后更新于2019年1月。<br/>
											参考译文为程序自动翻译，仅供参考使用，具体内容应以英文项目为准。<br/>
										</c:if>
										<c:if test="${empty largeType and empty smallType}">
											<b>韩国《商品和服务分类表》使用说明</b><br/>
											本韩国商标注册用分类表最后更新于2019年1月。<br/>
											参考译文为程序自动翻译，仅供参考使用，具体内容应以英文项目为准。<br/>
										</c:if>
									</blockquote>
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
					<div class="cbListView">
						<form action="" method="post" name="adminForm" id="adminForm"
							onsubmit="return false">
							<c:if test="${not empty largeType}">
								<h1 class="contentheading">韩国${largeType.catalog}类  ${largeType.name}</h1>
							</c:if>
							<div style="float: right; text-align: right;"></div>
							<div style="clear: both;"></div>
							<div id="cbFilterTitleWrap"
								style="float: left; padding-right: 5px;">通过关键词筛选：&nbsp;</div>
							<div id="cbFilterWrap" style="float: left; padding-right: 5px;">
								<input style="max-width: 200px;" type="text"
									id="contentbuilder_filter" name="filter" value="${filter}"
									class="inputbox" onchange="document.adminForm.submit();">
							</div>
							<div id="cbSearchButtonWrap"
								style="float: left; padding-right: 5px;">
								<button class="button btn btn-secondary cbButton cbSearchButton"
									onclick="document.adminForm.submit();">搜索</button>
								<button class="button btn btn-secondary cbButton cbResetButton"
									onclick="document.getElementById('contentbuilder_filter').value='';document.adminForm.submit();">重置</button>
								<button class="button btn btn-secondary cbButton cbSearchButton"
									onclick="getCookieList('korclass');" data-toggle="modal" data-target="#cookieList">获取标记值</button>
							</div>
							<div style="float: left; padding-right: 5px;">
								<i class="fa fa-info-circle"> </i>&nbsp;&nbsp;<span
									style="font-size: 12pt; color: #003366;">如果您已知晓查找项目所属类别，先选择类别再搜索，可以缩小查找范围，提高搜索精度。</span>
							</div>
							
							<input type="hidden" name="largeTypeId" value="${largeType.id}">
							<input type="hidden" name="smallTypeId" value="${smallType.id}">
							<input type="hidden" name="page" id="list-page" value="${currentPage}">
						</form>
						
						<!-- 表格内容 -->
						<table class="category table table-striped" width="100%" border="0" cellspacing="0" cellpadding="2" style="font-size:14px;margin-top: 50px;">
							<thead>
								<tr>
									<th class="sectiontableheader"><a>标记</a></th>
									<th class="sectiontableheader" style="min-width:100px;">类别</th>
									<th class="sectiontableheader hidden-phone" style="min-width:500px;">项目</th>
									<th class="sectiontableheader hidden-phone" style="min-width:100px;">类似群</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${smallTypeItemList}" var="item" varStatus="index">
									<tr class="row${index.index/2}">
										<td>
											<c:set var="ckStatus" value="1"/>
											<c:forEach items="${korCookieList}" var="ck">
												<c:if test="${ck.id eq item.id}">
													<input type="checkbox" value="" checked="checked" id="cookie_checkbox_${item.id}" 
													onclick="setKorClassCookie(this,${item.id},'${item.projectName}');">
													<c:set var="ckStatus" value="0"/>
												</c:if>
											</c:forEach>
											
											<c:if test="${ckStatus eq 1}">
												<input type="checkbox" value="" id="cookie_checkbox_${item.id}" 
												onclick="setKorClassCookie(this,${item.id},'${item.projectName}');">
												<c:set var="ckStatus" value="0"/>
											</c:if>
										</td>
										<td>${item.typeNo}</td>
										<td class="hidden-phone">${item.projectName}</td>
										<td class="hidden-phone">${item.projectGroup}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- 分页 -->
						<div class="M-box"></div>
						<script type="text/javascript">
							$('.M-box').pagination({
								totalData: '${total}',
								showData: 60,
								current: '${currentPage}',
								coping: true,
							    callback: function (api) {
							    	$('#list-page').val(api.getCurrent());
							    	document.adminForm.submit();
							    }
							}); 
							
							//设置值
							function setKorClassCookie(obj,id,name){
								if($(obj).is(':checked')){
									$.ajax({ 
										url: "${ctxPath}/setKorClassCookie",
										type: 'POST',
										data:{id:id, name: name},
										success: function(){
								    	}
									});
								}else{
									$.ajax({ 
										url: "${ctxPath}/cancelKorClassCookie/"+id,
										type: 'POST',
										success: function(){
								    	}
									});
								}
								
							}
							
							//清除值
							function delCookie(id,obj,name){
								$.ajax({ 
									url: "${ctxPath}/cancelKorClassCookie/"+id,
									type: 'POST',
									success: function(){
										$(obj).parent().remove();
										$('#cookie_checkbox_'+id).prop("checked",false);
										getCookieList(name);
									}
								});
							}
						</script>
						
					</div>
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
														href="${ctxPath}/korclass.html" target="_self">韩国《商品与服务区分表》</a>目录</span>
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
																		<a href="${ctxPath}/korclass/class${item.id}/">${item.catalog}</a>
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
														<a href="${ctxPath}/korclass/class${item.id}/" target="_self"> 
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

<!-- 选中的商标项目 -->
<jsp:include page="/html/cookie_content.jsp"></jsp:include>