var table,element;
$(document).ready(function(){
	layui.use(['laydate', 'table', 'form', 'element'], function() {
		table = layui.table,element = layui.element;
		layui.laydate.render({
			elem : '#startTime'
		});
		
		layui.laydate.render({
			elem : '#endTime'
		});
		loadSysLogList();
	})
});

//加载日志
var loadSysLogList = function(){
	table.render({
		elem : '#logTable',
		url : appName + '/log/sysLogList',
		width : '100%',
		height : parent.tableHeight(),
		limit:15,
		page:true,
		limits:[15,50,100,500],
		cols : [ [ {
			field : 'no',
			title : '序号',
			width:60,
			fixed : 'left',
			templet:function(d){
				return d.LAY_INDEX;
			}
		}, {
			field : 'userName',
			title : '用户名称',
			fixed : 'left',
			width: 120
		},{
			field : 'departmentName',
			title : '所属部门',
			width: 150
		},{
			field : 'operationDesc',
			title : '请求参数',
			width: 300
		},{
			field : 'operationUrl',
			title : '操作URL',
			width: 200
		},{
			field : 'ipAddress',
			title : 'IP地址',
			width: 130
		},{
			field : 'browerType',
			title : '浏览器',
			width: 100
		},{
			field : 'termianlType',
			title : '操作系统',
			width: 100,
			templet:function(d){
				if(d.termianlType == '1'){
            		return 'Windows';
            	}else if(d.termianlType == '2'){
            		return 'IOS';
            	}else if(d.termianlType == '3'){
            		return 'Android';
            	}else{
            		return "未知";
            	}
			}
		},{
			field : 'operationDate',
			title : '操作时间',
			width: 200,
			templet: function(d){
				return formatDateTime(d.operationDate);
			}
		}] ]
	});
}

//查询
var searchSysLog = function(){
	var index = layer.msg("数据请求中！",{icon:16});
	var param = $("#advancedSeachForm").serializeJSON();
	param.userName = $("#userName").val();
	layui.table.reload('logTable', {
		url: appName + '/log/sysLogList',
		where: param,
		method:'post',
		done:function(){
			layer.close(index);
		}
	});
}

//清空查询
var clearSearchSysLog = function(){
	$("#advancedSeachForm")[0].reset();
	$("#quickForm")[0].reset();
	searchSysLog();
}

//高级查询
var advancedSeach = function(){
	$("#advancedSeach").toggle();
}

//全部查询
var allJurisdiction = function(){
	$("#allJurisdiction").toggle();
}