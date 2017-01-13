var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/    	

	function showfattura(){
    	var nome=$( "input[name='Nome']" ).val();
    	var cognome=$("input[name='Cognome']").val();
    	var indirizzo=$("input[name='Indirizzo']").val();
    	var recapito=$("input[name='Recapito']").val();
    	var citta=$("input[name='citta']").val();
    	var CAP=$("input[name='CAP']").val();
    	var NumeroCarta=$("input[name='NumeroCarta']").val();
    	var nomeutente=$("input[name='nomeutente']").val();
    	var Payment=$('.Payment').val();
    	if(!nome.match(/^[A-Za-z ]{3,30}$/)){
    		alert("Inserire un nome");
    		return false;
    	}
    	if(!cognome.match(/^[A-Za-z ]{3,30}$/)){
    		alert("Inserire un cognome");
    		return false;
    	}
    	if(!recapito.match(re)){
    		alert("Inserire un'email valida");
    		return false;
    	}
    	if(!citta.match(/^[A-Za-z ]{3,30}$/)){
    		alert("Inserire una città");
    		return false;
    	}
    	var regexp = /^[\w\s.-]+\d$/;
    	if(!regexp.test(indirizzo)){
    		alert("Inserire un indirizzo");
    		return false;
    	}
    	if(!CAP.match(/^[0-9]{5}$/)){
    		alert("Inserire un cap");
    		return false;
    	}
    	if(Payment=='3'){
    		if(!username.match(re)){
        		alert("Inserire un'email corretta");
        		return false;
    		}
    		if(!password===""){
        		alert("Inserire password");
        		return false;
    		}
    	}
    	else{
    	if(!NumeroCarta.match(/^[0-9]{16}$/)){
    		alert("Inserire un numero di carta");
    		return false;
    	}
    	}
    	$("#popup").show();
    	$("#veil").fadeIn();
    }