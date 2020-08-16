var ue;
$(document).ready(function(){
	layui.use(['form'], function() {
		var form = layui.form;
		form.render();
		
		//监听提交
		form.on('submit', function(data){
			savArticleCategory();
		});
	})
});

//保存文章分类
var savArticleCategory = function() {
	saas.ajax({
		type : "post",
		url : "/article/saveArticleCategory",
		data : $("#articleCategoryForm").serialize(),
		success : function(data) {
			parent.layer.msg("保存成功！");
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
			parent.searchArticle();
		}
	});
}
