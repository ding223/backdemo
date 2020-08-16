var table,element;
$(document).ready(function(){
	layui.use(['laydate', 'table', 'form', 'element'], function() {
		table = layui.table,element = layui.element,form = layui.form;
		loadFriendShipList();
		
		table.on('tool(NavItemTable)', function(obj){
		    var data = obj.data;
		    eval(obj.event+"("+data.id+")");
		});
		
		//修改顺序
		table.on('edit(NavItemTable)', function(obj) {
			var value = obj.value;
			var data = obj.data;
			saas.ajax({
				type: "post",
				url: "/navItem/saveNavItem",
				data: {'id': data.id,'seq': value},
				success: function(data){
					
				}
			});
		});
		
		//监听锁定操作
		form.on('checkbox(lockDemo)', function(obj){
			var value = obj.value;
			saas.ajax({
				type: "post",
				url: "/navItem/saveNavItem",
				data: {'id': value,'showStatus': (obj.elem.checked==true?'0':'1')},
				success: function(data){
					
				}
			});
		});
	})
});

//加载子类项
var loadFriendShipList = function(){
	table.render({
		elem : '#NavItemTable',
		url : appName + '/navItem/navItemListData',
		width : '100%',
		height : parent.tableHeight(),
		limit:15,
		page:true,
		limits:[15,50,100,500],
		cols : [ [{
			field : 'no',
			title : '序号',
			width:60,
			templet:function(d){
				return d.LAY_INDEX;
			},
			fixed: 'left'
		}, {
			field : 'seq',
			title : '顺序号',
			edit:'text',
			width: 150,
			fixed: 'left'
		}, {
			field : 'name',
			title : '导航名称',
			width: 300
		}, {
			field : 'cityName',
			title : '区域',
			width: 200
		},{
			field : 'showStatus',
			title : '是否显示',
			width: 200,
			templet: '#checkboxTpl', 
			unresize: true
		},{
			field : 'createDate',
			title : '添加时间',
			width: 200,
			templet: function(d){
				return formatDateTime(d.createDate);
			}
		},{
			field : 'op',
			title : '操作',
			width: 200,
			toolbar: '#toolbar',
			fixed: 'right'
		} ] ]
	});
}

//查询
var searchFriendShip = function(){
	var index = layer.msg("数据请求中！",{icon:16});
	var param = $("#advancedSeachForm").serializeJSON();
	param.name = $("#name").val();
	layui.table.reload('NavItemTable', {
		url: appName + '/navItem/navItemListData',
		where: param,
		method:'post',
		done:function(){
			layer.close(index);
		}
	});
}

//清空查询
var clearSearchFriendShip = function(){
	$("#advancedSeachForm")[0].reset();
	$("#quickForm")[0].reset();
	searchFriendShip();
}

//高级查询
var advancedSeach = function(){
	$("#advancedSeach").toggle();
}

//全部查询
var allJurisdiction = function(){
	$("#allJurisdiction").toggle();
}

//新增分类
var addFriendShip = function(id) {
	var url = appName + "/navItem/addNavItemView";
	if(saas.isNotNull(id)) url += "?id="+id;
	var obj = {
		type: 2,
		title: '新增项目',
		id: 'addFriendShip',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '100%', '100%' ],
		content : url,
		btn: [ '保存', '关闭' ],
		yes: function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.laySubmit('#navItemForm');
		},
		btn2: function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}

//删除分类
var delFriendShip = function(id){
	layer.confirm('你确定要删除吗?', {icon: 3, title:'提示', skin: 'layui-layer-molv'}, function(index){
       	saas.ajax({
			type: "post",
			url: "/navItem/delNavItem",
			data: {'id': id},
			success: function(data){
				if(data > 0){
					layer.msg("删除成功！");
					searchFriendShip();
				}else{
					layer.msg("删除失败！");
				}
			}
		});
	});
}