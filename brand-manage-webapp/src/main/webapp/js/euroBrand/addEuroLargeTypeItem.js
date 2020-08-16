var ue;
$(document).ready(function(){
	layui.use(['form'], function() {
		var form = layui.form;
		form.render();
		
		//监听提交
		form.on('submit', function(data){
			saveEuroLargeTypeItem();
		});
	})
});

//保存分类
var saveEuroLargeTypeItem = function() {
	saas.ajax({
		type : "post",
		url : "/euroLargeTypeItem/saveEuroLargeTypeItem",
		data : $("#euroLargeTypeItemForm").serialize(),
		success : function(data) {
			parent.layer.msg("保存成功！");
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
			parent.searchFriendShip();
		}
	});
}
