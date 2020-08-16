(function($) {
    $.fn.serializeJSON = function(options) {
        var opts = $.extend({}, $.fn.serializeJSON.defaults, options);
        var resultJSON={};
        this.find(":input").each(function(){
        	var name1=this.name;
        	var value1=this.value;
        	resultJSON[name1]=value1;
        });
        return resultJSON;
      /*  var formData = this.serialize();
        var params = toArray(formData,"&");
        var resultJSON={};
        var connecter = function(name,source,value){
            if(!value || value.length<1)return source;
            var char = opts.connectName[name]?opts.connectName[name]:opts.connect;
            return source+char+value;
        }
        $.each(params,function(){
            var param = toArray(this,"=");
            var attr = param[0];
            var val = param[1];
            if(resultJSON[attr]){//multi
                resultJSON[attr] = connecter(attr,resultJSON[attr],val);
            }else{
                resultJSON[attr] = val;
            }
        })*/
        return resultJSON;
    };
    $.fn.serializeJSON.defaults = {
            connectName:{},
            connect:","
    };
})(jQuery);