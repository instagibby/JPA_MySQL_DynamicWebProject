<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Pet Project</title>
</head>
<body>
	<form action="editPetServlet" method="post">
		<label for="name">Name:</label>
		<input type="text" name="name" value="${petToEdit.name}" id="name">
		<label for="breed">Breed:</label>
		<input type="text" name="breed" value="${petToEdit.breed}" id="breed">
		<input type="hidden" name="id" value="${petToEdit.id}">
		<input type="submit" value="Save Edited Pet">
	</form>
</body>
</html>