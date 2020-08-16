var table,element;
$(document).ready(function(){
	layui.use(['laydate', 'table', 'form', 'element', 'upload'], function() {
		table = layui.table,element = layui.element,upload = layui.upload;
		loadFriendShipList();
		
		table.on('tool(BrandSmallTypeItemTable)', function(obj){
		    var data = obj.data;
		    eval(obj.event+"("+data.id+")");
		});
		
		upload.render({
			elem : '#uploadExcel',
			url : appName+'/brandGnSmalltypeItem/uploadExcel',
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

var importGnSmallTypeItem = function(){
	$('#uploadExcel').click();
}

//加载子类项
var loadFriendShipList = function(){
	table.render({
		elem : '#BrandSmallTypeItemTable',
		url : appName + '/brandGnSmalltypeItem/gnSmallTypeItemListData',
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
			}
		}, {
			field : 'groupNo',
			title : '组别',
			width: 150
		}, {
			field : 'projectNo',
			title : '项目编号',
			width: 150
		}, {
			field : 'projectCnname',
			title : '项目名称（中文）',
			width: 300
		}, {
			field : 'projectEnname',
			title : '项目名称（英文）',
			width: 300
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
			toolbar: '#toolbar'
		} ] ]
	});
}

//查询
var searchFriendShip = function(){
	var index = layer.msg("数据请求中！",{icon:16});
	var param = $("#advancedSeachForm").serializeJSON();
	param.projectCnname = $("#projectCnname").val();
	layui.table.reload('BrandSmallTypeItemTable', {
		url: appName + '/brandGnSmalltypeItem/gnSmallTypeItemListData',
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
	var url = appName + "/brandGnSmalltypeItem/addGnSmallTypeItemView";
	if(saas.isNotNull(id)) url += "?id="+id;
	var obj = {
		type: 2,
		title: '新增子类',
		id: 'addFriendShip',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '100%', '100%' ],
		content : url,
		btn: [ '保存', '关闭' ],
		yes: function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.laySubmit('#smallTypeItemForm');
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
			url: "/brandGnSmalltypeItem/delGnSmallTypeItem",
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