$(document).ready(function(){
	layui.use(['form'], function() { });
});

//新增分类
var addCustomerLabelCategory = function(id) {
	var url = appName + "/label/addCustomerLabelCategory";
	if(id) url+='?id='+id;
	var obj = {
		type : 2,
		title : '客户标签分类',
		id : 'addCustomerLabelCategory',
		skin : 'layui-layer-molv',
		closeBtn : 1,
		shade : 0.5,
		shadeClose : false,
		maxmin : true,
		area : [ '800px', '300px' ],
		content : url,
		btn : [ '保存', '关闭' ],
		yes : function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.laySubmit('#cateGoryForm');
		},
		btn2 : function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}

//删除客户标签分组
function delCustomerLabelCategory(that,id){
	  var delurl=appName+"/label/delCustomerLabelCategory?id="+id;
	  layer.confirm('你确认要删除该分类吗?', {icon: 3, title:'提示', skin: 'layui-layer-molv'}, function(index){
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

//重置客户标签分组顺序
function reSortableCustomerLabelCategory(ids){
	  var url=appName+"/label/reSortableCustomerLabelCategory?ids="+ids;
	  $.ajax({
	        dataType : "json",
	        type : "POST",
	        url : url, 
	        success : function(data) {
	        }  
	  });
}

//重置客户标签顺序
function reSortableCustomerLabel(ids)
{
	 var url=appName+"/label/reSortableCustomerLabel?ids="+ids;
	  $.ajax({
	        dataType : "json",
	        type : "POST",
	        url : url, 
	        success : function(data) {
	        }  
	  });
}

//删除客户标签
function delCustomerLabel(that,id){
	  var delurl = appName+"/label/delCustomerLabel?id="+id;
	  layer.confirm('你确认要删除该标签吗?', {icon: 3, title:'提示', skin: 'layui-layer-molv'}, function(index){
		  $.ajax({
		        dataType : "json",
		        type : "POST",
		        async: false,
		        url : delurl, 
		        success : function(data) {
		        	if(data>0){
		        		layer.closeAll();
		        		detableItemObj(that);//移除
		        	}
		        }  
		  });
		});
}

//新增客户标签
var addCustomerLabel = function(id,categoryId) {
	var url = appName + "/label/addCustomerLabel?labelCategoryId="+categoryId;
	if(id) url += '&id='+id;
	var obj = {
		type : 2,
		title : '新增客户标签',
		id : 'addCustomerLabel',
		skin : 'layui-layer-molv',
		closeBtn : 1,
		shade : 0.5,
		shadeClose : false,
		maxmin : true,
		area : [ '800px', '300px' ],
		content : url,
		btn : [ '保存', '关闭' ],
		yes : function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.laySubmit('#labelForm');
		},
		btn2 : function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}

//编辑客户标签
var editCustomerLabel = function(id) {
	var url = appName + "/label/addCustomerLabel?id="+id;
	var obj = {
		type : 2,
		title : '编辑客户标签',
		id : 'editCustomerLabel',
		skin : 'layui-layer-molv',
		closeBtn : 1,
		shade : 0.5,
		shadeClose : false,
		maxmin : true,
		area : [ '800px', '300px' ],
		content : url,
		btn : [ '保存', '关闭' ],
		yes : function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.laySubmit('#labelForm');
		},
		btn2 : function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}
