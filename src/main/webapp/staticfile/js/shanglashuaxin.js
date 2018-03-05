// JavaScript Document
/*列表模块*/


//滚动包裹层与滚动层的差值
	var disY = $('.wrapper').height() - $('ul').height();

	//当刷新后重置差值函数
	function resetH(){
		disY = $('.wrapper').height() - $('ul').height();
	}

	//拉开与顶部或底部的距离达到这个值后刷新
	var maxDis = 50;

	//实例化Iscroll对象
	var myScroll = new IScroll('.wrapper',{probeType: 3});

	//滚动结束后重置滚动区域，和disY差值
	myScroll.on('scrollEnd',function (){
		this.refresh();
		resetH();
	})

	//滚动时监测滚动是否达到可以刷新的差值
	myScroll.on('scroll',function (){
		
		if ( this.y > maxDis ){
			$('.tip').css({'display':'block'});			
		}else if ( this.y - disY < -maxDis ){
			$('.tipdown').css({'display':'block'});
		}else {
			$('.tip,.tipdown').css({'display':'none'});
		}

	})
	
	//手释放，或鼠标释放的时候满足刷新条件，则触发Ajax获取数据，
	$(document).on('touchend mouseup',function (){
		
		if ( myScroll.y > maxDis ){
			//这里写Ajax获取后的处理函数，
			$('<li>下拉模拟Ajax获取的一条新信息</li>').prependTo('.scroller');

		}else if ( myScroll.y - disY < -maxDis ){
			$('<li>上拉模拟Ajax获取的一条新信息</li>').appendTo('.scroller');

			myScroll.scrollToElement($('li').last().get(0),100);

		}
	})