<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="${ctxPath}/css/header.css" type="text/css">
<header id="t3-header" class="t3-header">
<div class="container">
	<div class="row">
		<!-- logo -->
		<div class="logo col-xs-3" style="min-height:100px;">
			<div class="logo-image">
				<a href="${ctxPath}/" style="float: left;"> 
					<img class="logo-img" src="${ctxPath}/images/logo.png"/>
				</a>
			</div>
		</div>

		<!-- 导航 -->
		<div class="col-xs-9">
			<nav id="t3-mainnav" class="navbar navbar-default t3-mainnav">
				<div class="t3-navbar navbar-collapse collapse">
					<ul class="nav navbar-nav level0" id="navList">
						<!-- 前7个固定导航 -->
						<li id="niceclass"><a class="" href="${ctxPath}/niceclass/">通用尼斯</a></li>
						<li id="usaclass"><a class="" href="${ctxPath}/usaclass/">美国商标</a></li>
						<li id="euroclass"><a class="" href="${ctxPath}/euroclass/">欧盟商标</a></li>
						<li id="auclass"><a class="" href="${ctxPath}/auclass/">澳洲商标</a></li>
						<li id="jpclass"><a class="" href="${ctxPath}/jpclass/">日本商标</a></li>
						<li id="korclass"><a class="" href="${ctxPath}/korclass/">韩国商标</a></li>
						<li id="russiaclass"><a class="" href="${ctxPath}/russiaclass/">俄罗斯商标</a></li>
						
						
						<!-- 其他更多导航 -->
						<c:if test="${fn:length(navtionList)>0}">
							<li id="${item.url}">
								<a class="more dropdown-toggle" data-toggle="dropdown" href="${ctxPath}/${item.url}/" 
									style="border: 1px solid #2f3339;color: #2f3339;border-radius: 20px;padding: 0px 10px 0px 10px;margin-top: 16px;font-size: 14px;margin-left: 10px;">
										更多<b class="caret"></b>
								</a>
								<ul class="dropdown-menu">
								<c:forEach items="${navtionList}" var="item" varStatus="index">
									<li id="${item.url}${item.id}"><a class="" href="${ctxPath}/${item.url}${item.id}/">${item.name}</a></li>
								</c:forEach>
								</ul>
							</li>
						</c:if>
					</ul>
				</div>
			</nav>
		</div>
	</div>
	
	<div class="x_left clearfix" style="float: left;cursor: pointer;">
		<div class="x_left_one fl"></div>
		<div class="x_left_two fl" id="currentCityName"></div>
		<div class="x_left_three fl"></div>
	</div>
	<div class="x_bottom" style="display: none;">
		<div class="x_bottom_jian">
			<img alt="" src="${ctxPath}/images/tongke_icon_address.png">
		</div>
		<div class="x_city" <c:if test="${fn:length(navtionList)>0}">style="margin-bottom: 40px;"</c:if>>
			<ul id="sites">
				<li id="niceclass-site" class="evt-city"><a class="" href="${ctxPath}/niceclass/">通用</a></li>
				<li id="usaclass-site" class="evt-city"><a class="" href="${ctxPath}/usaclass/">美国</a></li>
				<li id="euroclass-site" class="evt-city"><a class="" href="${ctxPath}/euroclass/">欧盟</a></li>
				<li id="auclass-site" class="evt-city"><a class="" href="${ctxPath}/auclass/">澳洲</a></li>
				<li id="jpclass-site" class="evt-city"><a class="" href="${ctxPath}/jpclass/">日本</a></li>
				<li id="korclass-site" class="evt-city"><a class="" href="${ctxPath}/korclass/">韩国</a></li>
				<li id="russiaclass-site" class="evt-city"><a class="" href="${ctxPath}/russiaclass/">俄罗斯</a></li>
				<c:forEach items="${navtionList}" var="item">
					<li id="${item.url}${item.id}-site" class="evt-city"><a class="" href="${ctxPath}/${item.url}${item.id}/">${item.cityName}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	
</div>
</header>

<!-- 商桥代码 -->

<!-- js -->
<script type="text/javascript">
	$(function(){
		var currentNavId = $('#currentNavId').val();
		
		if($('#'+currentNavId).hasClass('open')){
			$('#'+currentNavId).removeClass('open');
		}
		$('#'+currentNavId).addClass('open');
		
		if($('#'+currentNavId+'-site').hasClass('x_active')){
			$('#'+currentNavId+'-site').removeClass('x_active');
		}
		$('#'+currentNavId+'-site').addClass('x_active');
		$('#currentCityName').text($('#'+currentNavId+'-site').text());
		
		
		$(".x_left,.x_bottom").on("mouseenter", function() {
			$(".x_bottom").show();
			$(".x_left_one").addClass("x_left_ones");
			$(".x_left_two").addClass("x_left_twos");
			$(".x_left_three").addClass("x_left_threes");
		}).on("mouseleave", function() {
			$(".x_bottom").hide();
			$(".x_left_one").removeClass("x_left_ones");
			$(".x_left_two").removeClass("x_left_twos");
			$(".x_left_three").removeClass("x_left_threes");
		});
	})
</script>