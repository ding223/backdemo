var ue;
$(document).ready(function(){
	layui.use(['form', 'upload'], function() {
		var form = layui.form,upload = layui.upload;
		form.render();
		
		//监听提交
		form.on('submit', function(data){
			if (!data.field.isShow){
	            layer.msg('请选择文章是否需显示！',{icon:5,anim:6});
	            return false;
	        }
			saveArticle();
		});
		
		upload.render({
			elem : '#imgUrl',
			url : appName + "/file/upload",
			done : function(res) {
				var html = '';
				html += '<img width="250px" height="160px" src="'+res.fileUrl+'" />';
				$("#imgUrl").html(html);
				$("#imgUrlVal").val(res.fileUrl);
			}
		});
	})
	
	//初始化富文本
	ue = initUeditor();
	ue.ready(function() {
		ue.setContent(content);
	});
});

//保存文章
var saveArticle = function() {
	var article = $("#articleForm").formJson();
	
    if(!ue.hasContents()){
    	layer.msg('请填写文章内容', {icon: 5,anim: 6});
    	ue.focus();
    	return false;
    }
    
    article.content = ue.getContent();
    delete article.editorValue;
	saas.ajax({
		dataType : "json",
		type : "post",
		async : false,
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(article),
		url: "/article/saveArticle",
		success : function(data) {
			parent.layer.msg("保存成功！");
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
			parent.searchArticle();
		}
	});
}
