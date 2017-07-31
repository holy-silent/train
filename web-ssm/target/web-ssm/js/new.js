$(document).ready(function(){
	//下拉菜单切换
	$('img.nav_img_s,img.nav_img_h').click(function(){
		$('div.nav').slideToggle();
		$('img.nav_img_h').show();
	});
	
	$('img.nav_img_s').hover(function(){
		$(this).attr('src','img/nav_h.png');
	}).mouseleave(function(){
		$(this).attr('src','img/nav_s.png');
	});
	
	//下拉菜单选项变化效果
	
    $('.nav ul li').click(function(){
			$(this).find('a').css('color','#00dfb9').parent().siblings().find('a').css('color','#ccc');
	});
	
	var w=$(window).width();
	if(w>768){
		$('.nav ul li').eq(0).css('border-top','3px solid #00dfb9');
		$('.nav ul li').click(function(){
			var _index=$(this).index();
			$(this).css('border-top','3px solid #00dfb9').siblings().css('border-top','3px solid rgba(251,251,251,0)');
			$('.nav ul li').hover(function(){
				$(this).find('a').css({'color':'#00dfb9'}).parent().siblings().find('a').css('color','#ccc');
				$('.nav ul li').eq(_index).find('a').css('color','#00dfb9');
			});
		});
	}
	
	if(w<768){
		  $('.logo img').attr('src','img/logo_s.png');
    }else{
	      $('.logo img').attr('src','img/logo_b.png');
	}
	
	//logo图标切换
	$(window).resize(function(){
		var w=$(window).width();
		if(w<768){
		  $('.logo img').attr('src','img/logo_s.png');
	    }else{
	      $('.logo img').attr('src','img/logo_b.png');
	    }
	});
	
	//第二屏鼠标悬浮变换
	//添加过渡效果
	$('.do_content a').css('text-decoration','none');
	$('.do_content').css('transition','0.5s');
	$('.do_content').hover(function(){
		 var _index=$(this).index();
		 $(this).css('background','rgb(0, 223, 185)');
		 $(this).find('img').attr('src','img/2_03-0'+_index+'.png');
		 $(this).find('p').css('color','#fff');
	}).mouseleave(function(){
		 var _index=$(this).index();
		 $(this).css('background','rgba(0,0,0,0)');
		 $(this).find('img').attr('src','img/1_03-0'+_index+'.png');
		 $(this).find('p').css('color','#333');
	});
});

//项目新加效果
$(document).ready(function(){
	$(".content .dan").css('border','3px solid #000');
	$(".content .dan").mouseenter(function(){
		$(this).css('border','3px solid #c40000');
	}).mouseleave(function(){
		$(this).css('border','3px solid #000');
	});
})
