var ue;
$(document).ready(function(){
	layui.use(['form', 'upload'], function() {
		var form = layui.form,upload = layui.upload;
		form.render();
		
		//监听提交
		form.on('submit', function(data){
			saveFriendShip();
		});
		
		upload.render({
			elem : '#imgUrl',
			url : appName + "/file/upload",
			before: function(obj){ //选择文件后上传前回调
    	    	layer.load(1);
    	    },
			done : function(res) {
				layer.closeAll('loading');
    	        saas.alert("上传图片成功！",1);
				var html = '';
				html += '<img width="200px" src="'+res.fileUrl+'" />';
				$("#imgUrl").html(html);
				$("#shipUrlVal").val(res.fileUrl);
			}
		});
	})
});

//保存友情 链接
var saveFriendShip = function() {
	saas.ajax({
		type : "post",
		url : "/friendShip/saveFriendShip",
		data : $("#shipForm").serialize(),
		success : function(data) {
			parent.layer.msg("保存成功！");
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
			parent.searchFriendShip();
		}
	});
}
