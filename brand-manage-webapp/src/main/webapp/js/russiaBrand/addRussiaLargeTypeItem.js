var ue;
$(document).ready(function(){
	layui.use(['form'], function() {
		var form = layui.form;
		form.render();
		
		//监听提交
		form.on('submit', function(data){
			saveRussiaLargeTypeItem();
		});
	})
	
	//初始化富文本
	ue = initUeditor();
	ue.ready(function() {
		ue.setContent(content);
	});
});

//保存文章
var saveRussiaLargeTypeItem = function() {
	var russia = $("#russiaLargeTypeItemForm").formJson();
	
    if(!ue.hasContents()){
    	layer.msg('请填写内容', {icon: 5,anim: 6});
    	ue.focus();
    	return false;
    }
    
    russia.content = ue.getContent();
    delete russia.editorValue;
    console.log(JSON.stringify(russia));
	saas.ajax({
		dataType : "json",
		type : "post",
		async : false,
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(russia),
		url: "/russiaLargeTypeItem/saveRussiaLargeTypeItem",
		success : function(data) {
			parent.layer.msg("保存成功！");
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
			parent.searchFriendShip();
		}
	});
}
