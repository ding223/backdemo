var table,element;
$(document).ready(function(){
	layui.use(['laydate', 'table', 'form', 'element'], function() {
		table = layui.table,element = layui.element;
		loadSiteList();
	})
});

//加载站点列表
var loadSiteList = function(){
	table.render({
		elem : '#siteTable',
		url : appName + '/area/siteList',
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
			field : 'siteName',
			title : '站点名称',
			width: 250
		}, {
			field : 'cityName',
			title : '城市名称',
			width: 250
		},{
			field : 'siteSeq',
			title : '显示顺序',
			width: 100
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
			toolbar: '#toolbar',
			width:200
		} ] ]
	});
}

//查询
var searchSite = function(){
	var index = layer.msg("数据请求中！",{icon:16});
	var param = $("#advancedSeachForm").serializeJSON();
	param.siteName = $("#siteName").val();
	layui.table.reload('siteTable', {
		url: appName + '/area/siteList',
		where: param,
		method:'post',
		done:function(){
			layer.close(index);
		}
	});
}

//清空查询
var clearSearchSite = function(){
	$("#advancedSeachForm")[0].reset();
	$("#quickForm")[0].reset();
	searchSite();
}

//高级查询
var advancedSeach = function(){
	$("#advancedSeach").toggle();
}

//全部查询
var allJurisdiction = function(){
	$("#allJurisdiction").toggle();
}

//新增站点
var addSite = function(id) {
	var url = appName + "/area/addSite";
	if(saas.isNotNull(id)) url += "?id="+id;
	var obj = {
		type: 2,
		title: '新增站点',
		id: 'addSite',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '60%', '100%' ],
		content : url,
		btn: [ '保存', '关闭' ],
		yes: function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.laySubmit('#siteForm');
		},
		btn2: function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}

//删除站点
var delSite = function(id){
	layer.confirm('你确定要删除站点吗?', {icon: 3, title:'提示', skin: 'layui-layer-molv'}, function(index){
       	saas.ajax({
			type: "post",
			url: "/area/delSite",
			data: {'id': id},
			success: function(data){
				if(data > 0){
					layer.msg("删除成功！");
					searchSite();
				}else{
					layer.msg("删除失败！");
				}
			}
		});
	});
}

//站点排序
var siteSort = function() {
	var obj = {
		type: 2,
		title: '站点排序',
		id: 'siteSort',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '800px', '100%' ],
		content : appName + "/area/siteSort"
	};
	layer.open(obj);
}