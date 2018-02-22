<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/product" method="get">
					
						
						
						Product Description	<input class="form-control" type="text" name="product_Description"  required="required" />
						
						Product price	<input class="form-control" type="text" name="product_price" required="required" />
						
						Product Name	<input class="form-control" type="text" name="product_name"   required="required" />
						
						
						
						
						
						
						
						
						
						<button type="submit" name="user_submit" id="user_submit" value="1" class="btn btn-register">Register</button>
						
					</form>

</body>
</html>