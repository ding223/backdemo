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
<script src="${cxtPath}/js/choose/chooseUser.js"></script>
<title>选择用户</title>
</head>
<body>
	<div style="padding: 5px; background-color: #F2F2F2;">
		<div class="layui-row layui-col-space5">
			<div class="layui-col-md3" id="departmentCart">
				<div class="layui-card">
					<div class="layui-card-header">部门</div>
					<div class="layui-card-body" id="department"></div>
				</div>
			</div>
			<div class="layui-col-md9">
				<div class="layui-card">
					<div class="layui-card-body">
						<div class="page_tool">
							<div style="float: left;" class="layui-btn-group pageTool"
								id="selectParment"></div>

							<div style="float: right;">
								<form class="layui-form" id="quickForm">
									<div class="layui-form-item">
										<div class="layui-inline page_tool_input">
											<div class="layui-input-inline input-width">
												<input type="text" id="searName" class="input layui-input"
													placeholder="名称或号码">
											</div>
											<a class="button layui-btn page_tool_bt1"
												onclick="searchuser();">查询</a>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div>
							<table id="userTable" class="layui-table" lay-filter="userTable"></table>
						</div>

						<!-- 高级查询 -->
						<div id="advancedSeach">
							<form class="layui-form" id="advancedSeachForm">
								<input type="hidden" value="${departmentId}" id="departmentId"
									name="departmentId">
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>