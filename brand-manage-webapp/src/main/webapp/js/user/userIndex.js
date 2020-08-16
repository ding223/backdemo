var table;
var selectUserId;
var selectUser;
$(document).ready(function(){
	layui.use(['laydate', 'table','tree', 'form', 'element'], function() {
		table = layui.table;
		
		$('#department').height($(window).height()-72);
		layui.tree({
			elem : '#department' // 指定元素
			,target : '_blank' // 是否新选项卡打开（比如节点返回href才有效）
			,click : function(item) { // 点击节点回调
				$("#departmentId").val(item.id);
				$("#selectParment").html(createParment(item));
				searList();
			},
			nodes : loadDepartmentTree()
		});
		loaduserList();
		// 监听单元格事件
		table.on('tool(userTable)', function(obj){
		    var data = obj.data;
			if (obj.event === 'choose') {
				selectUserId=data.id;
				selectUser=data;
			}
		});
	})
	$(".pageTool a").click(function(){
		$.each($(".pageTool a"),function(i,v){
			$(this).removeClass();
			$(this).addClass("button layui-btn layui-btn-primary");
		})
		$(this).removeClass();
		$(this).addClass("button layui-btn");
	})
	
	$('.layui-table-fixed-r').click(function(){
		$(this).hide();
	})
});
//选择部门
function createParment(item){
	var html='';
	html+='<a style="margin-top:5px;" href="javascript:void(0);" class="layui-btn layui-btn-primary layui-btn-sm">';
	html+='  <span departmentId="'+item.id+'" class="departmentName">'+item.name+'</span>';
	html+='  <i title="移除" onclick="removeDepartment(this);" class="layui-icon">&#x1006;</i>';
	html+='</a>';
	return html;
}
//清理部门
function removeDepartment(that){
	$(that).parents("a").remove();
	$("#departmentId").val("");
	searList();
}

//新增部门
var addDepartment = function() {
	var url = appName + "/department/addDepartment";
	var obj = {
		type: 2,
		title: '新增部门',
		id: 'addDepartment',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '100%', '100%' ],
		content : url,
		btn: [ '保存', '关闭' ],
		yes: function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.saveDepartment();
		},
		btn2: function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}
//编辑部门
var editDepartment = function() {
	var id=$(".departmentName").attr("departmentId");
	if(!id){
		layer.msg("请选择你要编辑的部门");
		return false;
	}
	var url = appName + "/department/addDepartment?id="+id;
	var obj = {
		type: 2,
		title: '编辑部门',
		id: 'editDepartment',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '100%', '100%' ],
		content : url,
		btn: [ '保存', '关闭' ],
		yes: function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.saveDepartment();
		},
		btn2: function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}
//删除客户
var delDepartment = function(id){
	var id=$(".departmentName").attr("departmentId");
	if(!id){
		layer.msg("请选择你要删除的部门");
		return false;
	}
	var url =  "/department/delDepartment?id="+id;
	layer.confirm('你确定要删除吗?', {icon: 3, title:'提示', skin: 'layui-layer-molv'}, function(index){
       	saas.ajax({
			type: "post",
			url: url,
			data: {'id': id},
			success: function(data){
				if(data > 0){
					layer.msg("删除成功！");
					window.location.reload();
				}else{
					layer.msg("删除失败！");
				}
			}
		});
	});
}
function loadDepartmentTree(){
	var dataList;
	var url=appName+"/department/departmentList";
	 $.ajax({
	        dataType : "json",
	        type : "POST",
	        async: false,
	        url : url, 
	        success : function(data) {
	        	dataList=data;
	        }  
	  });
	 return dataList;
}

var loaduserList = function(){
	var url=appName + '/user/userList';
	var departmentId=$("#departmentId").val();
	if(departmentId){
		url+="?departmentId="+departmentId;
	}
	table.render({
		elem : '#userTable',
		url : url,
		width : '100%',
		height : $(window).height()-100,
		limit:15,
		page:true,
		limits:[15,50,100,500],
		cols : [ [  {
			field : 'no',
			title : '序号',
			width:60,
			fixed : 'left',
			templet:function(d){
				return d.LAY_INDEX;
			}
		},{
			field : 'name',
			title : '员工名称',
			event : 'choose',
			fixed : 'left',
			width: 150
		},{
			field : 'accountName',
			title : '登录账号',
			event : 'choose',
			width: 150
		},{
			field : 'phone',
			title : '员工号码',
			event : 'choose',
			width: 120
		},{
			field : 'departmentName',
			title : '所属部门',
			event : 'choose',
			width: 200
		},{
			field : 'positionName',
			title : '担任职位',
			event : 'choose',
			width: 200
		},{
			field : 'userStatus',
			title : '员工状态',
			event : 'choose',
			width: 120,
			templet:function(d){
				return d.userStatus=='0'?'在职':'离职';
			}
		} ,{
			field : 'op',
			title : '操作',
			fixed : 'right',
			width:200,
			toolbar: '#toolbar'
		}] ]
	});
}
//编辑用户
var editUser = function(id) {
	var url = appName + "/user/addUser";
	if(id){
		url+='?id='+id;
	}
	var obj = {
		type: 2,
		title: '编辑用户',
		id: 'editUser',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '100%', '100%' ],
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

//设置密码
var setPassword = function(id) {
	var url = appName + "/user/setPassword?id="+id;
	var obj = {
		type: 2,
		title: '设置密码',
		id: 'setPassword',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '50%', '50%' ],
		content : url,
		btn: [ '保存', '关闭' ],
		yes: function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			var count=iframeWin.savePassword();
			if(count>0){
				searList();
				layer.close(index);
			}
		},
		btn2: function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}
//删除客户
var delUser = function(id){
	var url =  "/user/delUser?id="+id;
	layer.confirm('你确定要删除吗?', {icon: 3, title:'提示', skin: 'layui-layer-molv'}, function(index){
       	saas.ajax({
			type: "post",
			url: url,
			data: {'id': id},
			success: function(data){
				if(data > 0){
					layer.msg("删除成功！");
					searList();
				}else{
					layer.msg("删除失败！");
				}
			}
		});
	});
}
//查询
var searchuser= function(serviceStatus){
	curserviceStatus=serviceStatus;
	searList();
}

var searList=function(){
	var index = layer.msg("数据请求中！",{icon:16});
	var param = $("#advancedSeachForm").serializeJSON();
	param.name = $("#searName").val();
	var url=appName + '/user/userList';
	layui.table.reload('userTable', {
		url: url,
		where: param,
		method:'post',
		done:function(){
			$("#advancedSeach").hide();
			layer.close(index);
		}
	});
}

//清空查询
var clearSearch = function(){
	$("#advancedSeachForm")[0].reset();
	$("#quickForm")[0].reset();
	searList();
}

//高级查询
var advancedSeach = function(){
	$("#advancedSeach").toggle();
}

//全部查询
var allJurisdiction = function(){
	$("#allJurisdiction").toggle();
}