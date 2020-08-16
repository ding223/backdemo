$(document).ready(function(){
	layui.use(['form'], function() { });
});

//新增分类
var addParmenu = function(id) {
	var url = appName + "/menu/addParmenu";
	if(id){
		url+='?id='+id;
	}
	var obj = {
		type : 2,
		title : '新增一级菜单',
		id : 'addCustomer',
		skin : 'layui-layer-molv',
		closeBtn : 1,
		shade : 0.5,
		shadeClose : false,
		maxmin : true,
		area : [ '800px', '400px' ],
		content : url,
		btn : [ '保存', '关闭' ],
		yes : function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.laySubmit('#menuForm');
		},
		btn2 : function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}
function delSortable(that,id){
	  var delurl=appName+"/menu/delSysMenu?id="+id;
	  layer.confirm('你确认要删除吗?', {icon: 3, title:'提示', skin: 'layui-layer-molv'}, function(index){
		  $.ajax({
		        dataType : "json",
		        type : "POST",
		        async: false,
		        url : delurl, 
		        success : function(data) {
		        	if(data>0){
		        		layer.closeAll();
		        		detableObj(that);//移除外层
		        	}
		        }  
		  });
		});
}
function delSortableItem(that,id){
	  var delurl=appName+"/menu/delSysMenu?id="+id;
	  layer.confirm('你确认要删除吗?', {icon: 3, title:'提示', skin: 'layui-layer-molv'}, function(index){
		  $.ajax({
		        dataType : "json",
		        type : "POST",
		        async: false,
		        url : delurl, 
		        success : function(data) {
		        	if(data>0){
		        		layer.closeAll();
		        		detableItemObj(that);//移除外层
		        	}
		        }  
		  });
		});
}



function reSortable(ids){
	  var url=appName+"/menu/reSortable?ids="+ids;
	  $.ajax({
	        dataType : "json",
	        type : "POST",
	        url : url, 
	        success : function(data) {
	        }  
	  });
}

function reSortableItem(ids)
{
	 var url=appName+"/menu/reSortable?ids="+ids;
	  $.ajax({
	        dataType : "json",
	        type : "POST",
	        url : url, 
	        success : function(data) {
	        }  
	  });
}
//新增分类项
var addChildSysmenu = function(id,parentId) {
	var url = appName + "/menu/addChildmenu?parentId="+parentId;
	if(id){
		url+='&id='+id;
	}
	var obj = {
		type : 2,
		title : '新增二级菜单',
		id : 'addGoods',
		skin : 'layui-layer-molv',
		closeBtn : 1,
		shade : 0.5,
		shadeClose : false,
		maxmin : true,
		area : [ '800px', '100%' ],
		content : url,
		btn : [ '保存', '关闭' ],
		yes : function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.laySubmit('#menuForm');
		},
		btn2 : function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}

//编辑分类项
var editChildSysmenu = function(id) {
	var url = appName + "/menu/addChildmenu?id="+id;
	var obj = {
		type : 2,
		title : '编辑商品',
		id : 'editGoods',
		skin : 'layui-layer-molv',
		closeBtn : 1,
		shade : 0.5,
		shadeClose : false,
		maxmin : true,
		area : [ '100%', '100%' ],
		content : url,
		btn : [ '保存', '关闭' ],
		yes : function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
	    	iframeWin.saveParmenu();
		},
		btn2 : function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}
