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
<title>新增职位</title>
</head>
<body>
	<form class="layui-form editform" id="positionForm" style="margin: 20px;margin-top: 0px;">
	    <input value="${sysPosition.id}" name="id" type="hidden" />
		<div class="layui-form-item">
			<div class="layui-col-xs12">
				<label class="layui-form-label">职位名称</label>
				<div class="layui-input-block">
					<input type="text" name="name" value="${sysPosition.name}" lay-verify="required" class="layui-input" placeholder="请填写职位名称">
				</div>
			</div>
		</div>
		<div class="layui-col-xs12">
			<label class="layui-form-label">数据权限</label>
			<div class="layui-input-block">
				 <input type="radio" ${sysPosition.dataPower eq '0' ? 'checked':'' }  name="dataPower" value="0" title="本人" >
 				 <input type="radio" ${sysPosition.dataPower eq '1' ? 'checked':'' }  name="dataPower" value="1" title="本部门">
 				 <input type="radio" ${sysPosition.dataPower eq '2' ? 'checked':'' }  name="dataPower" value="2" title="本部门及子部门" >
 				 <input type="radio" ${sysPosition.dataPower eq '3' ? 'checked':'' }  name="dataPower" value="3" title="全公司">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-col-xs12">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" class="layui-textarea" name="remark">${sysPosition.remark}</textarea>
				</div>
			</div>
		</div>
		<a class="layui-btn" lay-submit id="lay-submit" style="display: none;"></a>
	</form>
	<script type="text/javascript">

		var savePosition = function(){
			saas.ajax({
				type: "post",
				url: "/position/savePosition",
				async:false,
				data: $("#positionForm").serialize(),
				success: function(data){
					parent.layer.msg("保存成功！");
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
					parent.searchuser();
				}
			});
		}
		
		$(function(){
			layui.use(['form', 'layedit'], function() {
				var form = layui.form;
				//监听提交
				form.on('submit', function(data){
					savePosition();
				});
			})
		})
	</script>
</body>
</html>
