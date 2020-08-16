/***************************************************************
 ************************封装当前异步请求************************
 **************************************************************/
var saas = new function(page){
	this.appName = appName;
	this.ajax = function(param) {
		var divLockScreen;
		if(!param) {
			param = new Object();
		}
		
		if(param.url) {
			param.url = saas.appName + param.url;
		}
		var complete = param.complete;
		var error = param.error;
		var success = param.success;
		saas.isLockScreen(param, function(lockScreen) {
			if(lockScreen) {
				divLockScreen = saas.openLockScreen();
			}
		});
		param.complete = function(xhr, ts) {
			if(complete) {
				complete(xhr, ts);
			}
			if(divLockScreen) {
				divLockScreen.remove();
			}
		}
		param.error = function() {
			// 没有登录弹出
			if(error) {
				error();
			}
		}
		
		param.success= function(data) {
			if(success) {
				// 判断对象是否为JSON String
				var result;
				try {
					result = eval("(" +data + ")");
				} catch(e) {
					result = data;
				}
				success(result);
			}
		}
		$.ajax(param);
	}
	
	this.post = function(url, param, callback, dataType) {
		saas.ajax({
			type:"post",
			url:url,
			data:param,
			success:callback,
			error:callback,
			dataType:dataType
		});
//		if(url) {
//			url = saas.appName + url;
//		}
//		var divLockScreen; 
//		if(!param) {
//			param = new Object();
//		}
//		saas.isLockScreen(param, function(lockScreen) {
//			if(lockScreen) {
//				divLockScreen = saas.openLockScreen();
//			}
//		});
//		$.post(url, param, function(result) {
//			if(callback) {
//				callback(result);
//			}
//			if(divLockScreen) {
//				divLockScreen.remove();
//			}
//		}, dataType);
	}
	
	this.get = function(url, param, callback, dataType) {
		saas.ajax({
			type:"post",
			url:url,
			data:param,
			success:callback,
			error:callback,
			dataType:dataType
		});
	}
	
	this.isLockScreen = function(param, callback) {
		if(callback) {
			callback(param &&  typeof param.lockScreen == "boolean" ? param.lockScreen : true);
		}
	}
	
	this.openLockScreen = function() {
		var body = ($("body").length) > 1 ? $("body").eq(0) : $("body");
		var div = body.addDiv({"class" : "lockScreen"});
		div.addDiv();
		return div;
	}
	
	this.isNull = function(obj) {
		return null == obj || obj === "" || undefined == obj;
	}
	
	this.isNotNull = function(obj) {
		return null != obj && undefined != obj && obj !== "" ;
	}
	
	this.alert = function(title,iconNumber){
		layer.msg(title, {
			  icon: iconNumber,
			  time: 2000
		}, function(){
			
		});  
	}
}


/***************************************************************
 **************************扩展方法******************************
 **************************************************************/
