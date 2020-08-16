var table;
$(document).ready(function(){
	layui.use(['laydate', 'table', 'form', 'element'], function() {
		table = layui.table;
		loadCustomerList();
		
		// 监听单元格事件
		table.on('tool(chooseCustomer)', function(obj) {
			var data = obj.data;
			if (obj.event === 'choose') {
				parent.layer.msg("你选择了【"+data.customerName+"】");
				parent.setCustomer(data.id,data.customerName,data.customerMobile);
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		});
	})
});

// 加载客户列表
var loadCustomerList = function(){
	table.render({
		elem : '#customerTable',
		url : appName + '/choose/chooseCustomerList',
		height : parent.tableHeight(),
		limit:15,
		cellMinWidth: 100,
		page:true,
		limits:[15,50,100,500],
		cols : [ [ {
			field : 'no',
			title : '序号',
			fixed : 'left',
			event : 'choose',
			width : 60,
			templet:function(d){
				return d.LAY_INDEX;
			}
		}, {
			field : 'customerName',
			title : '客户名称',
			event : 'choose'
		}, {
			field : 'customerMobile',
			title : '客户号码',
			event : 'choose'
		},{
			field : 'customerSex',
			title : '客户性别',
			event : 'choose',
			templet: function(d){
				if(d.customerSex == '0'){
					return '男';
				}else if(d.customerSex == '1'){
					return '女';
				}else{
					return '未知';
				}
			}
		},{
			field : 'userName',
			title : '归属人',
			event : 'choose'
		} ] ]
	});
}

//查询
var searchCustomer = function(){
	var index = layer.msg("数据请求中！",{icon:16});
	var param = $("#quickForm").serializeJSON();
	layui.table.reload('customerTable', {
		url: appName + '/choose/chooseCustomerList',
		where: param,
		method:'post',
		done:function(){
			layer.close(index);
		}
	});
}

//清空查询
var clearSearchCustomer = function(){
	$("#quickForm")[0].reset();
	searchCustomer();
}