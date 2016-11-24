<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="assets/bootstrap-3.3.7-dist/css/bootstrap.css" />
<link rel="stylesheet" href="assets/css/Site.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<script type="text/javascript" src="assets/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="assets/js/jquery-ui.js"></script>
<title>Matrix - IA</title>
</head>
<body data-spy="scroll" data-target="#side-nav">
	<div class="container">
		<div class="row">
			<div id="side-nav">
				<ul class="nav nav-list affix">
					<li><a href="#start">Introdução<br></a></li>
					<li><a href="#one">Demo</a></li>
					<li><a href="#two">Caixeiro</a></li>
					<li><a href="#three">Alguma outra coisa</a></li>
				</ul>
			</div>
			<div class="col-md-offset-3 col-md-9 content">
				<div id="start" class="h1-wrap">
					<h1 class="shareTech opacity">Matrix - IA AutoComplete</h1>

				</div>
				<section id="one">
					<h2 class="shareTech">Demo</h2>
					<textarea id="mainField"></textarea> 
				</section>
				<section id="two">
					<h2 class="shareTech">Caixeiro</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras vitae nulla efficitur, hendrerit nulla eu, egestas dolor. Ut et diam sit amet mauris convallis tristique. Vivamus gravida ligula vel leo scelerisque posuere. Sed congue, orci ut tempor suscipit, erat ipsum condimentum ipsum, et vestibulum augue dolor a orci. Aenean porttitor, magna quis dapibus hendrerit, enim risus ornare massa, a euismod magna mauris sit amet lorem. Mauris feugiat pretium molestie. Quisque efficitur eleifend faucibus. Cras finibus, risus pharetra pretium volutpat, quam sapien condimentum lectus, quis euismod erat leo ut massa. Nullam ornare, ante ac molestie fringilla, lacus elit bibendum metus, nec pellentesque purus augue vitae magna.

Mauris ut nibh in leo aliquam malesuada. Nullam eros ipsum, luctus at odio eu, commodo sodales lectus. Duis lobortis enim ac eros sodales posuere. Morbi aliquam odio mauris, eu ultricies magna placerat et. Morbi quis vulputate leo. Vivamus molestie ut neque vel pulvinar. Ut sodales arcu tellus, in commodo mi molestie vel. Etiam luctus turpis vel commodo lobortis. Nam imperdiet semper ipsum, ut egestas quam pretium eget. Ut facilisis sagittis odio, sit amet cursus turpis iaculis sed. Vestibulum sed est nisl. Mauris tincidunt ipsum quis leo egestas, in rhoncus nunc posuere. Aliquam aliquet tortor ac elit vulputate, id rhoncus lectus hendrerit. Morbi non turpis ac velit elementum facilisis. Quisque aliquam nunc id porttitor fermentum. Praesent molestie malesuada lobortis.

Integer condimentum tincidunt nisi eu molestie. Vestibulum in elit id massa semper ultricies. Cras a sagittis ipsum. Aliquam accumsan pellentesque odio, et sollicitudin urna rutrum et. Donec nec purus dolor. Suspendisse viverra pellentesque ligula a vehicula. Curabitur tempus diam gravida, scelerisque erat id, semper odio.

Aenean mollis orci vitae ex tincidunt hendrerit. Donec in lorem fringilla eros facilisis tempor. Maecenas vitae venenatis libero, sit amet tincidunt tortor. Donec at libero vitae nisi malesuada blandit. Vivamus at molestie ligula. Fusce elementum tellus libero, sed mattis nunc suscipit ac. Quisque ornare molestie tellus eu posuere. In dictum mauris ut urna dignissim, quis aliquam mi condimentum.

Etiam ultrices venenatis enim pharetra auctor. Vestibulum feugiat elit arcu, nec rhoncus ligula pretium in. Nunc at arcu consectetur mauris tempor mattis. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse quis felis interdum felis malesuada cursus. Nulla semper nunc ac tortor ullamcorper, ut euismod risus mattis. Curabitur ultricies eleifend ante, nec gravida dui molestie ac. Nunc rhoncus ac quam at tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus maximus velit eu metus commodo eleifend. Vestibulum quis ex ac turpis condimentum malesuada sed vitae mi. Nam ac rhoncus eros. Phasellus sed ligula mi. Cras a dapibus nisl.</p>
				</section>
				<section id="three">
					<h2 class="shareTech">Alguma outra coisa</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras vitae nulla efficitur, hendrerit nulla eu, egestas dolor. Ut et diam sit amet mauris convallis tristique. Vivamus gravida ligula vel leo scelerisque posuere. Sed congue, orci ut tempor suscipit, erat ipsum condimentum ipsum, et vestibulum augue dolor a orci. Aenean porttitor, magna quis dapibus hendrerit, enim risus ornare massa, a euismod magna mauris sit amet lorem. Mauris feugiat pretium molestie. Quisque efficitur eleifend faucibus. Cras finibus, risus pharetra pretium volutpat, quam sapien condimentum lectus, quis euismod erat leo ut massa. Nullam ornare, ante ac molestie fringilla, lacus elit bibendum metus, nec pellentesque purus augue vitae magna.

