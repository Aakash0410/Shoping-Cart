<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
   
    <link rel="stylesheet" href="css/main.css" type="text/css"/>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>

    
<h1 style="text-align:center;">Product list</h1>
<table align="center">
    <tr>
       
         <th>Image</th>
         <th width="25%">Name</th>
         <th width="50%">Description</th>
         <th align="center" width="8%">Price</th>
         <th> Action</th>
             
    </tr>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p" %>
    <p:forEach items="${sessionScope.search}" var="i">
    <tr>
    
        <td><img src="img/${i.path}"></img></td>
        <td align="right">${i.product_Name}</td> 
	   <td align="center">${i.product_Description}</td>
	   <td align="center">${i.product_Price}</td>
	  
	   
	  <td width="17%" align="center" ><a href="<%=request.getContextPath() %>/Cart?productId=${i.product_Id}&flag=insert"> Add to Cart
	   </a>  
	   </td>
	  
	    
	    
	    
    </tr>
    </p:forEach>
  
</table>
        
</body>
</html>