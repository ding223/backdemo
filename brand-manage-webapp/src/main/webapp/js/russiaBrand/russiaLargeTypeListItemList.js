var table,element;
$(document).ready(function(){
	layui.use(['laydate', 'table', 'form', 'element', 'upload'], function() {
		table = layui.table,element = layui.element, upload = layui.upload;
		loadFriendShipList();
		
		table.on('tool(RussiaLargeTypeItemTable)', function(obj){
		    var data = obj.data;
		    eval(obj.event+"("+data.id+")");
		});
		
		upload.render({
			elem : '#uploadExcel',
			url : appName+'/russiaLargeTypeItem/uploadExcel',
			accept : 'file',
			exts:'xls|xlsx',
			before:function(){
				layer.load(1,{title:'导入中，请稍等...',shade:0.5,shadeClose: false});
			},
			done : function(res) {
				layer.closeAll();
				loadFriendShipList();
				var failHtml = '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">';
				for(var i = 0; i < res.length; i ++){
					failHtml += res[i]+'</br>';
				}
				failHtml += '</div>';
				layer.open({
					type : 1,
					title : false,
					closeBtn : false,
					area : '550px;',
					shade : 0.6,
					id : 'notice',
					btnAlign : 'c',
					moveType : 1,
					content : failHtml,
					shadeClose: true
				});
			}
		});
	})
});

var importExcel = function(){
	$('#uploadExcel').click();
}

//加载子类项
var loadFriendShipList = function(){
	table.render({
		elem : '#RussiaLargeTypeItemTable',
		url : appName + '/russiaLargeTypeItem/russiaLargeTypeItemListData',
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
			field : 'title',
			title : '标题',
			width: 800
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
	param.title = $("#title").val();
	layui.table.reload('RussiaLargeTypeItemTable', {
		url: appName + '/russiaLargeTypeItem/russiaLargeTypeItemListData',
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
	var url = appName + "/russiaLargeTypeItem/addRussiaLargeTypeItemView";
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
			iframeWin.laySubmit('#russiaLargeTypeItemForm');
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
			url: "/russiaLargeTypeItem/delRussiaLargeTypeItem",
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