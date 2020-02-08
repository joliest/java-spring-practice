<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company Home Page</title>
</head>
<body>

<h2>Welcome to company home page</h2>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<button type="submit">Logout</button>
</form:form>

</body>
</html>