$.fn.extend({
	saasAttr : function(attr) {
		if(attr) {
			// 判断是否为JSON
			this.attr(attr);
		}
	},
	addDiv : function(attr) {
		var element = $("<div>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addSpan : function(attr) {
		var element = $("<span>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addSpam : function(attr) {
		var element = $("<spam>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addLabel : function(attr) {
		var element = $("<label>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addTable : function(attr) {
		var element = $("<table>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addThead : function(attr) {
		var element = $("<thead>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addTbody : function(attr) {
		var element = $("<tbody>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addTr : function(attr) {
		var element = $("<tr>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addTh : function(attr) {
		var element = $("<th>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addTd : function(attr) {
		var element = $("<td>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addUl : function(attr) {
		var element = $("<ul>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addLi : function(attr) {
		var element = $("<li>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addForm : function(attr) {
		var element = $("<form>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addTextArea : function(attr) {
		var element = $("<textarea>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addInput : function(attr) {
		var element = $("<input>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addSelect: function(attr) {
		var element = $("<select>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addOption : function(attr) {
		var element = $("<option>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addImg : function(attr) {
		var element = $("<img>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addA : function(attr) {
		var element = $("<a>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addP : function(attr) {
		var element = $("<p>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addDl : function(attr) {
		var element = $("<dl>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addDd : function(attr) {
		var element = $("<dd>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addB : function(attr) {
		var element = $("<b>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addBr : function(attr) {
		var element = $("<br>");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	addOther : function(title, attr) {
		var element = $("<" + title + ">");
		element.saasAttr(attr);
		$(this).append(element);
		return element;
	},
	saasLoad : function(url, param, callback) {
		var _this = this;
		saas.post(
			url,
			param,
			function(data) {
				$(_this).html(data);
				if(callback) {
					callback(data);
				}
			}
		);
	},
	saasJson : function(data, name) {
		if(null != data && undefined != data) {
			var from = this;
			var name = name || "";
		    var teststr = JSON.stringify(data);
		    var type = teststr[0] == '{' && teststr[teststr.length - 1] == '}' 
		    	? "class" : teststr[0] == '[' && teststr[teststr.length - 1] == ']' 
		    	?  "array" : "other";

			if(type === "array") {
				$.each(data,function(i) {
					from.saasJson(this, name+"["+i+"]");
				});
			} else if(type === "class"){
				for(key in data) {
					from.saasJson(data[key], (name ? name + "." : "") + key);
				}
			} else {
				var el = from.find("name='"+name+"'");
				if(el[0].tagName === "LABEL"){
					el.text(data);
				} else {
					el.val(data);
				}
				var el = from.find("name='"+name+"'");
				
				from.find("name='"+name+"'").val(data);
			}
		} else {
			var data = {}; o = {};
			var a = $(this).serializeArray();
			$.each(a, function() {
				if (o[this.name] !== undefined) {
					if (!o[this.name].push) {
						o[this.name] = [o[this.name]];
					}
					o[this.name].push(this.value || '');
				} else {
					o[this.name] = this.value || '';
				}
			});
			for(var item in o) {
				if(/.+\[\d+\]\..+/.test(item)){
					var arr = item.split(/\[|\]\./);
					if(!data.hasOwnProperty($.trim(arr[0]))) {
						data[$.trim(arr[0])] = new Array();
					}
					for(var i = data[$.trim(arr[0])].length; i <= arr[1]; i++) {
						data[$.trim(arr[0])].push(new Object());
					}
					data[$.trim(arr[0])][arr[1]][$.trim(arr[2])] = o[item]; 
				} else if(/.+\..+/.test(item)) {
					var arr = item.split(/\./);
					if(!data.hasOwnProperty($.trim(arr[0]))) {
						data[$.trim(arr[0])] = {};
					}
					data[$.trim(arr[0])][$.trim(arr[1])] = o[item];
				} else {
					data[item] = o[item];
				}
			}
			
			return data;
		}
	},
	formJson : function(data, name) {
		if(null != data && undefined != data) {
			var from = this;
			var name = name || "";
		    var teststr = JSON.stringify(data);
		    var type = teststr[0] == '{' && teststr[teststr.length - 1] == '}' 
		    	? "class" : teststr[0] == '[' && teststr[teststr.length - 1] == ']' 
		    	?  "array" : "other";

			if(type === "array") {
				$.each(data,function(i) {
					from.justarsJson(this, name+"["+i+"]");
				});
			} else if(type === "class"){
				for(key in data) {
					from.justarsJson(data[key], (name ? name + "." : "") + key);
				}
			} else {
				var el = from.find("name='"+name+"'");
				if(el[0].tagName === "LABEL"){
					el.text(data);
				} else {
					el.val(data);
				}
				var el = from.find("name='"+name+"'");
				
				from.find("name='"+name+"'").val(data);
			}
		} else {
			var data = {}; o = {};
			var a = $(this).serializeArray();
			$.each(a, function() {
				if (o[this.name] !== undefined) {
					if (!o[this.name].push) {
						o[this.name] = [o[this.name]];
					}
					o[this.name].push(this.value || '');
				} else {
					o[this.name] = this.value || '';
				}
			});
			for(var item in o) {
				if(/.+\[\d+\]\..+/.test(item)){
					var arr = item.split(/\[|\]\./);
					if(!data.hasOwnProperty($.trim(arr[0]))) {
						data[$.trim(arr[0])] = new Array();
					}
					for(var i = data[$.trim(arr[0])].length; i <= arr[1]; i++) {
						data[$.trim(arr[0])].push(new Object());
					}
					data[$.trim(arr[0])][arr[1]][$.trim(arr[2])] = o[item]; 
				} else if(/.+\..+/.test(item)) {
					var arr = item.split(/\./);
					if(!data.hasOwnProperty($.trim(arr[0]))) {
						data[$.trim(arr[0])] = {};
					}
					data[$.trim(arr[0])][$.trim(arr[1])] = o[item];
				} else {
					data[item] = o[item];
				}
			}
			
			return data;
		}
	}
});
var formatPeriod = function (dd) {
	if(!dd||dd=='undefined'){
		return '';
	}
	var d=new Date(dd);
	return d.getFullYear()+"年"+getTwoTime(d.getMonth()+1)+"期";
}
function formatDate(dd){
	if(!dd||dd=='undefined'){
		return '';
	}
	var d=new Date(dd);
	return d.getFullYear()+"/"+getTwoTime(d.getMonth()+1)+"/"+getTwoTime(d.getDate());
}

function formatDateStr(dd,str){
	if(!dd||dd=='undefined'){
		return '';
	}
	var d=new Date(dd);
	return d.getFullYear()+str+getTwoTime(d.getMonth()+1);
}
//获取月份最后一天
function getLastDay(year,month){     
	 var new_year = year;  //取当前的年份     
	 var new_month = ++month;//取下一个月的第一天，方便计算（最后一天不固定）     
	 if(month>11)      //如果当前大于12月，则年份转到下一年     
	 {     
	 new_month -=12;    //月份减     
	 new_year++;      //年份增     
	 }     
	 var new_date = new Date(new_year,new_month,1);        //取当年当月中的第一天     
	 return (new Date(new_date.getTime()-1000*60*60*24)).getDate();//获取当月最后一天日期     
}

function formatDateTime(dd){
	if(!dd||dd=='undefined'){
		return '';
	}
	var d=new Date(dd);
	return d.getFullYear()+"-"+getTwoTime(d.getMonth()+1)+"-"+getTwoTime(d.getDate())+" "+getTwoTime(d.getHours ())+":"+getTwoTime(d.getMinutes())+":"+getTwoTime(d.getSeconds());
}
//获取两位数的时间
function getTwoTime(t){
	if(t<10){
		return "0"+t;
	}
	return t;
}


function commonMouseleave(objs,form){
	$(objs).mouseleave(function(){
		$(form).hide();
	});
}

function commonMouseenter(objs,form){
	$(objs).mouseenter(function(){
		$(form).show();
	});
}

function commonFocus(objs,form,method){
	$(objs).focus(function(){
		$(form).unbind(method);
	});
}

function commonBlur(objs,objs1,form){
	$(objs).blur(function(){
		commonMouseleave(objs1,form);
	});
}

//去除特殊字符
function iGetInnerText(testStr) {
	if(saas.isNotNull(testStr)){
        var resultStr = testStr.replace(/\ +/g, ""); //去掉空格
        resultStr = testStr.replace(/[ ]/g, "");    //去掉空格
        resultStr = testStr.replace(/[\r\n]/g, ""); //去掉回车换行
        return resultStr;
	}else{
		return "";
	}
}

//点击弹出框的第一个按钮
var clickLayui = function(){
	$('.layui-layer-btn0')[0].click();
}

function clearNoNum(ths){
	var value = $(ths).val();
    //清除"数字"和"."以外的字符
    value = value.replace(/[^\d.]/g,"");
    //验证第一个字符是数字而不是
    value = value.replace(/^\./g,"");
    //只保留第一个. 清除多余的
    value = value.replace(/\.{2,}/g,".");
    value = value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
    //只能输入两个小数
    value = value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); 
    $(ths).val(value);
}


/****************************图片*/
//包含
Array.prototype.contain = function(val)  
{  
     for (var i = 0; i < this.length; i++)  
    {  
       if (this[i] == val)  
      {  
       return true;  
      }  
    }  
     return false;  
};

//删除
Array.prototype.remove = function(val){
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
}

//高级查询的切换
$(document).mousemove(function(e){
    var userSet_con = $('.advancedSeach,.gjsearch,.layui-laydate');
    if(!userSet_con.is(e.target) && userSet_con.has(e.target).length === 0){
    }else{
    	$('.advancedSeach').show();
    }
});

//高级查询的切换
$(document).click(function(e){
    var userSet_con = $('.advancedSeach,.gjsearch,.layui-laydate');
    if(!userSet_con.is(e.target) && userSet_con.has(e.target).length === 0){
        $('.advancedSeach').hide();
    }
});

//触发验证
var laySubmit = function(formId){
	$(formId+' #lay-submit').click();
}

//查看图片
var prePhotos = function(ele){
	layer.photos({
		photos: ele
		,anim: 5
	}); 
}

//初始化富文本
var initUeditor = function(){
	var ue = UE.getEditor('editor',{
		toolbars: [
		    [
		    	'undo', //撤销
			    'redo', //重做
		    	'fontfamily', //字体
		        'fontsize', //字号
		        'forecolor', //字体颜色
		        'backcolor', //背景色
		        'bold', //加粗
		    	'italic', //斜体
		    	'underline', //下划线
		        'link', //超链接
		        'unlink', //取消链接
		        '|',
		        'customstyle', //自定义标题
		        'paragraph', //段落格式
		        'indent', //首行缩进
		        'justifyleft', //居左对齐
		        'justifyright', //居右对齐
		        'justifycenter', //居中对齐
		        'justifyjustify', //两端对齐
		        'insertorderedlist', //有序列表
		        'insertunorderedlist', //无序列表
		        'rowspacingtop', //段前距
		        'rowspacingbottom', //段后距
		        'horizontal', //分隔线
		        '|',
		        'inserttable', //插入表格
		        'insertrow', //前插入行
		        'insertcol', //前插入列
		        'mergeright', //右合并单元格
		        'mergedown', //下合并单元格
		        'deleterow', //删除行
		        'deletecol', //删除列
		        'splittorows', //拆分成行
		        'splittocols', //拆分成列
		        'splittocells', //完全拆分单元格
		        'deletecaption', //删除表格标题
		        'inserttitle', //插入标题
		        'mergecells', //合并多个单元格
		        'deletetable', //删除表格
		        'template', //模板
		        'simpleupload', //单图上传
		        'insertimage', //多图上传
		        'imagenone', //默认
		        'imageleft', //左浮动
		        'imageright', //右浮动
		        'imagecenter', //居中
		        '|',
		        'source', //源代码
		        'selectall', //全选
		        'preview', //预览
		        'fullscreen', //全屏
		        'removeformat', //清除格式
		        'cleardoc', //清空文档
		        'searchreplace', //查询替换
		        'help', //帮助
		        '|',
		        'contractno',
		        'contractwtr',
		        'contractwtrphone',
		        'contractwtrsign',
		        'contractbwtr',
		        'contracttime',
		        'contractservices'
		    ]
		],labelMap:{
        	'contractno': '插入合同编号','contractwtr': '插入合同委托人','contractwtrphone': '插入合同委托人电话',
        	'contractwtrsign': '插入合同委托人签名','contractbwtr': '插入合同被委托人','contractbwtr': '插入合同签署时间','contractservices': '插入合同服务内容'
        },
		enableAutoSave:false
	});
	
	ue.ready(function () {
        $(".edui-editor-messageholder.edui-default").css({ "visibility": "hidden" });
	});
	
	UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
	UE.Editor.prototype.getActionUrl = function(action) {
	    if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadvideo') {
	    	return appName+'/file/ueditorUpload';
	    } else {
	        return this._bkGetActionUrl.call(this, action);
	    }
	}
	
	return ue;
}