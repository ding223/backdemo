<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${ctxPath}/css/header.css" type="text/css">
<script type="text/javascript">
	//获取cookie列表
	function getCookieList(name){
		$.ajax({ 
			url: "${ctxPath}/getCookieList-"+name,
			type: 'GET',
			success: function(res){
	        	var cookielist = res;
	        	var html = '<ul class="category list-striped list-condensed">';
	        	for(var i = 0; i < cookielist.length; i++){
	        		html += '<li class="cat-list-row0">'+(i+1)+'、'+cookielist[i].name;
	        		html += '<img src="${ctxPath}/images/del.png" style="width:30px;height:30px;cursor:pointer;" onclick="delCookie('+cookielist[i].id+',this,\''+name+'\');"/>';
	        		html += '</li>';
	        	}
	        	html += '</li>';
	        	$('#cookieContent').html(html);
	        	$('#cookieName').html('<b>选中的商标项目('+cookielist.length+'项)</b>');
	    	}
		});
	}
</script>
<div class="modal fade" id="cookieList" tabindex="-1" role="dialog" aria-labelledby=""cookieList"" aria-hidden="true">
	<div class="modal-dialog" style="min-width: 50%;max-width: 80%;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h3 class="modal-title" id="cookieName">
					<b>选中的商标项目</b>
				</h3>
			</div>
			<div class="modal-body" id="cookieContent">
				
			</div>
		</div>
	</div>
</div>