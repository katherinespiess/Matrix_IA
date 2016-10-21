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
<title>Matrix - IA</title>
</head>
<body>
	<div class="col-md-12 col-xs-12 col-lg-12">
		<textarea class="form-control" id="oGrandeCampo"></textarea>
	</div>

	<script type="text/javascript" src="assets/js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="assets/js/jquery-ui.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			$("#oGrandeCampo").change(function() {
				
				$.ajax({
					url: '/Sugere',
					type: 'GET',
					data: $("#oGrandeCampo").val()
						})
				
				var sugest = '${ Sugestao }'.split(',');
				alert(sugest);
				$("#oGrandeCampo").autocomplete({
					position : {
						offset : '-200 0'
					},
					source : sugest,
					select : function(event, ui) {
						//var val = ui.item.val;						
						//manda o valor selecionado pra um servlet atualizar o sugestor.

					}
				});
			});
		});
	</script>
</body>

</html>