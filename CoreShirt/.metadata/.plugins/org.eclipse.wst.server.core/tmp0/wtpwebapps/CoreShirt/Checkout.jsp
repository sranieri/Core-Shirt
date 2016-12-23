<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
   Cart cart = (Cart) session.getAttribute("cart");%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.Articolo,model.Cart,model.TShirt"%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
    <script src="Script/jquery.js"></script>
    <link rel="icon" href="Immagini/sprite0.png" />
    <link rel="stylesheet" href="CSS/base.css" type="text/css">
    <link rel="stylesheet" href="CSS/Cart.css" type="text/css">
    <link rel="stylesheet" href="CSS/Checkout.css" type="text/css">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt: The Best T-Shirts series</title>
    <script>
    $(document).ready(function(){
    	$("#popup").hide();
    	$('.hidden').hide();
    	$('.Payment').change(function(){
    		var Payment=$('.Payment').val();
    		if(Payment=='3'){
    			$('.Numerocarta .input').hide();
    			$('.hidden').show();
    		}
    		else{
    			$('.Numerocarta .input').show();
    			$('.hidden').hide();
    		}
    	})
    })
    function showfattura(){
    	var nome=$( "input[name='Nome']" ).val();
    	var cognome=$("input[name='Cognome']").val();
    	var indirizzo=$("input[name='Indirizzo']").val();
    	var recapito=$("input[name='Recapito']").val();
    	var CAP=$("input[name='CAP']").val();
    	var NumeroCarta=$("input[name='NumeroCarta']").val();
    	var nomeutente=$("input[name='nomeutente']").val();
    	var password=$("input[name='password']").val();
    	if(nome === "" || cognome === "" || indirizzo === "" || recapito === "" || CAP === "" || NumeroCarta === ""){
    		if(nomeutente != "" && password != ""){
    			$("#popup").show();
    	    	$("#veil").fadeIn();
    		}
    	}
    	else{
    	$("#popup").show();
    	$("#veil").fadeIn();}
    }
    
    </script>
    
     </head>
<body>
    <div id="wrapper">
    <article id="articolo1">
    <div id="lista">
    <a href="./"><div id="banner"> <img class="Banner" src="Immagini/prova.png"> 
          <img class="core" src="Immagini/core2.png"></a>
        </div>
    <div>
    <nav>    
        <ul id="menu">
            <li><a href="./"><img class="home" src="Immagini/home.png"></a> </li>
            <li><a href="./?action=Uomo"> Uomo </a></li>
            <li><a href="./?action=Donna"> Donna  </a>
            </li>
            <li><a href="./About">About</a></li>
            <li><a href="./Help">Help</a></li>   
            <li><a href="./Checkout">Checkout</a></li>
            <li><a href="./?action=cart">
                <img class="cart" src="Immagini/cart.png"></a></li>
        </ul>
    </nav>
    </div>
    </div>
    </article>
    <%if(cart==null||cart.totalItem()==0){ %>
    <div class="empty_cart">Carrello vuoto</div>
    <%
    } 
    else {%>
    <h2 class="minghie">Carrello</h2>
		<table class="tabella">
		<tr>
			<th>Name</th>
			<th>Color</th>
			<th>Size</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>
    <%ArrayList<TShirt> prodcart = cart.getProducts(); 
		   int k=0;
		   for(TShirt beancart: prodcart) {
			   k++;
			   String path="./Immagini/Magliette/Maglietta("+beancart.getidArticolo()+")";
			   if(beancart.getSesso().equalsIgnoreCase("F")){
				   path=path+"F.jpg";
			   }
			   else{
				   path=path+".jpg";
			   }
		%>
		<tr class="riga<%=k%>">
			<td class="colonna"><div><%=beancart.getnome()%></div>
			    <div><img class="maglietta" src=<%=path%>></div></td>
			<td class="colonna"><%=beancart.getColore()%></td>
			<td class="colonna"><%=beancart.getTaglia()%></td>
			<td class="colonna"><%=beancart.getquantita()%></td>
			<td class="colonna"><%=beancart.getprezzo()%></td>
		</tr>
		<%} %>
	</table>
	
    <div class=div_hidden id="form">
        <form action="./?" method="post">
          <input type="hidden" name="action" value="saveCart">
          <label for="Nome" class="input">Nome</label>
          <input class="input" type="text" name="Nome">
          <label for="Cognome" class="input">Cognome</label>
          <input class="input" type="text" name="Cognome">
          <label for="Recapito" class="input">Recapito</label>
          <input class="input" type="text" name="Recapito">
          <label for="Indirizzo" class="input">Indirizzo</label>
          <input class="input" type="text" name="Indirizzo">
          <label for="CAP" class="input">CAP</label>
          <input class="input" type="text" name="CAP">
          <div class="metododipagamento">
                    <div> Seleziona il metodo di pagamento:</div>
                    <select name="Payment" class="Payment">
                        <option value="1">MasterCard</option>
                        <option value="2">Visa</option>
                        <option value="3">PayPal</option>
                        <option value="4">postepay</option>
                        <option value="5">Maestro</option>
                        <option value="6">American Express</option>
                        <option value="7">Discover</option>
                        <option value="8">Aura</option>
                    </select>
                    <div class="Numerocarta">
                    <label for="NumeroCarta" class="input">Numero carta</label>
                    <input class="input" type="text" name="NumeroCarta"> 
                    <label for="NomeUtente" class="hidden">Nome Utente</label>
                    <input class="hidden" type="text" name="nomeutente"> 
                    <label for="Password" class="hidden">Password</label>
                    <input class="hidden" type="text" name="password"> 
                                                    
                    </div>
                </div>
                <button class="input" type="button" onclick="showfattura();">Confermare i dati?</button>
                <%@include file="fattura.jsp" %>
        </form>
    </div>
    <%} %>
    </div>
    <footer>
        <div class="container">
		<div class="row">
			<div class="col1">
					<h2>I più venduti</h2>
				<div class="menu-container">
                    <ul>
                        <li><a href="./?action=uomo">T-Shirt Uomo</a></li>
                        <li><a href="./?action=donna">T-Shirt Donna</a></li>
                    </ul>
                </div>			
            </div>
			<div class="col1">
				<h2>Info</h2>
					<div class="menu-container">
                    <ul>
                        <li><a href="./About">About</a></li>
                        <li><a href="./About">Contattaci</a></li>
                        <li><a href="./Help">Guida alle taglie</a></li>
                        <li><a href="./Help">Tariffe Spedizione</a></li>
                    </ul>
                </div>			
            </div>
			<div class="col1">
				<h2>Segui</h2>
				<div class="menu-container">
                    <ul>
                        <li><a target="_blank" href="https://www.facebook.com/">Facebook</a></li>
                        <li><a target="_blank" href="https://twitter.com/">Twitter</a></li>
                        <li><a target="_blank" href="https://www.tumblr.com/">Tumblr</a></li>
                    </ul>
                </div>			
            </div>
			<div class="col2">
				<div class="CreditCard">
				<img src="Immagini/CreditCard.png">
					<div class="text">
						<p>
						© 2016 Core Shirt S.R.L | P. IVA 01594368721<br>
						All designs copyright by owner.<br>
						<a href="">Privacy Policy</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
    </footer>
</body>
</html>