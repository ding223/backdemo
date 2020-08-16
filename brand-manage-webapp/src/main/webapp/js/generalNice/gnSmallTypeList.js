var table, element;
$(document).ready(function() {
	layui.use([ 'laydate', 'table', 'form', 'element'], function() {
		table = layui.table, element = layui.element;
		loadFriendShipList();

		table.on('tool(BrandSmallTypeTable)', function(obj) {
			var data = obj.data;
			eval(obj.event + "(" + data.id + ")");
		});
	})
});

// 加载分类
var loadFriendShipList = function() {
	table.render({
		elem : '#BrandSmallTypeTable',
		url : appName + '/brandSmallType/gnSmallTypeListData',
		width : '100%',
		height : parent.tableHeight(),
		limit : 15,
		page : true,
		limits : [ 15, 50, 100, 500 ],
		cols : [ [ {
			field : 'num',
			title : '序号',
			width : 60,
			templet : function(d) {
				return d.LAY_INDEX;
			}
		}, {
			field : 'no',
			title : '子类编号',
			width : 200
		}, {
			field : 'name',
			title : '子类名称',
			width : 600
		}, {
			field : 'createDate',
			title : '添加时间',
			width : 200,
			templet : function(d) {
				return formatDateTime(d.createDate);
			}
		}, {
			field : 'op',
			title : '操作',
			width : 200,
			toolbar : '#toolbar'
		} ] ]
	});
}

// 查询
var searchFriendShip = function() {
	var index = layer.msg("数据请求中！", {
		icon : 16
	});
	var param = $("#advancedSeachForm").serializeJSON();
	param.name = $("#name").val();
	layui.table.reload('BrandSmallTypeTable', {
		url : appName + '/brandSmallType/gnSmallTypeListData',
		where : param,
		method : 'post',
		done : function() {
			layer.close(index);
		}
	});
}

// 清空查询
var clearSearchFriendShip = function() {
	$("#advancedSeachForm")[0].reset();
	$("#quickForm")[0].reset();
	searchFriendShip();
}

// 高级查询
var advancedSeach = function() {
	$("#advancedSeach").toggle();
}

// 全部查询
var allJurisdiction = function() {
	$("#allJurisdiction").toggle();
}

// 新增分类
var addFriendShip = function(id) {
	var url = appName + "/brandSmallType/addGnSmallTypeView";
	if (saas.isNotNull(id))
		url += "?id=" + id;
	var obj = {
		type : 2,
		title : '新增子类',
		id : 'addFriendShip',
		skin : 'layui-layer-molv',
		closeBtn : 1,
		move : false,
		area : [ '100%', '100%' ],
		content : url,
		btn : [ '保存', '关闭' ],
		yes : function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.laySubmit('#smallTypeForm');
		},
		btn2 : function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}

// 删除分类
var delFriendShip = function(id) {
	layer.confirm('你确定要删除吗?', {
		icon : 3,
		title : '提示',
		skin : 'layui-layer-molv'
	}, function(index) {
		saas.ajax({
			type : "post",
			url : "/brandSmallType/delGnSmallType",
			data : {
				'id' : id
			},
			success : function(data) {
				if (data > 0) {
					layer.msg("删除成功！");
					searchFriendShip();
				} else {
					layer.msg("删除失败！");
				}
			}
		});
	});
}