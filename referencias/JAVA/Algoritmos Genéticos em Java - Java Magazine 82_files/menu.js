$(function(){
$(".popover1,.popover2,.dm-shadow").click(function(){
	if($(".login-pop").hasClass("deslogado")){$(".login-pop").toggleClass("bg-off");}
	else{$(".login-pop").toggleClass("bg-on");}
	$(".login-form").toggle();
	$(".dm-shadow").toggle();
});
$(window).resize(function(){
	$("header nav.lateral,header nav.lateral>ul").height($(this).height());
	//$("header nav.lateral>ul ul").css({"min-height":$("header nav.lateral>ul").height()+"px"});
	//$("header nav.lateral>ul ul").height($("header nav.lateral>ul").height());
	//if($("header nav.lateral>ul").height()>$(this).height()){$("header nav.lateral>ul ul").height($("header nav.lateral>ul").height());}
	//else{$("header nav.lateral>ul ul").height($("header nav.lateral>ul").height());}
	//alert($("header nav.lateral ul").height());
});
$(document).keyup(function(e){
	if(e.keyCode==27 && $("header nav.lateral").css("display")=="block"){//esc
		$("header nav.lateral").fadeOut(100).find(".active").removeClass("active");
		$("header .opacity").fadeOut(100);
		$("body").css({"overflow":"auto"});
	}
});
$("header .opacity,header nav.lateral").click(function(e){
	if($(e.target).attr('class')=="lateral"){
		$("header nav.lateral").fadeOut(100).find(".active").removeClass("active");
		$("header .opacity").fadeOut(100);
		$("body").css({"overflow":"auto"});
	}
});
$("header .menu").click(function(event){
	event.preventDefault();
	$("body").css({"overflow":"hidden"});
	$("header nav.lateral").css({"display":"table"});
	$("header nav.lateral,header .opacity").fadeIn(100,function(){
		$("header nav.lateral,header .opacity").css({"display":"block"});
		$("header nav.lateral>ul").css({"display":"table"});
		$("header nav.lateral").height($(window).height());
	});
});
$("header nav.lateral li a").click(function(event){
	if($(this).attr("href")=="#") event.preventDefault();
	var alvo = $(this).parent().parent().find(".active");
	if(alvo.length){event.preventDefault();alvo.removeClass("active");}
	else{$(this).parent().children("ul").addClass("active");$("header nav.lateral").scrollTop(0);}
});
$("header nav.lateral li .home").click(function(){
	$("header nav.lateral").find(".active").removeClass("active");
});
$("header nav.lateral li .back").click(function(){
	if($(this).data("main")==true){
		$("header nav.lateral").fadeOut(100).find(".active").removeClass("active");
		$("header .opacity").fadeOut(100);
		$("body").css({"overflow":"auto"});
	}
	else{$(this).parent().parent().parent().find(".active").removeClass("active");}
});
});