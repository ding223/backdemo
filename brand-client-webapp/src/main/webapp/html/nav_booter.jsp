<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<footer id="t3-footer" class="wrap t3-footer">
<style>
	.booterul a{
		color:#fff;
	}
</style>
<div class="container">
	<div class="t3-spotlight t3-footnav  row" style="color: #fff !important;">
		<div class="col-xs-8">
			<div class="t3-module module" id="Mod294">
				<div class="module-inner">
					<h3 class="module-title">
						<span>商标服务</span>
					</h3>
					<div class="module-ct booterul">
						<ul style="margin-top:20px;">
							<li style="display:inline-block;width:150px;margin-bottom: 10px;">
								<a class="" href="${ctxPath}/niceclass/">通用尼斯</a>
							</li>
							<li style="display:inline-block;width:150px;margin-bottom: 10px;">
								<a class="" href="${ctxPath}/usaclass/">美国商标</a>
							</li>
							<li style="display:inline-block;width:150px;margin-bottom: 10px;">
								<a class="" href="${ctxPath}/euroclass/">欧盟商标</a>
							</li>
							<li style="display:inline-block;width:150px;margin-bottom: 10px;">
								<a class="" href="${ctxPath}/auclass/">澳洲商标</a>
							</li>
							<li style="display:inline-block;width:150px;margin-bottom: 10px;">
								<a class="" href="${ctxPath}/jpclass/">日本商标</a>
							</li>
							<li style="display:inline-block;width:150px;margin-bottom: 10px;">
								<a class="" href="${ctxPath}/korclass/">韩国商标</a>
							</li>
							<li style="display:inline-block;width:150px;margin-bottom: 10px;">
								<a class="" href="${ctxPath}/russiaclass/">俄罗斯商标</a>
							</li>
							<c:forEach items="${navtionList}" var="item" varStatus="index">
								<li style="display:inline-block;width:150px;margin-bottom: 10px;">
									<a class="" href="${ctxPath}/${item.url}${item.id}/">${item.name}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-xs-4">
			<div class="t3-module module" id="Mod572">
				<div class="module-inner">
					<h3 class="module-title">
						<span>联系方式</span>
					</h3>
					<div class="module-ct">
						<div class="custom">
							<div class="about-mod">
								<div class="contact-address">
									<ul class="contact-address">
										<li><em class="fa fa-home"></em> <span
											class="contact-street">青岛市 中山路 百盛国际商务中心2907室</span></li>
										<li><em class="fa fa-phone"></em> <span
											class="contact-telephone">400-007-7967</span></li>
										<li><span><a style="color:#21c2f8;"
													href="http://p.qiao.baidu.com//im/index?siteid=18714&amp;ucid=976946"
													target="_blank" rel="nofollow">在线咨询客服</a></span></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-12">
			<div class="t3-module module" id="Mod294">
				<div class="module-inner">
					<h3 class="module-title">
						<span>友情链接</span>
					</h3>
					<div class="module-ct booterul">
						<ul style="margin-top:20px;">
							<c:forEach items="${friendShipList}" var="item" varStatus="index">
								<li style="display:inline-block;width:150px;margin-bottom: 10px;">
									<a class="" href="${item.url}" target="target">${item.name}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>