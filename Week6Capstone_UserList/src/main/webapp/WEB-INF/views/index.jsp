<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />
</head>
<body>

<h1>Task Check-In</h1>


	<p class="message">${ message }</p>
	<form action="/login" method="post">
		<p>
			<label for="email">Email:</label>
			<input id="email" name="email" type="email">
		</p>
		<p>
			<label for="password">Password:</label>
			<input id="password" name="password">
		</p>
		<p>
			<button type="submit">Login</button>
		</p>
		</form>
		<p>
			<a href="/newuser">New User</a>
		</p>
	


</body>
</html>