<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
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
<script src="${cxtPath}/js/user/userIndex.js"></script>
<title>用户管理</title>
</head>
<body>

<div style="padding: 5px; background-color: #F2F2F2;">
  <div class="layui-row layui-col-space5">
    <div class="layui-col-md3" id="departmentCart">
      <div class="layui-card">
      	<div class="layui-card-header">
      		<div class="layui-btn-group">
	      		<shiro:hasPermission name="zzjgxzbm">
					<button class="layui-btn layui-btn-sm" onclick="addDepartment()">新增</button>
				</shiro:hasPermission>
				<shiro:hasPermission name="zzjgxgbm">
					<button class="layui-btn layui-btn-sm" onclick="editDepartment()">修改</button>
				</shiro:hasPermission>
				<shiro:hasPermission name="zzjgscbm">
					<button class="layui-btn layui-btn-sm" onclick="">删除</button>
				</shiro:hasPermission>
      		</div>
      	</div>
        <div class="layui-card-body" id="department">
		        
        </div>
      </div>
    </div>
    <div class="layui-col-md9">
      <div class="layui-card">
        <div class="layui-card-body">
		         <div class="page_tool">
		         	<div style="float: left;" class="layui-btn-group pageTool" id="selectParment">
					</div> 
					
					<div style="float: right;">
						<form class="layui-form" id="quickForm">
							<div class="layui-form-item">
								<div class="layui-inline page_tool_input">
									<div class="layui-input-inline input-width">
										<input type="text" id="searName" class="input layui-input" placeholder="名称或号码">
									</div>
									<a class="button layui-btn page_tool_bt1" onclick="searchuser();">查询</a> 
									<a class="button layui-btn gjsearch" style="padding: 2px; margin-left: -4px !important;" title="高级查询">
										 <i class="layui-icon">&#xe625;</i>
								    </a>
									<a class="button layui-btn page_tool_bt2" onclick="allJurisdiction();">全部操作<i class="layui-icon">&#xe625;</i></a>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div>
					<table id="userTable" class="layui-table" lay-filter="userTable"></table>
				</div>
				
				<!-- 高级查询 -->
				<div  id="advancedSeach">
					<form class="layui-form" id="advancedSeachForm">
						<input type="hidden" value="${departmentId}" id="departmentId" name="departmentId" >
					</form>
				</div>
			
				<!-- 全部权限 -->
				<div class="allJurisdiction" id="allJurisdiction">
					<dl class="layui-nav-child layui-anim layui-anim-upbit">
						<shiro:hasPermission name="zzjgxzyg">
							<dd onclick="editUser();">
								<a href="#">新增</a>
							</dd>
						</shiro:hasPermission>
					</dl> 
				</div>
        </div>
      </div>
    </div>
    
  </div>
</div> 

	<script type="text/html"  id="toolbar">
	<div class="layui-btn-group">
	   <shiro:hasPermission name="zzjgxgyg">
	      <button class="layui-btn layui-btn-sm" onclick="editUser('{{d.id}}')">编辑</button>
       </shiro:hasPermission>
	   <shiro:hasPermission name="zzjgscyg">
	 	 <button class="layui-btn layui-btn-sm" onclick="delUser('{{d.id}}')">删除</button>
	   </shiro:hasPermission>
	   <shiro:hasPermission name="zzjgszmm">
	 	 <button class="layui-btn layui-btn-sm" onclick="setPassword('{{d.id}}')">设置密码</button>
	   </shiro:hasPermission>
	</div>
	</script>

</body>