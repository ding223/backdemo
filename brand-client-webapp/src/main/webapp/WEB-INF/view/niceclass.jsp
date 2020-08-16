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
<c:if test="${not empty largeType and empty smallType}">
	<title>${largeType.catalog}类 ${largeType.name} » 类别: ${largeType.cnno}</title>
</c:if>
<c:if test="${not empty smallType}">
	<title>${smallType.no} ${smallType.name}</title>
</c:if>
<c:if test="${empty largeType and empty smallType}">
	<title>最新版商标注册用《类似商品和服务区分表》</title>
</c:if>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta http-equiv="Cache-Control" content="no-transform">
<LINK rel="Bookmark" href="${ctxPath}/images/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="${ctxPath}/images/favicon.ico">
<jsp:include page="/html/common.jsp"></jsp:include>
</head>
<body>
	<input type="hidden" id="currentNavId" value="niceclass">
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
											href="${ctxPath}/niceclass.html" target="_self"><span
												style="color: #ffffff;">商品/服务区分表</span></a>
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
							<li class="active"><span>商品分类</span></li>
						</c:if>
						<c:if test="${not empty largeType and empty smallType}">
							<li><a href="${ctxPath}/niceclass.html" class="pathway">商品分类</a></li>
							<li class="active"><span>${largeType.name}</span></li>
						</c:if>
						<c:if test="${not empty smallType and not empty largeType}">
							<li><a href="${ctxPath}/niceclass.html" class="pathway">商品分类</a></li>
							<li><a href="${ctxPath}/niceclass/class${largeType.id}.html" class="pathway">${largeType.name}</a></li>
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
										<c:set value="${fn:split(largeType.remark, '|')}" var="remarks" />
										<blockquote>
										<c:forEach items="${remarks}" var="remark">
											${ remark }
										</c:forEach>
										</blockquote>
									</c:if>
									<c:if test="${empty largeType and empty smallType}">
										<blockquote>
										<b>《商标注册用商品和服务区分表》使用说明</b><br/>
										本分类表最后更新于2019年1月。《类似商标和服务区分表》采用层次代码结构。第一层为类别；第二层为组别（子类），如“0304”即表示第三大类的第四类似群组（子类）；第三层为商品和服务项目，采用六位数字，如“250045
											服装”。<br/>
											1、 编号前加“C”的项目为我国特有项目。<br/>
											2、 注册商标可以指定保护的为商品及服务项目，如“250045 服装”。<br/>
											3、对于跨类似群的项目，需要交叉检索。<br/>
											更多内容请点击查看<a
											href="javascript:void(0);" target="_blank"
											rel="nofollow" class="modal_link cboxElement"
											data-toggle="modal" data-target="#niceArticle">《商标注册用商品和服务分类说明》</a>全文
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
					<div class="cbListView">
						<form action="" method="post" name="adminForm" id="adminForm"
							onsubmit="return false">
							<c:if test="${not empty largeType and empty smallType}">
								<h1 class="contentheading">${largeType.catalog}类 ${largeType.name} » 类别: ${largeType.cnno}</h1>
							</c:if>
							<c:if test="${not empty smallType}">
								<h1 class="contentheading">${smallType.no} ${smallType.name}</h1>
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
									onclick="getCookieList('niceclass');" data-toggle="modal" data-target="#cookieList">获取标记值</button>
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
								<tr class="table_head">
									<th class="sectiontableheader"><a>标记</a></th>
									<th class="sectiontableheader"><a href="#"
										onclick="Joomla.tableOrdering('col2','asc','');return false;"
										class="hasTooltip" title=""
										data-original-title="<strong>组别</strong><br />点击根据此列排序">组别</a>
									</th>
									<th class="sectiontableheader hidden-phone"><a href="#"
										onclick="Joomla.tableOrdering('col3','asc','');return false;"
										class="hasTooltip" title=""
										data-original-title="<strong>项目编号</strong><br />点击根据此列排序">项目编号</a>
									</th>
									<th class="sectiontableheader hidden-phone" style="width:150px;"><a href="#"
										onclick="Joomla.tableOrdering('col4','asc','');return false;"
										class="hasTooltip" title=""
										data-original-title="<strong>项目名称（中文）</strong><br />点击根据此列排序">项目名称（中文）</a>
									</th>
									<th class="sectiontableheader hidden-phone"><a href="#"
										onclick="Joomla.tableOrdering('col5','asc','');return false;"
										class="hasTooltip" title=""
										data-original-title="<strong>项目名称（英文）</strong><br />点击根据此列排序">项目名称（英文）</a>
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${smallTypeItemList}" var="item" varStatus="index">
									<tr class="row${index.index/2}">
										<td>
											<c:set var="ckStatus" value="1"/>
											<c:forEach items="${niceCookieList}" var="ck">
												<c:if test="${ck.id eq item.id}">
													<input type="checkbox" value="" checked="checked" id="cookie_checkbox_${item.id}"
													onclick="setNiceClassCookie(this,${item.id},'${item.projectCnname}-${item.projectEnname}');">
													<c:set var="ckStatus" value="0"/>
												</c:if>
											</c:forEach>
											
											<c:if test="${ckStatus eq 1}">
												<input type="checkbox" value="" id="cookie_checkbox_${item.id}"
												onclick="setNiceClassCookie(this,${item.id},'${item.projectCnname}-${item.projectEnname}');">
												<c:set var="ckStatus" value="0"/>
											</c:if>
										</td>
										<td>${item.groupNo}</td>
										<td class="hidden-phone">${item.projectNo}</td>
										<td class="hidden-phone">${item.projectCnname}</td>
										<td class="hidden-phone"><span style="font-size: 8pt;">${item.projectEnname}</span>
										</td>
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
							function setNiceClassCookie(obj,id,name){
								if($(obj).is(':checked')){
									$.ajax({ 
										url: "${ctxPath}/setNiceClassCookie",
										type: 'POST',
										data:{id:id, name: name},
										success: function(){
								    	}
									});
								}else{
									$.ajax({ 
										url: "${ctxPath}/cancelNiceClassCookie/"+id,
										type: 'POST',
										success: function(){
								    	}
									});
								}
								
							}
							
							//清除值
							function delCookie(id,obj,name){
								$.ajax({ 
									url: "${ctxPath}/cancelNiceClassCookie/"+id,
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
														href="${ctxPath}/niceclass.html" target="_self">《类似商品和服务区分表》</a>目录</span>
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
																		<a href="${ctxPath}/niceclass/class${item.id}/">${item.catalog}</a>
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
														<a href="${ctxPath}/niceclass/class${item.id}/" target="_self"> 
															<span style="color: #21c2f8;">
																${item.instruction}
															</span>
														</a>
													</span>
													<c:if test="${fn:length(item.smallTypeList) > 0}">
													<span style="color: #b8a279; font-size: 10pt;">
														<a href="javaScript:void(0);" onclick="openSmall(${item.id});"><span style="color: #b8a279;">查看子类<em
																class="fa fa-arrow-circle-down"></em>
															</span>
														</a>
													</span>
													</c:if>
												</h4>
											</div>
											<c:if test="${fn:length(item.smallTypeList) > 0}">
											<div id="collapse-${item.id}" class="panel-collapse collapse">
												<div class="panel-body">
													<table style="width: 100%;" border="0" cellspacing="0"
														cellpadding="0">
														<tbody>
															<c:forEach items="${item.smallTypeList}" var="small">
															<tr>
																<td
																	style="border-width: 1pt medium; border-style: solid none; border-color: #a5a5a5 -moz-use-text-color; padding: 1pt;">
																	<p style="text-align: left;" align="left">
																		<span
																			style="font-size: 10pt; font-family: '微软雅黑', sans-serif;"><span
																			style="color: windowtext; text-decoration: none;">${small.no}</span></span>
																	</p>
																</td>
																<td
																	style="border-width: 1pt medium; border-style: solid none; border-color: #a5a5a5 -moz-use-text-color; padding: 1pt;">
																	<p style="text-align: left;" align="left">
																		<span style="font-size: 10pt;">
																			<a href="${ctxPath}/niceclass/class${item.id}/${small.no}/" target="_self">${small.name}</a>
																		</span>
																	</p>
																</td>
															</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
											</c:if>
										</div>
									</div>
									</c:forEach>
									
									<script type="text/javascript">
										function openSmall(id){
											var collapse = $('#collapse-'+id).hasClass('collapse');
											if(collapse){
												$('#collapse-'+id).removeClass('collapse');
											}else{
												$('#collapse-'+id).addClass('collapse');
											}
										}
									</script>
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
	
	<!-- 说明 -->
	<div class="modal fade" id="niceArticle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="min-width: 50%;max-width: 80%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h3 class="modal-title" id="myModalLabel">
						<b>商标注册用商品和服务分类说明</b>
					</h3>
				</div>
				<div class="modal-body">
					<jsp:include page="/html/nice_article.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 选中的商标项目 -->
	<jsp:include page="/html/cookie_content.jsp"></jsp:include>
	
</body>
</html>