var table,url = appName + '/article/articleCategoryList';
$(document).ready(function(){
	layui.use(['laydate', 'table', 'form', 'element'], function() {
		table = layui.table,element = layui.element;
		loadArticleCategoryList();
	})
	
	//切换客户刷选模块
	$(".pageTool a").click(function(){
		var val = $(this).attr('val');
		$.each($(".pageTool a"),function(i,v){
			$(this).removeClass();
			$(this).addClass("button layui-btn layui-btn-primary");
		})
		$(this).removeClass();
		$(this).addClass("button layui-btn");
		if(val == "articleCategory"){
			$('.addArticleCategory').show();
			$('.addArticle').hide();
			url = appName + '/article/articleCategoryList';
			loadArticleCategoryList();
		}else{
			$('.addArticle').show();
			$('.addArticleCategory').hide();
			url = appName + '/article/articleList';
			loadArticleList();
		}
	})
});

//加载文章类别列表
var loadArticleCategoryList = function(){
	table.render({
		elem : '#articleTable',
		url : url,
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
			field : 'categoryName',
			title : '分类名称',
			width: 250
		},{
			field : 'categorySeq',
			title : '显示顺序',
			width: 100
		}, {
			field : 'remark',
			title : '备注',
			width: 400
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
			toolbar: '#articleCategoryToolbar'
		} ] ]
	});
}

//加载文章列表
var loadArticleList = function(){
	table.render({
		elem : '#articleTable',
		url : url,
		width : '100%',
		height : parent.tableHeight(),
		limit:15,
		page:true,
		limits:[15,50,100,500],
		cols : [ [{
			field : 'no',
			title : '序号',
			width:60,
			fixed : 'left',
			templet:function(d){
				return d.LAY_INDEX;
			}
		}, {
			field : 'title',
			title : '文章标题',
			fixed : 'left',
			width: 250
		},{
			field : 'cityName',
			title : '所属城市',
			fixed : 'left',
			width: 100
		},  {
			field : 'isShow',
			title : '是否显示',
			width: 120,
			templet: function(d){
				if(d.isShow == '0'){
					return '<font color="#009688">显示</font>';
				}else if(d.isShow == '1'){
					return '<font color="red">不显示</font>';
				}else{
					return '';
				}
			}
		},{
			field : 'visitNumber',
			title : '浏览次数',
			width: 100
		}, {
			field : 'author',
			title : '作者',
			width: 100
		}, {
			field : 'source',
			title : '来源',
			width: 100
		}, {
			field : 'keyword',
			title : '文章关键词',
			width: 200
		}, {
			field : 'depict',
			title : '文章描述',
			width: 200
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
			fixed : 'right',
			width: 200,
			toolbar: '#articleToolbar'
		} ] ]
	});
}

//查询
var searchArticle = function(){
	var index = layer.msg("数据请求中！",{icon:16});
	var param = $("#advancedSeachForm").serializeJSON();
	param.bannerName = $("#bannerName").val();
	layui.table.reload('articleTable', {
		url: url,
		where: param,
		method:'post',
		done:function(){
			layer.close(index);
		}
	});
}

//清空查询
var clearSearchArticle = function(){
	$("#advancedSeachForm")[0].reset();
	$("#quickForm")[0].reset();
	searchArticle();
}

//高级查询
var advancedSeach = function(){
	$("#advancedSeach").toggle();
}

//全部查询
var allJurisdiction = function(){
	$("#allJurisdiction").toggle();
}

//新增文章分类
var addArticleCategory = function(id) {
	var url = appName + "/article/addArticleCategory";
	if(saas.isNotNull(id)) url += "?id="+id;
	var obj = {
		type: 2,
		title: '新增文章分类',
		id: 'addArticleCategory',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '70%', '500px' ],
		content : url,
		btn: [ '保存', '关闭' ],
		yes: function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.laySubmit('#articleCategoryForm');
		},
		btn2: function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}

//删除文章分类
var delArticleCategory = function(id){
	layer.confirm('你确定要删除文章分类吗?', {icon: 3, title:'提示', skin: 'layui-layer-molv'}, function(index){
       	saas.ajax({
			type: "post",
			url: "/article/delArticleCategory",
			data: {'id': id},
			success: function(data){
				if(data > 0){
					layer.msg("删除成功！");
					searchArticle();
				}else{
					layer.msg("删除失败！");
				}
			}
		});
	});
}

//文章分类排序
var articleCategorySort = function() {
	var obj = {
		type: 2,
		title: '文章分类排序',
		id: 'articleCategorySort',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '800px', '100%' ],
		content : appName + "/article/articleCategorySort"
	};
	layer.open(obj);
}

//新增文章
var addArticle = function(id) {
	var url = appName + "/article/addArticle";
	if(saas.isNotNull(id)) url += "?id="+id;
	var obj = {
		type: 2,
		title: '新增文章',
		id: 'addArticle',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '100%', '100%' ],
		content : url,
		btn: [ '保存', '关闭' ],
		yes: function(index, layero) {
			var iframeWin = window[layero.find('iframe')[0]['name']];
			iframeWin.laySubmit('#articleForm');
		},
		btn2: function(index, layero) {
			layer.close(index);
		}
	};
	layer.open(obj);
}

//删除文章
var delArticle = function(id){
	layer.confirm('你确定要删除文章吗?', {icon: 3, title:'提示', skin: 'layui-layer-molv'}, function(index){
       	saas.ajax({
			type: "post",
			url: "/article/delArticle",
			data: {'id': id},
			success: function(data){
				if(data > 0){
					layer.msg("删除成功！");
					searchArticle();
				}else{
					layer.msg("删除失败！");
				}
			}
		});
	});
}

//预览文章
var preArticle = function(id) {
	var obj = {
		type: 2,
		title: '预览文章',
		id: 'preArticle',
		skin: 'layui-layer-molv',
		closeBtn: 1,
		move: false,
		area: [ '100%', '100%' ],
		content : appName + "/article/preArticle?id="+id,
		success: function(layero, index){
			searchArticle();
		}
	};
	layer.open(obj);
}