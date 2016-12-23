<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="UTF-8"%>
 <%@page import="java.util.ArrayList,model.Dipendente,control.ManageDipendente,control.DbConnect" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
    <script src="Script/jquery.js"></script>
    <script src="Script/loadmore.js"></script>
    <link rel="icon" href="./Immagini/sprite0.png" />
    <link rel="stylesheet" href="./CSS/base.css" type="text/css">
    <link rel="stylesheet" href="./CSS/home.css" type="text/css">
    <link rel="stylesheet" href="./CSS/thumbnails.css" type="text/css">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt: The Best T-Shirts series</title>
    <script>
       $(document).ready(function() {
		  $(".element").mouseover(function() {
			 this.animate({
				height : "+=20px",
				width : "+=20px"
				});
			});
		   $(".btn2").click(function() {
			  $("#p1").animate({
				height : "-=20px",
				width : "-=20px"
				});
			});
		});
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
            <li><a href="./?action=Uomo">Uomo </a></li>
            <li><a href="./?action=Donna">Donna </a>
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

        
    <article id="articolo" style="border: 2px solid red; height:150px;">
		<script src="checkForm.js"></script>

<%!/*
ManageDipendente md=new ManageDipendente();
ArrayList<Dipendente> dipendenti=md.getDipendenti(); */
%>
<h3>Inserisci Dipendente</h3>
<form name="InsertDipendente" action="ServletDipendente" method="post" onsubmit="return validateForm()">
	id Dipendente<br>
	<input type="text" name="idDipendente"><br>
	Nome<br>
	<input type="text" name="nome"><br>
	Cognome<br>
	<input type="text" name="cognome"><br>
	Codice Fiscale <br>
	<input type="text" name="codiceFiscale"><br>
	Stipendio <br>
	<input type="text" name="stipendio"><br>
	Tipo<br>
	<input type="text" name="tipo"><br>
	Username<br>
	<input type="text" name="username"><br>
	Password<br>
	<input type="text" name="password"><br>
	<br><button type="submit" onclick="ServletDipendente" onsubmit="return validateForm()">Inserisci</button>
</form>
<br>
<h3>Rimuovi Dipendente</h3><br>

<form  action="ServletDipendente" method="post">

	<select name="DeleteDipendente">

	 		<option value="" selected></option>
	 		<%/*d=dipendenti.get(i);*/%>
	 	
	</select> <button type="submit" onclick="ServletDipendente">Rimuovi</button><br><br>
	</form>
	<form action="ServletDipendente" method="post">
	<input type="hidden" id="id" name="modificaId" value="<">
	Nome <input type="text" name="modificaNome" value=""><br><br>
	Cognome <input type="text" name="modificaCognome" value=""><br><br>
 	Cf <input type="text" name="modificaCf" value=""><br><br>
	Stipendio <input type="text" name="modificaStipendio" value=""><br><br>
	Tipo <input type="text" name="modificaTipo" value=""><br><br>
	Username <input type="text" name="modificaUsername" value=""><br><br>
	Password <input type="text" name="modificaPassword" value=""><br><br>
	 <button type="submit" onclick="ServletDipendente">Modifica</button>
	</form>
    </article>

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