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
			<div class="col-md-offset-3 col-md-9 content">
				<div id="start" class="h1-wrap">
					<h1 class="shareTech opacity">Matrix - IA AutoComplete</h1>
					<sub>&copy; LGC & GHS</sub>
				</div>
				<section id="one">
				<h2 class="shareTech">Demo</h2>
				<textarea id="mainField"></textarea> </section>



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
								var ignore = (event.KeyCode === $.ui.keyCode.UP
										|| event.keyCode === $.ui.keyCode.DOWN
										|| event.keyCode === $.ui.keyCode.LEFT
										|| event.keyCode === $.ui.keyCode.RIGHT || event.keyCode === $.ui.keyCode.SPACE)

								if ((event.keyCode === $.ui.keyCode.TAB && $(
										this).autocomplete("instance").menu.active)) {
									event.preventDefault();
								}

								if (!ignore) {
									$.ajax({
										url : 'Sugere',
										type : 'GET',
										data : 'digit='
												+ $("#mainField").val(),
										success : function(data) {
											console.log(data);
											availableTags = data
													.split(',');
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