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
			type: 'radio'
		},{
			field : 'name',
			title : '员工名称',
			width: 150
		},{
			field : 'accountName',
			title : '登录账号',
			width: 150
		},{
			field : 'phone',
			title : '员工号码',
			width: 120
		},{
			field : 'departmentName',
			title : '所属部门',
			width: 200
		},{
			field : 'positionName',
			title : '担任职位',
			width: 200
		},{
			field : 'userStatus',
			title : '员工状态',
			width: 120,
			templet:function(d){
				return d.userStatus=='0'?'在职':'离职';
			}
		}] ]
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

//保存
var saveCustomerAscription = function(ids){
	var checkStatus = table.checkStatus('userTable');
	var data = checkStatus.data;
	if(data.length > 0){
		saas.ajax({
			type: "post",
			url: "/customer/saveCustomerAscription",
			data: {'ids': ids, 'userId': data[0].id, 'userName': data[0].name},
			success: function(data){
				if(data > 0){
					parent.layer.msg("操作成功！");
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
					parent.searchCustomer();
				}else{
					parent.layer.msg("操作失败！");
				}
			}
		});
	}else{
		layer.msg("请选择交接的用户！");
	}
}