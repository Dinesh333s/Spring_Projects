<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hi, I am Dinesh
	<form action="addalien" method="post">
		<!--  add is method  name -->
		Alien ID:<input type="text" name="aid"> <br> Alien Name:<input
			type="text" name="aname"> <br> <input type="submit">
		<%--  <form action ="add"> <!--  add is method  name -->
    Enter Num 1:<input type="number" name="num1"> <br>
    Enter Num 2:<input type="number" name="num2" > <br>
    <input  type="submit"> --%>

	</form>

	<hr>
	<form action="showaliens" method="get">
		Enter the ID:<input type="text" name="aid"> 
		<input type="submit">
	</form>
	
	
	<hr>
	<form action="findByName" method="get">
		Enter the Aname:<input type="text" name="aname"> 
		<input type="submit">
	</form>
</body>
</html>