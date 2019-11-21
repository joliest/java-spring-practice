<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>

</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName"/>
		
		<br><br>
		Last names: <form:input path="lastName"/>
		
		<br><br>
		Country:
		
		<form:select path="country">
			<!-- 
			<form:option value="Brazil" label="Brazil" />
			<form:option value="France" label="France" />
			<form:option value="Germany" label="Germany" />
			<form:option value="India" label="India" />
			or option with an "s"
			-->
			<form:options items="${student.countryOptions}" />
		</form:select>
		
		<br><br>
		
		Courses:
		<form:select path="course">
			<form:options items="${coursesOptions}" />
		</form:select>
		
		<br><br>
		
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>
