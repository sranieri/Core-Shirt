<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="java.util.ArrayList,model.Dipendente,control.manage.ManageDipendente,control.manage.DbConnect,java.sql.*" %>
 
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.Articolo,model.Cart"%>
<html lang="it">
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
    <title>Core Shirt Gestionale: Gestione Dipendenti</title>
    <script src="ajaxDipendenti.js"></script>
    <script src="checkForm.js"></script>
    
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
    <script src="checkForm.js"></script>

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
    <!-- </div>-->
         <article>
    <aside id="aside_bar">

        </aside>
    
    </article>
        
    <article id="articolo">

    </article>
    <div id="corpo" align="center">
    <%!
		ManageDipendente md=new ManageDipendente();
		ArrayList<Dipendente> dipendenti=md.getDipendenti(); 
	%> 		
    	<br>
    	<h3>Inserisci Dipendente</h3>
		<form name="InsertDipendente"  onsubmit="return validateForm()" action="ServletInserisciDipendente" method="post" onsubmit="return validateForm()">
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
			<br><input type="submit"  onsubmit="return validateForm()" value="Inserisci Dipendente">
		</form>

<h3>Modifica Dipendente</h3>


<%
ManageDipendente md=new ManageDipendente();
ArrayList<Dipendente> dipendenti=md.getDipendenti();
	if(dipendenti.size()==0){
		out.print("<b>Non ci sono dipendenti</b");
		
	}else{

%>
<form name="manageDipendente" >
<select name="idDipendente">
<%

for(int i=0;i<dipendenti.size();i++){ %>
	<option value="<%=dipendenti.get(i).getId()%>"><%=dipendenti.get(i).getId()%></option>
	<%}%>
</select><input type="submit" onclick="postComment()"><br><br>
</form>
<form action="GestisciDipendente" method="post">
<%
	String id=request.getParameter("idDipendente");
	if(id=="" || id==null){
		out.print("<b>Seleziona id</b>");
	}else{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coreshirt2","root","Freitag22*");
			PreparedStatement ps=con.prepareStatement("select * from dipendente where idDipendente=?");
			ps.setInt(1,Integer.parseInt(id));
			ResultSet rs=ps.executeQuery();
			while(rs.next()){%>
				
					<input type="hidden" name="id" value="<%=rs.getInt("idDipendente")%>">
				
				Nome<input type="text" name="nome" value="<%=rs.getString("nome")%>"><br><br>
				
				Cognome<input type="text" name="cognome" value="<%=rs.getString("cognome")%>"><br><br>
				CodF<input type="text" name="cf" value="<%=rs.getString("codicefiscale")%>"><br><br>
				Stipendio<input type="text" name="stipendio" value="<%=rs.getString("stipendio")%>"><br><br>
				Tipo<input type="text" name="tipo" value="<%=rs.getString("tipo")%>"><br><br>
				Username<input type="text" name="username" value="<%=rs.getString("username")%>"><br><br>
				Password<input type="text" name="password" value="<%=rs.getString("password")%>"><br><br>
				<input type="submit" onclick="GestisciDipendente" value="Modifica dipendente">
				<button type="submit" name="rimuoviDipendente" onclick="GestisciDipendente" value="<%=rs.getInt("idDipendente")%>">Rimuovi Dipendente</button>
				
				

			<%}%>
			
		<% }catch(Exception e){
			out.print(e);
		}
	}
}
%>
</form>
        </div>

          <img id="loadMore" src="Immagini/arrow.png">
    </div>
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