var table;
$(document).ready(function(){
	layui.use(['laydate', 'table', 'form', 'element'], function() {
		table = layui.table;
		loadGoodsList();
	})
});

//交接记录
var loadGoodsList = function(){
	table.render({
		elem : '#handerTable',
		url : appName + '/log/handerList',
		width : '100%',
		height : parent.tableHeight(),
		limit:10,
		page:true,
		limits:[10,50,100,500],
		cols : [ [  {
			field : 'no',
			title : '序号',
			width:60,
			fixed : 'left',
			templet:function(d){
				return d.LAY_INDEX;
			}
		},{
			field : 'enterpriseName',
			title : '企业名',
			fixed : 'left',
			width: 300
		},{
			field : 'goodsName',
			title : '服务名称',
			width: 200
		},{
			field : 'oriUserName',
			title : '交接人',
			width: 100
		},{
			field : 'receiveUserName',
			title : '接收人',
			width: 100
		},{
			field : 'handoverRemark',
			title : '交接内容',
			width: 400
		},{
			field : 'createDate',
			title : '交接时间',
			width: 200,
			templet: function(d){
				return formatDateTime(d.createDate);
			}
		}  ] ]
	});
}

//查询
var searchGoods= function(releaseStatus){
	var index = layer.msg("数据请求中！",{icon:16});
	var param = $("#advancedSeachForm").serializeJSON();
	if(releaseStatus){
		param.releaseStatus =releaseStatus;
	}else{
		param.releaseStatus =null;
	}
	param.enterpriseName = $("#enterpriseName").val();
	layui.table.reload('handerTable', {
		url: appName + '/log/handerList',
		where: param,
		method:'post',
		done:function(){
			$("#advancedSeach").hide();
			layer.close(index);
		}
	});
}

//清空查询
var clearSearchCustomer = function(){
	$("#advancedSeachForm")[0].reset();
	$("#quickForm")[0].reset();
	searchGoods();
}

//高级查询
var advancedSeach = function(){
	$("#advancedSeach").toggle();
}

//全部查询
var allJurisdiction = function(){
	$("#allJurisdiction").toggle();
}
