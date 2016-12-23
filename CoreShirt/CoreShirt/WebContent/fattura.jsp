
<div id="veil">
<div id="popup">
		<table class="tabella">
		<tr>
			<th>Name</th>
			<th>Color</th>
			<th>Size</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>
    <%
		   k=0;
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
  <input type="submit" class="submit" value="Acquista">
</div>
</div>