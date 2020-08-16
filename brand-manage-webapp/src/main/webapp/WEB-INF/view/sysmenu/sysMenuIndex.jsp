<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE HTML>
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
<script src="${cxtPath}/js/sysmenu/sysMenuIndex.js"></script>
<title>菜单管理</title>
</head>
  	<%--权限 --%>
	<shiro:hasPermission name="xzyjcd">
		<script type="text/javascript">
			power.push("xzyjcd");
		</script>
	</shiro:hasPermission>
	<shiro:hasPermission name="xgyjcd">
		<script type="text/javascript">
			power.push("xgyjcd");
		</script>
	</shiro:hasPermission>
	<shiro:hasPermission name="scyjcd">
		<script type="text/javascript">
			power.push("scyjcd");
		</script>
	</shiro:hasPermission>
	<shiro:hasPermission name="pxyjcd">
		<script type="text/javascript">
			power.push("pxyjcd");
		</script>
	</shiro:hasPermission>
	
	<shiro:hasPermission name="xzejcd">
		<script type="text/javascript">
			power.push("xzejcd");
		</script>
	</shiro:hasPermission>
	<shiro:hasPermission name="xgejcd">
		<script type="text/javascript">
			power.push("xgejcd");
		</script>
	</shiro:hasPermission>
	<shiro:hasPermission name="scejcd">
		<script type="text/javascript">
			power.push("scejcd");
		</script>
	</shiro:hasPermission>
	<shiro:hasPermission name="pxejcd">
		<script type="text/javascript">
			power.push("pxejcd");
		</script>
	</shiro:hasPermission>
  
  <script>
  	$(function() {
	  	var url=appName+"/menu/sortableList";
	  	var sortable={
  			tableName:'#sortableDiv',
  			sortableItem:{
  			}
  		}
	  	
		//一级菜单权限
	  	if(power.contain('xzyjcd')){
	  		sortable.addTable = function(){
	  			addParmenu();
			}
	  	}
	  	if(power.contain('xgyjcd')){
	  		sortable.editTable = function(id){
	  			addParmenu(id);
			}
	  	}
	  	if(power.contain('scyjcd')){
	  		sortable.delTable = function(that,id){
	  			delSortable(that,id);
			}
	  	}
	  	if(power.contain('pxyjcd')){
	  		sortable.sortableStop = function(ids){
	  			reSortable(ids);
			}
	  	}
	  	
	  	//二级菜单权限
	  	if(power.contain('xzejcd')){
	  		sortable.sortableItem.addTableItem = function(parentId){
	  			addChildSysmenu(null,parentId);
			}
	  	}
	  	if(power.contain('xgejcd')){
	  		sortable.sortableItem.editTableItem = function(id){
	  			editChildSysmenu(id);
			}
	  	}
	  	if(power.contain('scejcd')){
	  		sortable.sortableItem.delTableItem = function(that,id){
	  			delSortableItem(that,id);
			}
	  	}
	  	if(power.contain('pxejcd')){
	  		sortable.sortableItem.sortableItemStop = function(ids){
	  			reSortableItem(ids);
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
