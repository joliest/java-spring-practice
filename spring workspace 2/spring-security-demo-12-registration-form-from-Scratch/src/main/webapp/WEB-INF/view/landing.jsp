<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>luv2code Landing Page</title>
</head>
<body>
  <h2>luv2code Landing Page</h2>
  <hr>
      <p>
   Welcome to the landing page! This page is open to the public ... no login required :-)
</p>
      <hr>
          <p>
              <a href="${pageContext.request.contextPath}/employees">Access Secure Site (requires login)</a>
          </p>
      </body>
  </html>