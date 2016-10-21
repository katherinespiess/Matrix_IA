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
<body>
	<div class="col-md-12 col-xs-12 col-lg-12">
		<textarea class="form-control" id="mainFild"></textarea>
	</div>
	<script>
		$(function() {
			var availableTags = ["Olá", "Mundo"];
			function split(val) {
				return val.split(/[/w/W]*?\s+/);
			}
			function extractLast(term) {
				return split(term).pop();
			}

			$("#mainFild")
					.bind(
							"keydown",
							function(event) {
								if (event.keyCode === $.ui.keyCode.TAB
										&& $(this).autocomplete("instance").menu.active) {
									event.preventDefault();
								}
								$.ajax({
									url: 'Sugere',
									type: 'GET',
									data: 'val',
									success: function(data){
										availableTags = data.split(',');
									}});
							}).autocomplete(
							{
								minLength : 0,
								source : function(request, response) {
									response(availableTags);
								},
								focus : function() {
									return false;
								},
								select : function(event, ui) {
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