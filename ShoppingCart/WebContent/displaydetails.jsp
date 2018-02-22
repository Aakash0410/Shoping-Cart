<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1> Your Products</h1>

<table border="1">
  <tr>
    <th>Name</th>
    
    <th>Quantity</th>
    <th>Price per unit</th>
   </tr>

 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p" %>
  <p:forEach items="${sessionScope.search}" var="i">
  <tr>
  <td>${i.cart_id.name}</td>
  <td>${i.cart_id.quantity}</td>
  <td>${i.cart_id.price}</td>
  </tr>
  
  
  
  
  </p:forEach>
</table>
</body>
</html>