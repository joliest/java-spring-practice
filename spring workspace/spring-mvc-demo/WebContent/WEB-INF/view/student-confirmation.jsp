<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Confirmation</title>
</head>
<body>
	The student is confirmed: ${student.firstName} ${student.lastName }
	
	<br><br>
	
	Country: ${student.country}
	
	<br><br>
	Course: ${student.course }
	
	<br><br>
	Favorite programming language: ${student.favoriteLanguage}
	
	<br><br>
	Operating system:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
			<li> ${temp} </li>
		</c:forEach>
	</ul>
</body>
</html>