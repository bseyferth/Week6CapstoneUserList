<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Task Form</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />
</head>
<body>


	<form action="/addTask" method="post">
		<p>
			<label for="description">Description:</label>
			<input id="description" name="description">
		</p>
		<p>
			<label for="dueDate">Due Date:</label>
			<input id="dueDate" name="dueDate">
		</p>
		<p>
			<label for="isComplete">Complete:</label>
			<select id="isComplete" name="isComplete">
  			<option value="1">True</option>
  			<option value="0">False</option>
			</select>
			
		</p>
		<p>
			<button type="submit">Add Task</button>
		</p>
		</form>
		
		<p>
		<a href="/tasklist">Cancel</a>
		</p>
		

</body>
</html>