<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="${cxtPath}/images/favicon.ico">
<LINK rel="Shortcut Icon" href="${cxtPath}/images/favicon.ico" />
<jsp:include page="/html/baseCommon.jsp"></jsp:include>
<title>新增一级菜单</title>
</head>
<body>
	<form class="layui-form editform" id="menuForm" style="margin: 20px;margin-top: 0px;">
	    <input value="${menuObj.id}" name="id" type="hidden" />
		<input value="${menuObj.sort}" name="sort" type="hidden" />
		<div class="layui-row">
			<div class="layui-col-xs11">
				<label class="layui-form-label">菜单名</label>
				<div class="layui-input-block">
					<input type="text" name="name" value="${menuObj.name}" lay-verify="required" class="layui-input" placeholder="请填写菜单名称">
				</div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-xs11">
				<label class="layui-form-label">菜单图标</label>
				<div class="layui-input-block">
					<input type="text" id="iconPicker" lay-filter="iconPicker" name="menuIcon" class="layui-input" value="${menuObj.menuIcon}">
				</div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-xs11">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" class="layui-textarea" name="desc">${menuObj.desc}</textarea>
				</div>
			</div>
		</div>
		<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
	</form>
	<script type="text/javascript">
		$(document).ready(function() {
			layui.use(['form','element'], function() {
				var form = layui.form,element = layui.element;
	
				//监听提交
				form.on('submit', function(data){
					saveParmenu();
				});
			});
			
			layui.config({
				base : appName+'/build/js/'
			}).use(['iconPicker'], function() {
				var iconPicker = layui.iconPicker;
	            
	            iconPicker.render({
	                // 选择器，推荐使用input
	                elem: '#iconPicker',
	                // 数据类型：fontClass/unicode，推荐使用fontClass
	                type: 'fontClass'
	            });

	            /**
	             * 选中图标 （常用于更新时默认选中图标）
	             * @param filter lay-filter
	             * @param iconName 图标名称，自动识别fontClass/unicode
	             */
	            iconPicker.checkIcon('iconPicker', $('#iconPicker').val());
			})
		})

		// 保存一级菜单
		var saveParmenu = function(){
			saas.ajax({
				type: "post",
				url: "/menu/saveSysMenu",
				data: $("#menuForm").serialize(),
				success: function(data){
					parent.window.location.reload();
				}
			});
		}
	</script>
</body>
</html>