Mauris ut nibh in leo aliquam malesuada. Nullam eros ipsum, luctus at odio eu, commodo sodales lectus. Duis lobortis enim ac eros sodales posuere. Morbi aliquam odio mauris, eu ultricies magna placerat et. Morbi quis vulputate leo. Vivamus molestie ut neque vel pulvinar. Ut sodales arcu tellus, in commodo mi molestie vel. Etiam luctus turpis vel commodo lobortis. Nam imperdiet semper ipsum, ut egestas quam pretium eget. Ut facilisis sagittis odio, sit amet cursus turpis iaculis sed. Vestibulum sed est nisl. Mauris tincidunt ipsum quis leo egestas, in rhoncus nunc posuere. Aliquam aliquet tortor ac elit vulputate, id rhoncus lectus hendrerit. Morbi non turpis ac velit elementum facilisis. Quisque aliquam nunc id porttitor fermentum. Praesent molestie malesuada lobortis.

Integer condimentum tincidunt nisi eu molestie. Vestibulum in elit id massa semper ultricies. Cras a sagittis ipsum. Aliquam accumsan pellentesque odio, et sollicitudin urna rutrum et. Donec nec purus dolor. Suspendisse viverra pellentesque ligula a vehicula. Curabitur tempus diam gravida, scelerisque erat id, semper odio.

Aenean mollis orci vitae ex tincidunt hendrerit. Donec in lorem fringilla eros facilisis tempor. Maecenas vitae venenatis libero, sit amet tincidunt tortor. Donec at libero vitae nisi malesuada blandit. Vivamus at molestie ligula. Fusce elementum tellus libero, sed mattis nunc suscipit ac. Quisque ornare molestie tellus eu posuere. In dictum mauris ut urna dignissim, quis aliquam mi condimentum.

Etiam ultrices venenatis enim pharetra auctor. Vestibulum feugiat elit arcu, nec rhoncus ligula pretium in. Nunc at arcu consectetur mauris tempor mattis. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse quis felis interdum felis malesuada cursus. Nulla semper nunc ac tortor ullamcorper, ut euismod risus mattis. Curabitur ultricies eleifend ante, nec gravida dui molestie ac. Nunc rhoncus ac quam at tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus maximus velit eu metus commodo eleifend. Vestibulum quis ex ac turpis condimentum malesuada sed vitae mi. Nam ac rhoncus eros. Phasellus sed ligula mi. Cras a dapibus nisl.</p>
				</section>
				<sub>&copy; LGC & GHS</sub>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-xs-4 col-lg-4"></div>
		<div class="col-md-8 col-xs-8 col-lg-8"></div>
	</div>

	<script type="text/javascript"
		src="assets/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function() {
			var availableTags = [ "Olá", "Mundo" ];
			function split(val) {
				return val.split(/[/w/W]*?\s+/);
			}
			function extractLast(term) {
				return split(term).pop();
			}

			$("#mainField")
					.bind(
							"keyup",
							function(event) {								
								var ignore = (event.KeyCode === $.ui.keyCode.UP || event.keyCode === $.ui.keyCode.DOWN 
										|| event.keyCode === $.ui.keyCode.LEFT || event.keyCode === $.ui.keyCode.RIGHT 
										|| event.keyCode === $.ui.keyCode.SPACE)
										
								if ((event.keyCode === $.ui.keyCode.TAB
											&& $(this).autocomplete("instance").menu.active )) {
										event.preventDefault();
									}
									
								if(!ignore) {
									$.ajax({
										url : 'Sugere',
										type : 'GET',
										data : 'digit=' + $("#mainField").val(),
										success : function(data) {
											console.log(data);
											availableTags = data.split(',');
										}
									});
								}
							}).autocomplete({
						minLength : 0,
						source : function(request, response) {
							response(availableTags);
						},
						focus : function() {
							return false;
						},
						select : function(event, ui) {
							//aqui da para incrementar os usos do sugestor. ui.item.label é a palavra selecionada.
							
							var terms = split(this.value);
							terms.pop();
							terms.push(ui.item.value);
							terms.push("");
							this.value = terms.join(" ");
							return false;
						}
					});
		});
	</script>
</body>

</html>