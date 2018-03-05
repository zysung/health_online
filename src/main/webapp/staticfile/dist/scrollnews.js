// 消息滚动
$(function(){
		var scrolldiv=$(".notice");
		var scrolltimer;
		scrolldiv.mouseover(function(){
			clearInterval(scrolltimer);
			});
		scrolldiv.mouseout(function(){
			scrolltimer=setInterval(function(){scrollnews(scrolldiv);},2000);			
		}).trigger("mouseout");	

	function scrollnews($div){
		var scrollul=$div.find("ul");
		var lineheight=scrollul.find("li:first").height();
		scrollul.animate({"margin-top":-lineheight+"px"},600,function(){scrollul.css({'margin-top':0}).find("li:first").appendTo(scrollul);});
	}
});