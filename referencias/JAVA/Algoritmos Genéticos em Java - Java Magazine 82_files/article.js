



xmlhttp = new XMLHttpRequest();


function showBoxConfirmaVoto(dummy) {
	var y=document.getElementById("ja_votou");
	
	if (y.innerHTML=="1")
	{
		alert("Você já votou para este post, obrigado");
	}
	else {

		if (dummy==1)
		{
			document.getElementById('box_voto_negativo_rodape').style.display='block';
		}
		else {
			document.getElementById('box_voto_negativo').style.display='block';
		}
	}
}

function votaPost(idcomp,util) {

	var y=document.getElementById("ja_votou");
	
	if (y.innerHTML=="1")
	{
		alert("Você já votou para este post, obrigado");
	}


	if (xmlhttp && y.innerHTML != "1") { 
		var url = "http://www.devmedia.com.br/articles/grava_fb_comp2.asp";
		var params = "idcomp="+idcomp +"&util="+util;
		xmlhttp.open("POST", url, true);
		
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.setRequestHeader("Content-length", params.length);
		xmlhttp.setRequestHeader("Connection", "close");


		xmlhttp.onreadystatechange = function() {

			if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				
				if (parseInt(util)==1)
				{

					
					var x = document.getElementById("counterUp");				
					var x2=document.getElementById("counterUp_rodape");	
					
					
				}
				else{
					/*var x=document.getElementById("counterDown");				
					var x2=document.getElementById("counterDown_rodape");	*/
				}
				
				y.innerHTML = "1";
				
				if (x) 
				{				
					var contador = parseInt(x.innerHTML);
					contador = contador + 1;
					x.innerHTML = contador;
				}

				if (x2) 
				{				
					var contador = parseInt(x2.innerHTML);
					contador = contador + 1;
					x2.innerHTML = contador; 
				}
					
			}
		}
		xmlhttp.send(params);
	}
	
}