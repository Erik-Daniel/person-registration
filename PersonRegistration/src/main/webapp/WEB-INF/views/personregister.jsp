<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	
		<form action="<%= request.getContextPath() %>/register" method="POST">
			<input type="text" placeholder="Username" name="Name">
			<input type="number" placeholder="Age" name="Age">
			<textarea placeholder="Message" name="Message"></textarea>
			<input type="submit" value="submit">
		</form>
	</div>
</body>
</html>