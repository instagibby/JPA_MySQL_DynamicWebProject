<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pet-List</title>
</head>
<body>
	<form method="post" action="">
		<table>
			<c:forEach items="${requestScope.owners}" var="currentowner">
				<tr>
			 		<td>${currentowner.id}</td>
					 <td>${currentowner.name}</td>
					 <td>${currentowner.birthday}</td>
					 <td>${currentowner.catoverlordId}</td>
			 	</tr>
			</c:forEach>
		</table>

	</form>
</body>
</html>