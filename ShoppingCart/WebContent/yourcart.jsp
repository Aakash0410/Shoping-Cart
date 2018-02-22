<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    
    <link rel="stylesheet" href="css/main.css" type="text/css"/>
   	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<h1>Your cart</h1>

<table>
  <tr>
  
    <th>Quantity</th>
  
    <th>Name</th>
    <th>Price</th>
    <th>Total</th>
    <th>Action</th>
    
    
  </tr>

 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p" %>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:choose>

  <c:when test="${sessionScope.search1!=null}">

    
     <% int resp = 0;int a=0;%>
   <p:forEach items="${sessionScope.search1}" var="i">
  <tr>
  	  
   <td>
     <form action="Cart" method="get">
        <input type="hidden" name="flag" value="update">
        <input type=text name="quantity" value="${i.quantity}" id="quantity">
        <input type="hidden" name="productId" id="articleId" value="${i.product_id.product_Id}" />
         <input type="submit" value="Update">
     </form>
    </td>
   
     <td>${i.name}</td>
	 <td><input value="${i.price}" readonly></td>
	 <td><input value="${i.price * i.quantity}" readonly > </td>
	<p:set var="test" value="${i.price * i.quantity}" scope="page"/>
	
    <%int test = Integer.parseInt(pageContext.getAttribute("test").toString());
  	resp += test;
  	pageContext.setAttribute("resp", resp);%>
	
    <td>
      <form action="Cart" method="get">
       <input type="hidden" name="productId" 
               value="${i.cart_id}"> 
       <input type="hidden" name="flag" 
               value="remove"> 
        <input type="submit" value="Remove Item">
      </form>
    </td>
  </tr> 
  <p><% a = Integer.parseInt(pageContext.getAttribute("resp").toString());%> </p>
  
  </p:forEach>
  
  <p> Total is:<%=a %></p>
	</c:when>
 
	 <c:otherwise>
 <p>You do not have any items in Cart. Please click on Continue shopping to add your favourite products</p>
	
	</c:otherwise>
</c:choose>

</table>

  


<form action="product" method="post">
  <input type="hidden" name="action" value="shop">
  <input type="submit" value="Continue Shopping">
</form>

<form action="Checkout.jsp" method="get">
  <input type="hidden" name="action" value="checkout">
  <input type="submit" value="Checkout">
</form>


</div>

</body>
</html>