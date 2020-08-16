var ue;
$(document).ready(function(){
	layui.use(['form'], function() {
		var form = layui.form;
		form.render();
		
		//监听提交
		form.on('submit', function(data){
			saveDycLargeTypeItem();
		});
	})
});

//保存
var saveDycLargeTypeItem = function() {
	saas.ajax({
		type : "post",
		url : "/dycLargeTypeItem/saveDycLargeTypeItem",
		data : $("#dycLargeTypeItemForm").serialize(),
		success : function(data) {
			parent.layer.msg("保存成功！");
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
			parent.searchFriendShip();
		}
	});
}
