<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html style="overflow-y: hidden;">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<jsp:include page="/html/baseCommon.jsp"></jsp:include>
<link href="${cxtPath}/css/gqgxSortable.css" rel="stylesheet">
<script src="${cxtPath}/js/common/gqgxSortable.js"></script>
<script src="${cxtPath}/js/label/customerLabelList.js"></script>
<title>客户标签管理</title>
</head>
 	<%--权限 --%>
	<shiro:hasPermission name="kebqflxz">
		<script type="text/javascript">
			power.push("kebqflxz");
		</script>
	</shiro:hasPermission>
	<shiro:hasPermission name="kebqflxg">
		<script type="text/javascript">
			power.push("kebqflxg");
		</script>
	</shiro:hasPermission>
	<shiro:hasPermission name="kebqflsc">
		<script type="text/javascript">
			power.push("kebqflsc");
		</script>
	</shiro:hasPermission>
	<shiro:hasPermission name="kebqflpx">
		<script type="text/javascript">
			power.push("kebqflpx");
		</script>
	</shiro:hasPermission>
	
	<shiro:hasPermission name="kebqxz">
		<script type="text/javascript">
			power.push("kebqxz");
		</script>
	</shiro:hasPermission>
	<shiro:hasPermission name="kebqxg">
		<script type="text/javascript">
			power.push("kebqxg");
		</script>
	</shiro:hasPermission>
	<shiro:hasPermission name="kebqsc">
		<script type="text/javascript">
			power.push("kebqsc");
		</script>
	</shiro:hasPermission>
	<shiro:hasPermission name="kebqpx">
		<script type="text/javascript">
			power.push("kebqpx");
		</script>
	</shiro:hasPermission>
  	<script>
  	$(function() {
	  	var url = appName+"/label/customerLabelSortableList";
	  	var sortable={
  			tableName:'#sortableDiv',
  			sortableItem:{
  			}
  		}
	  	
	  	//分类权限
	  	if(power.contain('kebqflxz')){
	  		sortable.addTable = function(){
	  			addCustomerLabelCategory();
			}
	  	}
	  	if(power.contain('kebqflxg')){
	  		sortable.editTable = function(id){
  				addCustomerLabelCategory(id);
  			}
	  	}
	  	if(power.contain('kebqflsc')){
	  		sortable.delTable = function(that,id){
	  			delCustomerLabelCategory(that,id);
			}
	  	}
	  	if(power.contain('kebqflpx')){
	  		sortable.sortableStop = function(ids){
	  			reSortableCustomerLabelCategory(ids);
  			}
	  	}
	  	
	  	//标签权限
	  	if(power.contain('kebqxz')){
	  		sortable.sortableItem.addTableItem = function(categoryId){
	  			addCustomerLabel(categoryId);
  			}
	  	}
	  	if(power.contain('kebqxg')){
	  		sortable.sortableItem.editTableItem = function(id){
	  			editCustomerLabel(id);
  			}
	  	}
	  	if(power.contain('kebqsc')){
	  		sortable.sortableItem.delTableItem = function(that,id){
  				delCustomerLabel(that,id);
  			}
	  	}
	  	if(power.contain('kebqpx')){
	  		sortable.sortableItem.sortableItemStop = function(ids){
	  			reSortableCustomerLabel(ids);
  			}
	  	}
		loadSortable(url,sortable);
  	});
  	</script>
</head>
<body class="page_body gray-bg" style="overflow:auto;height:550px;">
 	<div id="sortableDiv">
		
 	</div>
</body>
</html>