var sortableO;
/**
 * 加载数据
 * @param url
 * @param sortableObj
 */
function loadSortable(url,sortableObj)
{
	sortableO=sortableObj;
	 $.ajax({
	        dataType : "json",
	        type : "POST",
	        async: false,
	        url : url, 
	        success : function(data) {
	        	sortableObj.dataList=data;
	        	$(sortableObj["tableName"]).html(sortableHtml(sortableObj));
	        	initSortable(sortableObj);
	        }  
	  });
 }
  function sortableHtml(sortableObj)
  {
	  var html='';
	  var data=sortableObj.dataList;
	  if(data&&data.length>0)
	  {
		  for(var i=0;i<data.length;i++)
		  {
			  var obj=data[i];
			  html+='<div class="column" categryid="'+obj.id+'" >';
			  html+='   <div class="portlet">';
			  html+='      <div class="portlet-header sortable-header">';
			  html+=          obj.name;
			  html+='        <div class="layui-btn-group" style="float:right;">';
			  if(sortableObj.editTable){
				  html+='     <button onclick="editTable('+obj.id+')" class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe642;</i></button>';
			   
			  }
			  if(sortableObj.delTable){
				  html+='     <button onclick="delTable(this,'+obj.id+')"  class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe640;</i></button>';
			  }
			  html+='        </div>';
			  html+='      </div>';
			  html+='      <div class="portlet-content">';
			  html+=         loadSortableItem(obj);
			  html+='      </div> ';
			  html+='   </div>';
			  html+='</div>';
		  }
	  }
	  if(sortableO.addTable){
		  html+=getAddHtml();
	  }
	  return html;
 }
  /**
   * 外层添加按钮
   * @returns {String}
   */
 function getAddHtml(){
	 var html='';
	  html+='<div class="column">';
	  html+='   <div class="portlet ui-widget-content">';
	  html+='      <div style="height:45px;"></div>';
	  html+='      <div class="portlet-content">';
	  html+='        <button onclick="addSortable();"  style="margin-top:100px;margin-left:80px;"  class="layui-btn"> ';
	  html+='          <i  style="margin-left:40px;margin-right:40px;"  class="layui-icon">&#xe654;</i>';
	  html+='        </button> ';
	  html+='      </div> ';
	  html+='   </div>';
	  html+='</div>';
	 return html;
 }
 /**
  * 外层编辑
  * @param id
  */
 function editTable(id)
 {
	 sortableO.editTable(id);
 }
 /**
  * 外层删除
  * @param id
  */
 function delTable(that,id){
	 sortableO.delTable(that,id);
 }
 function detableObj(that){
	 $(that).parents(".column").remove();
 }
 /**
  * 添加外层
  */
 function addSortable(){
	 sortableO.addTable();
 }
 function initSortable(sortableO){
	 //拖动结束事件
	  if(sortableO.sortableStop){
		  $(sortableO["tableName"]).sortable({
		      handle: ".portlet-header",
		      stop: function(event, ui) {
	    		  var ids= '';
	    		  $(".column").each(function(){
	    			var categryid=  $(this).attr("categryid");
	    			if(categryid){
	    				ids += categryid+",";
	    			}
	    			 sortableO.sortableStop(ids);
	    		  })
		      }
		    });
	    }
	    $( ".portlet-header" ).dblclick(function() {
	        var icon = $( this );
	        icon.closest( ".portlet" ).find( ".portlet-content" ).toggle();
	    });
	    
	    if(sortableO.sortableItem.sortableItemStop){
		    $(".sortableItem").sortable({
			       stop: function(event, ui) {
			        	//拖动结束事件
			        	 var sortableItemIds= '';
			        	 ui.item.parents(".sortableItem").find("li").each(function(){
			        		var sortableItemId=$(this).attr("sortableItemId");
			        		if(sortableItemId){
			        			sortableItemIds += sortableItemId+",";
			        		}
			        	 });
			    		sortableO.sortableItem.sortableItemStop(sortableItemIds);
			       }
			 });
	     }
		 $(".sortableItem").disableSelection();
}
 
 /**
 * 加载项
 * @param items
 * @returns {String}
 */
function loadSortableItem(obj){
	 var items=obj.items;
	 var html='';
	 html+='  <ul class="sortableItem">';
	 var addItem = false;
	 if(sortableO.sortableItem.addTableItem){
		 addItem = true;
	 }
	 if(items&&items.length>0){
		 for(var i=0;i<items.length;i++){
			 var item=items[i];
			 html+='   <li class="ui-state-default layui-elem-quote layui-quote-nm" sortableItemId="'+item.itemId+'" >';
			 html+=item.itemName;
			 html+='      <div class="layui-btn-group" style="float:right;">';
			 if(sortableO.sortableItem.editTableItem){
				 html+='     <i class="layui-icon" title="编辑" onclick="editItemTable('+item.itemId+')">&#xe642;</i>';
			 }
			 if(sortableO.sortableItem.delTableItem){
				 html+='     <i class="layui-icon" title="删除" onclick="delItemTable(this,'+item.itemId+')">&#xe640;</i>';
			 }
			 html+='      </div>';
			 html+='   </li>';
		 }
	 }
	 html+='  </ul>';
	 if(addItem){
		 html+='  <div class="sortableItemButton">';
		 html+='    <button  onclick="addSortableItem('+obj.id+');"   class="layui-btn layui-btn-primary layui-btn-fluid"> ';
		 html+='       <i  style="margin-left:20px;margin-right:20px;"  class="layui-icon">&#xe654;</i>';
		 html+='    </button> ';
		 html+='  </div>';
	 }
	 return html;
}
/**
 * 编辑项
 * @param id
 */
function editItemTable(id){
	sortableO.sortableItem.editTableItem(id);
}
/**
* 删除项
* @param id
*/
function delItemTable(that,id){
	sortableO.sortableItem.delTableItem(that,id);
}
function detableItemObj(that){
	$(that).parents("li").remove();
}
/**
* 添加项
*/
function addSortableItem(categoryId){
	sortableO.sortableItem.addTableItem(categoryId);
}
