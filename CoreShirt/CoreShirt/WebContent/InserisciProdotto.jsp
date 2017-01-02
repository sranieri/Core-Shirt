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
    <link rel="stylesheet" href="./CSS/InserisciDipendente.css" type="text/css">
    <link rel="stylesheet" href="./CSS/InserisciProdotto.css" type="text/css">
    <link rel="stylesheet" href="./CSS/thumbnails.css" type="text/css">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt: The Best T-Shirts series</title>
</head>
<body>


<div>     
    <article id="articolo" >
		<script src="checkForm.js"></script>

<%!/*
ManageDipendente md=new ManageDipendente();
ArrayList<Dipendente> dipendenti=md.getDipendenti(); */
%>

<article>
<div id="wrapper">
    <article id="articolo1">
    
    <a href="./"><div id="banner"> <img class="Banner" src="Immagini/prova.png"> 
          <img class="core" src="Immagini/core2.png"></div></a>
 
     </article>
       </div>
        
    <article id="ArticleInserisciDipendente">
    <div id="Amministrazione">
          Area Magazzino
    </div>
      <div>
    <nav>    
            <ul id="Lista">
            <li><a href="./">Home</a> </li>
            <li><a href="./?action=Uomo">Inserisci Prodotto</a></li>
            <li><a href="./?action=Donna">Rimuovi Prodotto</a> </li>
            <li><a href="./About">Evadi Ordine </a></li>
            <li><a href="./Help">Modifica Quantita</a></li>   
            <li><a href="./?action=Donna">Rifornimento Prodotto</a> </li>
 
        </ul>
    </nav>
    </div>

<div id="sezione"> 
<div id="sezione2"> Inserisci Prodotto </div></div>

<div id="form">
<form name="InsertDipendente" action="ServletInsertArticolo?" method="post" onsubmit="return validateForm()">
	Inserisci il Nome
	<input id="nome" type="text" name="nome"><br>
	
	Seleziona Categoria
	<select id="categoria" name="categoria">
       <option value="Cinema">Cinema</option>
       <option value="Geek">Geek</option>
       <option value="Divertenti">Divertenti</option>
       <option value="Manga">Anime e Manga</option>
       <option value="Comics">Comics</option>
       <option value="Nerd">Nerd</option>
   </select><br>
     Iserisci il  Prezzo
	<input id="Prezzo" type="number" cognome"><br>
	
   Seleziona Colore
	<select id="colore" name="colore">
       <option value="black">Nero</option>
       <option value="grey">Grigio</option>
       <option value="white">Bianco</option>
       <option value="green">Verde</option>
       <option value="orange">Arancio</option>
       <option value="red">Rosso</option>
       <option value="purple">Viola</option>
       <option value="blue">Blu</option>
   </select><br>
   Seleziona Taglia
	<select id="taglia" name="taglia">
       <option value="S">S</option>
       <option value="M">M</option>
       <option value="L">L</option>
       <option value="XL">XL</option>
       <option value="XXL">XXL</option>
       <option value="3XL">3XL</option>
       <option value="4XL">4XL</option>
       <option value="5XL">5XL</option>
   </select><br>
	Inserisci Quantita
	<input id="quantita" type="number"><br>
	
	Immagine
	<input type="File" name="nome">
	
	
	
	<br><button id="submit" type="submit" onclick="ServletProdotto" onsubmit="return validateForm()">Aggiungi </button>
</form>
</div>
<br>
</article>
</article>
</article>
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