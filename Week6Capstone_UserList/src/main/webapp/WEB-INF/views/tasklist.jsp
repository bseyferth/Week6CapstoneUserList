<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Task List</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />
</head>
<body>

<p class="message">${ message }</p>
<table class="table">
			<thead>
				<tr>
					<th>Description</th><th>Due Date</th><th>Completed</th><th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${ items }">
					<tr>
						<td>${ item.description }</td>
						<td>${ item.dueDate }</td>
						<td><input type="checkbox" value="true" ${ item.isComplete ? 'checked' : '' }></td>
						<td> <a href="/delete">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
		<a href="/taskaddform"> Add Task</a>
		</p>
		<p>
		<a href="/logout"> Logout</a>
		</p>
		

</body>
</html>