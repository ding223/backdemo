var table;
var selectUserId;
var selectUser;
$(document).ready(function(){
	layui.use(['laydate', 'table','tree', 'form', 'element'], function() {
		table = layui.table;
		positionList();
	})
});
var positionList = function(){
	var url=appName + '/position/positionList';
	table.render({
		elem : '#positionTable',
		url : url,
		width : '100%',
		height : parent.tableHeight(),
		limit:15,
		page:true,
		limits:[15,50,100,500],
		cols : [ [  {
			field : 'no',
			title : '序号',
			width:60,
			templet:function(d){
				return d.LAY_INDEX;
			}
		},{
			field : 'name',
			width:300,
			title : '职位名称'
		},{
			field : 'dataPower',
			width:200,
			title : '数据权限',
			templet:function(d){
				if(d.dataPower=='0'){
					return '本人';
				}else if(d.dataPower=='1'){
					return '本部门';
				}else if(d.dataPower=='2'){
					return '本部门及子部门';
				}else if(d.dataPower=='3'){
					return '全公司';
				}
				return '';
			}
		},{
			field : 'remark',
			width:300,
			title : '备注'
		},{
			field : 'op',
			title : '操作',
			width:200,
			toolbar: '#toolbar'
		}] ]
	});
}
//删除客户
var delPosition = function(id){
	var url =  "/position/delPosition?id="+id;
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
//编辑职位
var editPosition = function(id) {
	var url = appName + "/position/editPosition";
	if(id){
		url+='?id='+id;
	}
	var obj = {
		type: 2,
		title: '编辑职位',
		id: 'editPosition',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '60%', '450px' ],
		content : url,
		btn: [ '保存', '关闭' ],
		yes: function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.laySubmit('#positionForm');
		},
		btn2: function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}

//设置权限
var setPower = function(id,name) {
	var url = appName + "/position/setPower";
	if(id){url+='?id='+id;}
	var obj = {
		type: 2,
		title: '设置权限【'+name+'】',
		id: 'editPosition',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '100%', '100%' ],
		content : url,
		btn: [ '保存', '关闭' ],
		yes: function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.savePermission();
		},
		btn2: function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
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
	var url=appName + '/position/positionList';
	layui.table.reload('positionTable', {
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