$(function(){
$("#headermenudesktop").prepend("<ul class=\"navspace menucel ativo3 dm-1\">\
<li><a href=\"#\" rel=\"nofollow\" class=\"menulink\">Iniciar &nbsp;<small>&#9660;</small></a>\
	<ul class=\"submenu\">\
		<li><a href=\"http://www.devmedia.com.br/guias/\">Guias de Refer&ecirc;ncia</a>\
			<ul class=\"submenu2\">\
			</ul>\
		</li>\
		<li><a href=\"http://www.devmedia.com.br/cursos/\">Cursos & S&eacute;ries</a>\
			<ul class=\"submenu2\">\
			</ul>\
		</li>\
		<li><a href=\"http://www.devmedia.com.br/canais/\">&Uacute;ltimas atualiza&ccedil;&otilde;es &nbsp;&raquo;</a>\
			<ul class=\"submenu2\">\
			<li><a href=\"http://www.devmedia.com.br/front-end-web/\">Front-end web</a></li>\
			<li><a href=\"http://www.devmedia.com.br/mobile/\">Mobile</a></li>\
			<li><a href=\"http://www.devmedia.com.br/java/\">Java</a></li>\
			<li><a href=\"http://www.devmedia.com.br/dotnet/\">.net</a></li>\
			<li><a href=\"http://www.devmedia.com.br/banco-de-dados/\">Banco de dados</a></li>\
			<li><a href=\"http://www.devmedia.com.br/engenharia-de-software/\">Engenharia de Software</a></li>\
			<li><a href=\"http://www.devmedia.com.br/delphi/\">Delphi</a></li>\
			<li><a href=\"http://www.devmedia.com.br/canal-mais/\">Canal Mais</a></li>\
			<li><a href=\"http://www.devmedia.com.br/canais/\" class=\"btn-dm-nav\">Todo o conte&uacute;do</a></li>\
			</ul>\
		</li>\
		<li><a href=\"http://www.devmedia.com.br/devcast/\">DevCast &nbsp;&raquo;</a>\
			<ul class=\"submenu2\">\
			<li><a href=\"http://www.devmedia.com.br/devcast/58\">V&iacute;deos de Front-end web</a></li>\
			<li><a href=\"http://www.devmedia.com.br/devcast/38\">V&iacute;deos de Mobile</a></li>\
			<li><a href=\"http://www.devmedia.com.br/devcast/34\">V&iacute;deos de Java</a></li>\
			<li><a href=\"http://www.devmedia.com.br/devcast/35\">V&iacute;deos de .NET</a></li>\
			<li><a href=\"http://www.devmedia.com.br/devcast/37\">V&iacute;deos de Banco de dados</a></li>\
			<li><a href=\"http://www.devmedia.com.br/devcast/43\">V&iacute;deos de Engenharia de Software</a></li>\
			<li><a href=\"http://www.devmedia.com.br/devcast/42\">V&iacute;deos Canal Mais</a></li>\
			<li><a href=\"http://www.devmedia.com.br/devcast/\" class=\"btn-dm-nav\">Todos os DevCast</a></li>\
			</ul>\
		</li>\
		<li class=\"submenu-guias\"><a href=\"http://www.devmedia.com.br/artigos/\">Artigos &nbsp;&raquo;</a>\
			<ul class=\"submenu2\">\
			<li><a href=\"http://www.devmedia.com.br/artigos/58\">Artigos de Front-end web</a></li>\
			<li><a href=\"http://www.devmedia.com.br/artigos/38\">Artigos de Mobile</a></li>\
			<li><a href=\"http://www.devmedia.com.br/artigos/34\">Artigos de Java</a></li>\
			<li><a href=\"http://www.devmedia.com.br/artigos/35\">Artigos de .NET</a></li>\
			<li><a href=\"http://www.devmedia.com.br/artigos/37\">Artigos de Banco de dados</a></li>\
			<li><a href=\"http://www.devmedia.com.br/artigos/43\">Artigos de Engenharia de Software</a></li>\
			<li><a href=\"http://www.devmedia.com.br/artigos/42\">Artigos Canal Mais</a></li>\
			<li><a href=\"http://www.devmedia.com.br/artigos/\" class=\"btn-dm-nav\">Todos os artigos</a></li>\
			</ul>\
		</li>\
		<li class=\"submenu-forum\"><a href=\"http://www.devmedia.com.br/forum/\">F&oacute;rum</a>\
			<ul class=\"submenu2\">\
			</ul>\
		</li>\
		<li class=\"submenu-recomendado\"><a href=\"http://www.devmedia.com.br/recomendado/\">Recomendado</a>\
			<ul class=\"submenu2\">\
			</ul>\
		</li>\
	</ul>\
</li>\
</ul>\
<ul class=\"menucel dm-6\"><li><strong><a href=\"http://www.devmedia.com.br/mvp/\" class=\"menulink2\">Assine MVP</a></strong></li></ul>");

$(".submenu>li").mouseenter(function() {
	var $submenu2 = $(this).find("ul.submenu2");
	// var $ativo3Height = $submenu2.height()+112;
	//alert($ativo3Height);
	
	// if($submenu2.length>0 && $ativo3Height>310){ $(".ativo3").css("height",$ativo3Height); }
	// else{ $(".ativo3").removeAttr("style");$submenu2.css("height",293); }
	// setTimeout( function() {
	// $submenu2.addClass("submenu2Hover");
	// }, 200);
}).mouseleave(function() {
	$("ul.submenu2").removeAttr("style");
	$(".ativo3").removeAttr("style");
});
});