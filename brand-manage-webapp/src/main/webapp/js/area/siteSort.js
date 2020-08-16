$(document).ready(function(){
	$('.portlet-content').height($('body').height()+240);
	loadSiteItem();
});

//加载站点
var loadSiteItem = function(){
	saas.ajax({
		type : "post",
		url : "/area/siteAll",
		success : function(data) {
			var html = '';
			if (data && data.length > 0) {
				for (var i = 0; i < data.length; i++) {
					var item = data[i];
					html += '<li class="ui-state-default layui-elem-quote layui-quote-nm" sortableItemId="'+item.id + '">';
					html += item.siteName;
					html += '<div class="layui-btn-group" style="float:right;">';
					html += '</div>';
					html += '</li>';
				}
			}
			$('.sortableItem').html(html);
			$(".sortableItem").sortable({
			       stop: function(event, ui) {
			    	   var sortableItemIds = '';
			    	   	ui.item.parents(".sortableItem").find("li").each(function() {
			    	   		var sortableItemId = $(this).attr("sortableItemId");
			    	   		if (sortableItemId) {
			    	   			sortableItemIds += sortableItemId + ",";
			    	   		}
			    	   	});
			    	   	if(saas.isNotNull(sortableItemIds)){
			    	   		saas.ajax({
			    				type: "post",
			    				url: "/area/reSortSite",
			    				data: {'ids': sortableItemIds},
			    				success: function(data){
			    					parent.searchSite();
			    				}
			    			});
			    	   	}
			       }
			 });
			 $(".sortableItem").disableSelection();
		}
	});
}