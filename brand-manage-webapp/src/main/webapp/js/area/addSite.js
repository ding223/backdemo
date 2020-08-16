var ue;
$(document).ready(function(){
	layui.use(['form'], function() {
		var form = layui.form;
		form.render();
		
		//监听提交
		form.on('submit', function(data){
			saveSite();
		});
	})
});

//保存站点
var saveSite = function() {
	saas.ajax({
		type : "post",
		url : "/area/saveSite",
		data : $("#siteForm").serialize(),
		success : function(data) {
			parent.layer.msg("保存成功！");
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
			parent.searchSite();
		}
	});
}
