<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company Home Page</title>
</head>
<body>

	<h2>Welcome to company home page</h2>
	<hr>
	<p>Welcome to company home page</p>
	<hr>
		<!-- Display username and roles -->
		<p>
			User: <security:authentication property="principal.username" />
			<br><br>
			Role (s): <security:authentication property="principal.authorities" />
		</p>
		
		<!-- Add link to /leaders -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for Manager peeps)
		</p>
		
		<!-- Add link to /systems -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for Admin peeps)
		</p>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<button type="submit">Logout</button>
	</form:form>

</body>
</html>