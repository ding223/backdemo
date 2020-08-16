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
<title>我的信息</title>
<style type="text/css">
	#userForm .layui-form-checkbox {
		width: 180px;
		padding-bottom: 2px;
		padding-top: 2px;
	}
	
	#userForm .layui-form-checkbox span {
		width: 120px;
	}
	
	.downpanel .layui-select-title span {
		line-height: 38px;
	}
	
	.downpanel dl dd:hover {
		background-color: inherit;
	}
	
	.layui-form-checkbox span {
		height: 30px;
	}
	
	.layui-field-title {
		border-top: 1px solid white;
	}
</style>
</head>
<body >
	<form class="layui-form editform" id="userForm" style="margin: 20px;margin-top: 0px;">
	    <input value="${sysUser.id}" name="id" type="hidden" />
		<div class="layui-row">
			<div class="layui-col-xs6">
				<label class="layui-form-label">登录账号</label>
				<div class="layui-input-block">
					<input type="text" name="accountName" value="${sysUser.accountName}" 
					lay-verify="required" class="layui-input" placeholder="请填写登录账号" style="float: left;">
					<a class="layui-btn" style="margin-top: -38px;float: right;" onclick="savePassWord(${sysUser.id});">修改密码</a>
				</div>
			</div>
			<div class="layui-col-xs6">
				<label class="layui-form-label">所属部门</label>
		        <div class="layui-input-block">
		            <div class="layui-unselect layui-form-select downpanel">
		                <select disabled="disabled">
							<option selected value="${department.id }">${department.name}</option>
		                </select>
		            </div>
		        </div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-xs6">
				<label class="layui-form-label">员工名称</label>
				<div class="layui-input-block">
					<input type="text" value="${sysUser.name}" lay-verify="required" class="layui-input" placeholder="请填写员工名称" disabled="disabled">
				</div>
			</div>
			<div class="layui-col-xs6">
				<label class="layui-form-label">联系方式</label>
				<div class="layui-input-block">
					<input type="text" name="phone" value="${sysUser.phone}" lay-verify="required|gqgx_phone"  class="layui-input" placeholder="请填写联系方式">
				</div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-xs6">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-block">
			      <input type="radio" name="sex" value="0" title="男" ${sysUser.sex eq '0'?'checked':'' } >
			      <input type="radio" name="sex" value="1" title="女" ${sysUser.sex eq '1'?'checked':'' } >
			    </div>
			</div>
			<div class="layui-col-xs6">
				<label class="layui-form-label">员工状态</label>
				<div class="layui-input-block">
					<c:if test="${sysUser.userStatus eq '0'}">
						<input type="radio" value="0" title="在职" checked/>
						<input type="radio" value="0" title="离职" disabled="disabled"/>
					</c:if>
					<c:if test="${sysUser.userStatus eq '1'}">
						<input type="radio" value="0" title="在职" disabled="disabled"/>
						<input type="radio" value="1" title="离职" checked/>
					</c:if>
				</div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-xs12">
				<label class="layui-form-label">担任职位</label>
				<div class="layui-input-block"  >
			       <c:forEach items="${positions}" var="position" varStatus="i">
			       		<c:if test="${not empty sysUser.id and not empty position.supId }">
			       			<a class="layui-btn layui-btn-primary layui-btn-radius layui-btn-sm">${position.name }</a>
			       		</c:if>
					</c:forEach>
			    </div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-xs12">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容"  class="layui-textarea" name="remark">${sysUser.remark}</textarea>
				</div>
			</div>
		</div>
		<center>
			<a class="layui-btn" lay-submit id="lay-submit"><i class="layui-icon">&#x1005;</i> 保存</a>
		</center>
	</form>
	<script type="text/javascript">
		$(function() {
		    layui.use(['element', 'tree', 'layer', 'form', 'upload'], function () {
		        var $ = layui.jquery, tree = layui.tree , form = layui.form;		        
		
		      	//监听提交
				form.on('submit', function(data){
					saveUser();
				});
		    });
		});
		
		//保存员工
		var saveUser = function(){
			saas.ajax({
				type: "post",
				url: "/user/saveUser",
				async:false,
				data: $("#userForm").serialize(),
				success: function(data){
					parent.layer.msg("保存成功！");
				}
			});
		}
		
		//修改密码
		var savePassWord = function(id) {
			var url = appName + "/user/settingPassWord?userId="+id;
			var obj = {
				type: 2,
				title: '修改密码',
				id: 'savePassWord',
				skin: 'layui-layer-molv',
				closeBtn: 1,
				move: false,
				area: [ '800px', '50%' ],
				content : url,
				btn: [ '保存', '关闭' ],
				yes: function(index, layero) {
					var iframeWin = window[layero.find('iframe')[0]['name']];
					iframeWin.laySubmit('#userForm');
				},
				btn2: function(index, layero) {
					layer.close(index);
				}
			};
			layer.open(obj);
		}
	</script>
</body>
</html>
